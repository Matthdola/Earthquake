package com.example.android.quakereport;

import java.util.Date;

public class EarthQuake {

    private String mUrl;

    /** Magnitude of the earthquake */
    private double magnitude;

    /** Location of the earthquake */
    private String earthPlace;

    /** Date of the earthquake */
    private long earthDate;

    /**
     * Constructors a new {@link EarthQuake} object
     * @param magnitute is the magnitude (size) of the earthquake
     * @param place is the city location of the earthquake
     * @param date is the date the earthquake happened
     */
    public EarthQuake(double magnitute, String place, long date, String url){
        this.magnitude = magnitute;
        this.earthPlace = place;
        this.earthDate = date;
        this.mUrl = url;
    }

    /**
     * Return the magnitude of the earthquake
     * @return
     */
    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    /**
     * Return the location of the earthquake
     * @return
     */
    public String getEarthPlace() {
        return earthPlace;
    }

    public void setEarthPlace(String earthPlace) {
        this.earthPlace = earthPlace;
    }

    /**
     * Return the date of the earthquake
     * @return
     */
    public long getEarthDate() {
        return earthDate;
    }

    public void setEarthDate(long earthDate) {
        this.earthDate = earthDate;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }
}
