package com.example.othello;

public class room {

    private String room_name;
    private String head;
    private String load;

    public room(String room_name, String head, String load){
        this.room_name = room_name;
        this.head = head;
        this.load = load;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getLoad() {
        return load;
    }

    public void setLoad(String load) {
        this.load = load;
    }
}
