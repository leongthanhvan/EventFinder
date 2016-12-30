package vn.edu.poly.eventfinder.daos;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import vn.edu.poly.eventfinder.entities.User;

/**
 * Created by nix on 12/29/16.
 */

public class UserDAO {

    private FirebaseUser user;
    private DatabaseReference mDatabase;

    public UserDAO() {
        this.user = FirebaseAuth.getInstance().getCurrentUser();
        this.mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public String getCurrentUserUID() {
        return user.getUid();
    }

    public void writeUser(User user) {
        mDatabase.child("user").child(getCurrentUserUID()).setValue(user);
    }
}
