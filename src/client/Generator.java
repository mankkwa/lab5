package client;

import models.Organization;

import java.time.ZonedDateTime;

/**
 * Класс для генерации айдишника
 */
public class Generator {
    private static int availableId = 1;

    public void generateID(Organization org){
        org.setId((long) availableId++);
    }

    public void generateCreationDate(Organization org){
        org.setCreationDate(ZonedDateTime.now());
    }
}
