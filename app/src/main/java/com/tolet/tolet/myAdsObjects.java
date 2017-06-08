package com.tolet.tolet;

/**
 * Created by dipto on 6/8/17.
 */

public class myAdsObjects{
    private String location;
    private String houseNumber;
    private String roadNumber;
    private String floor;
    private String size;
    private String rooms;
    private String beds;
    private String baths;
    private String flatType;
    private boolean hasLift;
    private boolean hasParking ;
    private String rent;
    private String description;


    public myAdsObjects(String location, String houseNumber, String roadNumber,
                        String floor, String size, String rooms, String beds,
                        String baths, String flatType, boolean hasLift,
                        boolean hasParking, String rent, String description) {
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

    public boolean isHasLift() {
        return hasLift;
    }

    public boolean isHasParking() {
        return hasParking;
    }

    public String getRent() {
        return rent;
    }

    public String getDescription() {
        return description;
    }
}
