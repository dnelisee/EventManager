package com.polytechnique.finaltppoo2.dao.exceptions;

public class EntityNotFoundException extends RuntimeException {

    /* enum of table of the database. Helps to managa dao exceptions.
     * So, complete it with other table if you add another. 
    */
    public enum EntityName {
        CONFERENCE("Conference"), 
        CONCERT("Concert"), 
        PARTICIPANT("Participant"), 
        ORGANIZER("Organizer"); 

        private final String name; 

        EntityName(String name) {
            this.name = name; 
        }

        public String getName() {
            return this.name; 
        }
    }

    public EntityNotFoundException(EntityName entityName) {
        super(String.format("%s not found in the database", entityName.getName()));
    }
}
