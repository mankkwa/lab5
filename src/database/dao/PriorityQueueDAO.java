package database.dao;

import client.Generator;
import client.Main;
import database.FileManager;
import models.Organization;

import java.time.ZonedDateTime;
import java.util.*;

public final class PriorityQueueDAO implements DAO {
    private static PriorityQueueDAO pqd = new PriorityQueueDAO();
    private static PriorityQueue<Organization> collection = new PriorityQueue<>();
    private static Long availableId = 1L;
    private final ZonedDateTime initDate;
    private static final Generator generator = new Generator();

    public PriorityQueueDAO(){
        initDate = ZonedDateTime.now();
    }

    @Override
    public ZonedDateTime getInitDate(){
        return initDate;
    }

    @Override
    public Long add(Organization organization){
        collection.add(organization);
        generator.generateID(organization);
        generator.generateCreationDate(organization);
        return availableId++;
    }

    @Override
    public void update(Long id, Organization updOrganization) {
        Organization thatOrganization = get(id);
        if (thatOrganization != null) {
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
    public void remove(Long id) {
        Organization thatOrganization = get(id);
        if (thatOrganization!=null){
            collection.remove(thatOrganization);
        }
    }

    @Override
    public void clear() {
        collection.clear();
    }

    @Override
    public Organization get(Long id) {
        for (Organization organization: collection){
            if (Objects.equals(organization.getId(), id)){
                return organization;
            }
        }
        return null;
    }

    @Override
    public Collection<Organization> getAll() {
        return collection;
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Long getAvailableId(){
        return availableId;
    }

    @Override
    public Organization show() {
        return null;
    }

    @Override
    public void sort(){
    }

    public void saveCollectionToFile(String output) {
        FileManager.writeCollection(pqd.getAll(), output);
    }

}
