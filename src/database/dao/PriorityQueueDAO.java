package database.dao;

import client.Generator;
import database.FileManager;
import database.OrganizationComparator;
import models.Organization;

import java.time.ZonedDateTime;
import java.util.*;

public final class PriorityQueueDAO implements DAO {
    private static PriorityQueueDAO pqd = new PriorityQueueDAO();
    private static Queue<Organization> collection = new PriorityQueue<>();
    private static Long availableId = 1L;
    private final ZonedDateTime initDate;
    private static OrganizationComparator orgComp;
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
        if (thatOrganization != null){
            collection.remove(thatOrganization);
        }
    }

    @Override
    public void clear() {
        collection.clear();
    }

    @Override
    public Organization get(Long id) {
        return collection.stream().filter(humanBeing -> humanBeing.getId() == id).findFirst().orElse(null);
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
    public Collection<Organization> show() {
        if (collection.isEmpty()) return null;
        return (pqd.getAll());
    }

    @Override
    public void sort(){
        Organization[] organizations = collection.toArray(new Organization[0]);
        Arrays.sort(organizations, orgComp);
        collection.clear();
        collection.addAll(Arrays.asList(organizations));
    }

    @Override
    public void saveCollectionToFile(String output) {
        FileManager.writeCollection(pqd.getAll(), output);
    }

    @Override
    public void readCollection(String input){
        collection = FileManager.readCollection(input);
    }

}
