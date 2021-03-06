# SpringBoot-SOAP-Client-Example
A Demo SOAP Client made by Spring Boot.<br/>
Free WebService fetched from : <a href="www.webservicex.net">www.webservicex.net</a><br/>
Used in this project : <a href="http://www.webservicex.net/New/Home/ServiceDetail/56">http://www.webservicex.net/New/Home/ServiceDetail/56</a><br/>
SOAP WSDL : http://www.webservicex.net/globalweather.asmx?WSDL<br/>
Project URL : http://localhost:8080/<br/>
IDE Used : IntelliJ IDEA 2016.2.5<br/><br/>
<b>Java Version Used :</b> 1.8<br/><br/>
<b>Dependencies (Maven) :</b><br/>
- webjars (Bootstrap)
- jaxb-impl
- Thymeleaf
- Web
<br/><br/>
<b>pom.xml</b>

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.priyam</groupId>
    <artifactId>springbootsoapclientexample</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>jar</packaging>

    <name>SpringBootSOAPClientExample</name>
    <description>Demo project - Sample SOAP client using Spring Boot, Thymeleaf and Bootstrap</description>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.5.1.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.webjars</groupId>
            <artifactId>bootstrap</artifactId>
            <version>3.3.1</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.webjars</groupId>
            <artifactId>bootstrap</artifactId>
            <version>3.3.1</version>
        </dependency>
        <dependency>
            <groupId>com.sun.xml.bind</groupId>
            <artifactId>jaxb-impl</artifactId>
            <version>2.2.7</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>


</project>
```
