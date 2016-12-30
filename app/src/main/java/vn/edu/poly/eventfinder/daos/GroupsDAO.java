package vn.edu.poly.eventfinder.daos;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import vn.edu.poly.eventfinder.entities.Groups;

public class GroupsDAO {
    private DatabaseReference mDatabase;

    public GroupsDAO() {
        this.mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public int getGroupCount() {
        final int[] i = {-1};
        mDatabase.child("GroupCount").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Groups value = dataSnapshot.getValue(Groups.class);
                i[0] = value.getCount();
                Log.d("ReadDB", "Value is: " + i[0]);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("ReadDB", "Failed to read value.", error.toException());
            }
        });
        return i[0];
    }

    public void writeGroupCountOnDatabase(int i) {
        Groups groups = new Groups();
        groups.setCount(i);
        mDatabase.child("GroupCount").setValue(groups);
    }

    public int increaseGroupCount() {
        int i = getGroupCount();
        return ++i;
    }
}
