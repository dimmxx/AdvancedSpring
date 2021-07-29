package org.example;

public class CoronaDisinfector {

    private Announcer announcer = new ConsoleAnnouncerImpl();
    private Policeman policeman = new PolicemanImpl();

    public void start(Room room){
        announcer.announce("Announce: disinfection is starting. Leave the room");
        policeman.makePeopleLeaveRoom();
        disinfect(room);
        announcer.announce("Announce: disinfection is finished. Go back into the room");
    }

    private void disinfect(Room room){
        System.out.println("Disinfection started");
    }




}
