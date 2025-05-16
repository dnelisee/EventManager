package com.polytechnique.finaltppoo2.model;

public interface ObservableEvent {
    void addObserver(ParticipantObserver observer);
    void removeObserver(ParticipantObserver observer);
}
