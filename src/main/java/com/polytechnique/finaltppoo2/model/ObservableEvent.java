package com.polytechnique.finaltppoo2.model;

public interface ObservableEvent {
    void addObserver(EventObserver observer);
    void removeObserver(EventObserver observer);
    void notifyObserver();
}
