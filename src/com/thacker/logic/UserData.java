package com.thacker.logic;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class UserData {

    /**
     * Stores and retrieves user data
     */

    private List<User> users = null;
    private int numUsers;

    public UserData(){
        users = new LinkedList<>();
        this.numUsers = 0;
    }

    public void addUser(String name, int goal){
        users.add(new User(name, ++numUsers, goal, new Date()));
    }

}

class User{

    /**
     * Class that will contain each individual user's data
     */

    //NOTE replace with a floating point value
    private List<Weight> weights = null;
    private String name = null;
    private Date dateCreated = null;
    private int userID;
    private int goal;
    private int totalWeights;

    public User(String name, int userID, int goal, Date dateCreated){
        weights = new LinkedList<>();
        this.name = name;
        this.goal = goal;
        this.userID = userID;
        this.totalWeights = 0;
        this.dateCreated = dateCreated;
    }

    public void addWeight(Integer weight){
        weights.add(new Weight(weight));
        totalWeights++;
    }

    class Weight{

        /**
         * Class stores a single weight along with the date which it was entered
         */

        private int weight;
        private Date date;

        public Weight(int weight){
            this.weight = weight;
            this.date = new Date();
        }
    }
}
