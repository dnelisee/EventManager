package com.polytechnique.finaltppoo2.service;

import java.io.IOException;

import com.polytechnique.finaltppoo2.dao.Repository;
import com.polytechnique.finaltppoo2.model.PersisObject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/*
 * This class implements the business logic related to persisObject 
*/
public class PersisObjectService<V extends PersisObject, T extends V> {

    private Repository<V, T> repo;
    private ObservableList<T> list = FXCollections.observableArrayList();

    public PersisObjectService(Repository<V, T> repo) {
        this.repo = repo;
        list.addAll(repo.getPersisObjects());
    }

    public ObservableList<T> getList() {
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
