# Final TP POO2 
### by DJAHAPPI NZEMBIA Elisée - 3GI/ENSPY

## Notes on the project

### textual description 
We want to create a management application for events (concerts, conferences etc.). 

**Functional needs :** 
- participants registration :   
    We will have a persistence data about all participants of all events. 
    So registration to an event will mean add the participant to the specific event (his id).
    We will present two ways : search in the list of already participants or create a new participant. 
- organizer management : 
    when creating an event, specify the organizer. 
- We will present two ways : search in the list of already organizers or create a new organizer.
- real time notifications : 
    when an event is cancelled or modified, we notify all its participants asynchronously.
- data persistence :
    using json files, we will save all events, all organizers and participants.  

**Class diagram :**
[class diagram](./classDiagram.png)
We consider here that a speaker in a conference is a participant.
### used design pattern 
- Observer : to manage notifications 
- singleton : ... 

### Dependencies
- For data persistence : jakson

