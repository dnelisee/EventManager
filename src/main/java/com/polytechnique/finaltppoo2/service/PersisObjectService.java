package com.polytechnique.finaltppoo2.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.polytechnique.finaltppoo2.dao.Repository;
import com.polytechnique.finaltppoo2.model.PersisObject;


/*
 * This class implements the business logic related to persisObject 
*/
public class PersisObjectService<V extends PersisObject, T extends V> {

    private Repository<V, T> repo;
    private List<T> list;

    public PersisObjectService(Repository<V, T> repo) {
        this.repo = repo;
        list = new ArrayList<>();
        list.addAll(repo.getPersisObjects());
    }

    public List<T> getList() {
        return list;
    }

    public void addPersisObject(T persisObject) throws IOException {
        repo.createPersisObject(persisObject);
        list.add(persisObject);
    }

    public void removePersisObject(T persisObject) {
        repo.deletePersisObject(persisObject);
        list.remove(persisObject);
    }

}
