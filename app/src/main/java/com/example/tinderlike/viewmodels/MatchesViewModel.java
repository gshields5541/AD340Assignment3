package com.example.tinderlike.viewmodels;

import com.example.tinderlike.datamodels.MatchesDataModel;
import com.google.firebase.database.DataSnapshot;
import com.example.tinderlike.models.Matches;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MatchesViewModel {

    private MatchesDataModel matchesModel;

    public MatchesViewModel() {
        matchesModel = new MatchesDataModel();
    }

    public void getMatchesItems(Consumer<ArrayList<Matches>> responseCallback) {
        matchesModel.getMatchesItems(
                (DataSnapshot dataSnapshot) -> {
                    ArrayList<Matches> matchesArr = new ArrayList<>();
                    for (DataSnapshot matchesSnapshot : dataSnapshot.getChildren()) {
                        Matches item = matchesSnapshot.getValue(Matches.class);
                        assert item != null;
                        item.uid = matchesSnapshot.getKey();
                        matchesArr.add(item);
                    }
                    responseCallback.accept(matchesArr);
                },
                (databaseError -> System.out.println("Error reading Matches Items: " + databaseError))
        );
    }

    public void updateMatchesItem(Matches item) {
        matchesModel.updateMatchesItemById(item);
    }

    public void clear() {
        matchesModel.clear();
    }
}