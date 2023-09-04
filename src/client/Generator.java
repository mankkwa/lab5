package client;

import models.Organization;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * Класс для генерации айдишника
 */
public class Generator {

    public void generateID(Organization org){
        org.setId(Long.valueOf(UUID.randomUUID().toString()));
    }

    public void generateCreationDate(Organization org){
        org.setCreationDate(ZonedDateTime.now());
    }
}
