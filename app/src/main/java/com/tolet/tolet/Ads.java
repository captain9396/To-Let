package com.tolet.tolet;

/**
 * Created by dipto on 6/6/17.
 */

public class Ads {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ads(int id, String username, String password, String location, String houseNumber, String roadNumber, String floor, String size, String rooms, String beds, String baths, String flatType, String hasLift, String hasParking, String rent, String description) {

        this.id = id;
        this.username = username;
        this.password = password;
        this.location = location;
        this.houseNumber = houseNumber;
        this.roadNumber = roadNumber;
        this.floor = floor;
        this.size = size;
        this.rooms = rooms;
        this.beds = beds;
        this.baths = baths;
        this.flatType = flatType;
        this.hasLift = hasLift;
        this.hasParking = hasParking;
        this.rent = rent;
        this.description = description;
    }

    private String username;
    private String password;
    private String location;
    private String houseNumber;
    private String roadNumber;
    private String floor;
    private String size;
    private String rooms;
    private String beds;
    private String baths;
    private String flatType;
    private String hasLift;
    private String hasParking ;
    private String rent;
    private String description;

    public Ads(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Ads(String username, String password,
               String location, String houseNumber,
               String roadNumber, String floor,
               String size, String rooms, String beds,
               String baths, String flatType, String hasLift,
               String hasParking, String rent, String description) {
        this.username = username;
        this.password = password;
        this.location = location;
        this.houseNumber = houseNumber;
        this.roadNumber = roadNumber;
        this.floor = floor;
        this.size = size;
        this.rooms = rooms;
        this.beds = beds;
        this.baths = baths;
        this.flatType = flatType;
        this.hasLift = hasLift;
        this.hasParking = hasParking;
        this.rent = rent;
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setRoadNumber(String roadNumber) {
        this.roadNumber = roadNumber;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getHasLift() {
        return hasLift;
    }

    public void setHasLift(String hasLift) {
        this.hasLift = hasLift;
    }

    public String getHasParking() {
        return hasParking;
    }

    public void setHasParking(String hasParking) {
        this.hasParking = hasParking;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    public void setBeds(String beds) {
        this.beds = beds;
    }

    public void setBaths(String baths) {
        this.baths = baths;
    }

    public void setFlatType(String flatType) {
        this.flatType = flatType;
    }


    public void setRent(String rent) {
        this.rent = rent;
    }

    public void setDescription(String description) {
        this.description = description;
    }






    ////////getters

    public String getLocation() {
        return location;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getRoadNumber() {
        return roadNumber;
    }

    public String getFloor() {
        return floor;
    }

    public String getSize() {
        return size;
    }

    public String getRooms() {
        return rooms;
    }

    public String getBeds() {
        return beds;
    }

    public String getBaths() {
        return baths;
    }

    public String getFlatType() {
        return flatType;
    }



    public String getRent() {
        return rent;
    }

    public String getDescription() {
        return description;
    }
}


class SingletonAd{
    private static SingletonAd singletonAd = new SingletonAd();
    Ads ad;
    private SingletonAd(){}

    public Ads getAd() {
        return ad;
    }

    public void setAds(Ads ad) {
        this.ad = ad;
    }

    public static SingletonAd getInstance(){ return singletonAd; }

}