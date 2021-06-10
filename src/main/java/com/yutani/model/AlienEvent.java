package com.yutani.model;

public class AlienEvent {
    
    private long id;

    private int longitude;

    private int latitude;

    private String alientName;

    private String dangerType;


    public String getDangerType() {
        return dangerType;
    }

    public void setDangerType(String dangerType) {
        this.dangerType = dangerType;
    }

    public String getAlientName() {
        return alientName;
    }

    public void setAlientName(String alientName) {
        this.alientName = alientName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "AlientEvent [alientName=" + alientName + ", dangerType=" + dangerType + ", id=" + id + ", latitude="
                + latitude + ", longitude=" + longitude + "]";
    }

}
