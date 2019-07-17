package com.thacker.logic;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class UserData implements Serializable {

    /**
     * Stores and retrieves user data
     */

    //CHANGE TO SOMETHING LIKE HASHMAP

    public List<User> users = null; ///////////////////MAKE PRIVATE
    private int numUsers;

    public UserData(){
        users = new LinkedList<>();
        this.numUsers = 0;
    }

    public void addUser(String name, int goal){
        users.add(new User(name, ++numUsers, goal, new Date()));
    }

    public User getUser(int index){
        return users.get(index);
    }
}

