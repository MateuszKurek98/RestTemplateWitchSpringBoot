package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.itunes.proxy.ItunesProxy;
import org.example.itunes.service.ItunesMapper;
import org.example.itunes.service.ItunesService;
import org.example.sampleshawnmendes.proxy.SampleShawnMendesServerProxy;
import org.example.sampleshawnmendes.service.ShawnMendesService;
import org.example.sampleshawnmendes.service.ShawnMendesServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@ComponentScan
public class RestemplateApplication {
    public static void main(String[] args){
        //JEST TO KONTEKST SPRINGA
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(
                RestemplateApplication.class);
        MainApplicationRunner runner = annotationConfigApplicationContext.getBean(MainApplicationRunner.class);
        runner.run();
    }
}
