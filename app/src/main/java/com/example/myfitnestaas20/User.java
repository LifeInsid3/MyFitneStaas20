package com.example.myfitnestaas20;

public class User {
    String name, lastMessage, lastMessageTime, phoneNo, country, info;
    int imageId;

    public User(String name, String lastMessage, String lastMessageTime,
                String phoneNo, String country, String info, int imageId){
        this.name = name;
        this.lastMessage = lastMessage;
        this.lastMessageTime = lastMessageTime;
        this.phoneNo = phoneNo;
        this.country = country;
        this.imageId = imageId;
        this.info = info;
    }
}