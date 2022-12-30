package com.ca.formation.formation_demo1.services;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import static org.hibernate.internal.CoreLogging.logger;

@Component
@EnableAsync
public class SchedulePersonneExportService {
    Logger logger= (Logger) LoggerFactory.getLogger(SchedulePersonneExportService.class);

    //@Async
    //@Scheduled(fixedDelay = 10000)
    public void envoyerListePersonnes(){


        logger.info(" Envoyer la liste des personne - " + System.currentTimeMillis() / 1000);
    }
}
