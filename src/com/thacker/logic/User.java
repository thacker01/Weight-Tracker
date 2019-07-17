package com.thacker.logic;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class User implements Serializable {

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

    public String getName(){
        return this.name;
    }

    public Date getDateCreated(){
        return this.dateCreated;
    }

    public int getUserID(){
        return this.userID;
    }

    public int getGoal(){
        return this.goal;
    }

    public int getTotalWeights(){
        return this.totalWeights;
    }

    public void addWeight(Integer weight){
        weights.add(new Weight(weight));
        totalWeights++;
    }

    class Weight implements Serializable{

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
