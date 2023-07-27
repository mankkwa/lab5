package database.dao;

import models.Organization;

import java.time.ZonedDateTime;
import java.util.PriorityQueue;
import java.util.*;

public final class PriorityQueueDAO implements DAO {
    private static int availableId = 1;
    private final ZonedDateTime initDate;
    public static PriorityQueue<Organization> organizations = new PriorityQueue<>();

    public PriorityQueueDAO(){
        initDate = ZonedDateTime.now();
    }

    @Override
    public ZonedDateTime getInitDate(){
        return initDate;
    }

    @Override
    public int add(Organization newOrganization){
        organizations.add(newOrganization);

        return availableId++;
    }

    @Override
    public void update(int id, Organization organization) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Organization get(int id) {
        return null;
    }

    @Override
    public Collection<Organization> getAll() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int getAvailableId(){
        return availableId;
    }

    @Override
    public Organization show() {
        return null;
    }

    @Override
    public void sort() {

    }

}
