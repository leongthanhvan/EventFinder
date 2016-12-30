package vn.edu.poly.eventfinder.entities;

import com.google.android.gms.maps.model.LatLng;

public class User {
    private LatLng userPosition;

    public User() {
    }

    public User(LatLng userPosition) {
        this.userPosition = userPosition;
    }

    public LatLng getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(LatLng userPosition) {
        this.userPosition = userPosition;
    }
}
