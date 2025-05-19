package com.polytechnique.finaltppoo2.model;

/* enumeration due to observer design pattern*/
public enum EventState {
    PROGRAMMED("Programmed"),
    CANCELED("Canceled");

    private String stateName;

    EventState(String stateName) {
        this.stateName = stateName;
    }

    public String getStateName() {
        return this.stateName;
    }

    public static EventState fromString(String str) {
        for (EventState state : EventState.values()) {
            if (str.equalsIgnoreCase(state.getStateName())) {
                return state;
            }
        }
        throw new IllegalArgumentException("Unknown state : " + str);
    }
}
