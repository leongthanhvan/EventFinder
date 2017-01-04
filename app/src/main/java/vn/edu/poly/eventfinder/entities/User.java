package vn.edu.poly.eventfinder.entities;

import com.google.android.gms.maps.model.LatLng;

public class User {
    private LatLng userPosition;
    private String tel;

    public User() {
    }

    public User(LatLng userPosition, String tel) {
        this.userPosition = userPosition;
        this.tel = tel;
    }

    public LatLng getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(LatLng userPosition) {
        this.userPosition = userPosition;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
