package com.polytechnique.finaltppoo2.model;

public class Participant implements ParticipantObserver{
    private String id;
    private String name;
    private String email;



    @Override
    public void update(Event.EventState state) {

    }
}
