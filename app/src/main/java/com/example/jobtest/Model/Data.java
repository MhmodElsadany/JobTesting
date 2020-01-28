
package com.example.jobtest.Model;

import java.util.List;

import com.example.jobtest.Model.Events;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("attractions")
    @Expose
    private List<Attraction> attractions = null;
    @SerializedName("events")
    @Expose
    private List<Events> events = null;
    @SerializedName("hot_spots")
    @Expose
    private List<HotSpot> hotSpots = null;

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    public List<Events> getEvents() {
        return events;
    }

    public void setEvents(List<Events> events) {
        this.events = events;
    }

    public List<HotSpot> getHotSpots() {
        return hotSpots;
    }

    public void setHotSpots(List<HotSpot> hotSpots) {
        this.hotSpots = hotSpots;
    }

}
