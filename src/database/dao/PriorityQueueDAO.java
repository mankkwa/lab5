package database.dao;

import client.Generator;
import models.Organization;

import java.time.ZonedDateTime;
import java.util.*;

public final class PriorityQueueDAO implements DAO {
    private final PriorityQueue<Organization> collection = new PriorityQueue<>();
    private static int availableId = 1;
    private final ZonedDateTime initDate;
    private final Generator generator = new Generator();

    public PriorityQueueDAO(PriorityQueueDAO organizations){
        initDate = ZonedDateTime.now();
    }

    @Override
    public ZonedDateTime getInitDate(){
        return initDate;
    }

    @Override
    public int add(Organization organization){
        collection.add(new Organization(availableId,
                organization.getName(),
                organization.getCoordinates(),
                organization.getCreationDate(),
                organization.getAnnualTurnover(),
                organization.getType(),
                organization.getEmployeesCount(),
                organization.getPostalAddress(),
                organization.getFullName()));
        return availableId++;
    }

    @Override
    public void update(int id, Organization updOrganization) {
        Organization thatOrganization = get(id);
        if (thatOrganization.getId() == id) {
            thatOrganization.setName(updOrganization.getName());
            thatOrganization.setCoordinates(updOrganization.getCoordinates());
            thatOrganization.setCreationDate(updOrganization.getCreationDate());
            thatOrganization.setAnnualTurnover(updOrganization.getAnnualTurnover());
            thatOrganization.setFullName(updOrganization.getFullName());
            thatOrganization.setEmployeesCount(updOrganization.getEmployeesCount());
            thatOrganization.setType(updOrganization.getType());
            thatOrganization.setPostalAddress(updOrganization.getPostalAddress());
        }
    }

    @Override
    public void remove(int id) {
        Organization thatOrganization = get(id);
        if (thatOrganization!=null){
            collection.remove(thatOrganization);
        }
    }

    @Override
    public Organization get(int id) {
        for (Organization organization: collection){
            if (organization.getId()==id){
                return organization;
            }
        }
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
