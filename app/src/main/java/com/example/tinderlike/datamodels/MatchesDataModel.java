package com.example.tinderlike.datamodels;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.example.tinderlike.models.Matches;

import java.util.HashMap;
import java.util.function.Consumer;

public class MatchesDataModel {

    private DatabaseReference m_Database;
    private HashMap<DatabaseReference, ValueEventListener> listeners;

    public MatchesDataModel() {
        m_Database = FirebaseDatabase.getInstance().getReference();
        listeners = new HashMap<>();
    }

    public void getMatchesItems(Consumer<DataSnapshot> dataChangedCallback, Consumer<DatabaseError> dataErrorCallback) {
        DatabaseReference matchesItemsRef = m_Database.child("matches");
        ValueEventListener matchesItemsListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dataChangedCallback.accept(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                dataErrorCallback.accept(databaseError);

            }
        };
        matchesItemsRef.addValueEventListener(matchesItemsListener);
        listeners.put(matchesItemsRef, matchesItemsListener);
    }

    public void updateMatchesItemById(Matches item) {
        DatabaseReference matchesItemsRef = m_Database.child("matches");
        matchesItemsRef.child(item.uid).setValue(item);
    }

    public void clear() {
        // Clear all the listeners onPause
        listeners.forEach(Query::removeEventListener);
    }

}