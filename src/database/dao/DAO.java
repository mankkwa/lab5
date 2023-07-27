package database.dao;

import models.Organization;

import java.time.ZonedDateTime;
import java.util.Collection;
public interface DAO {
    int add(Organization organization);
    void update(int id, Organization organization);
    void remove(int id);
    Organization get(int id);
    Collection<Organization> getAll();
    int size();
    int getAvailableId();
    Organization show();
    void sort();
    ZonedDateTime getInitDate();
}
