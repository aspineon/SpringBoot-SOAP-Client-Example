package com.priyam.controller;

import com.priyam.entity.NewDataSet;
import com.priyam.entity.Table;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import webservicex.com.global.weather.wsdl.GlobalWeather;
import webservicex.com.global.weather.wsdl.GlobalWeatherSoap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by PRIYAM on 15/2/2017.
 */


@Controller
public class MainController {

    Logger log = Logger.getLogger(MainController.class.getName());

    private final static String STR_URL_="http://www.webservicex.net/globalweather.asmx?WSDL";

    @GetMapping(value = "/")
    public String showHomePage(){
        return "index";
    }


    @PostMapping(value = "/getCities")
    public String getCitiesByCountry(@RequestParam String country, Model model) throws JAXBException {

        String response=null;
        GlobalWeatherSoap port=portInit();
        if(port!=null){

            response=port.getCitiesByCountry(country);
            if(response==null || response.compareTo("")==0){
                return "error";
            }

            log.info("Init Response : "+response);

            response=response.replaceAll("string","");
            log.info("Modified response : "+response);

            JAXBContext jaxbContext = JAXBContext.newInstance(NewDataSet.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            StringReader reader = new StringReader(response);
            NewDataSet cities = (NewDataSet) unmarshaller.unmarshal(reader);

            for(Table table:cities.getTableList()){
                log.info("City : "+table.getCity());
            }

            model.addAttribute("cities",cities.getTableList());
            model.addAttribute("country",country.substring(0,1).toUpperCase()+country.substring(1));

        }else{
            return "error";
        }

        return "result";

    }

    private GlobalWeatherSoap portInit(){
        GlobalWeatherSoap port=null;
        try {
            URL url=new URL(STR_URL_);
            GlobalWeather globalWeather=new GlobalWeather(url);
            port=globalWeather.getGlobalWeatherSoap();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            log.error(e.toString(),e);
        }

        return port;

    }

}
