package com.example.tinderlike;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tinderlike.models.Matches;
import com.example.tinderlike.viewmodels.MatchesViewModel;

import java.util.ArrayList;


/**
 * Providing the UI for the view with Cards.
 */


public class FragmentMatches extends Fragment {

    private OnListFragmentInteractionListener m_Listener;
    private RecyclerView view;

    public FragmentMatches(){

    }

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);

        MatchesViewModel viewModel = new MatchesViewModel();

        viewModel.getMatchesItems(
                (ArrayList<Matches> matches) -> {

                    MatchesRecyclerViewAdapter adapter = new MatchesRecyclerViewAdapter(matches, m_Listener);
                    view.setAdapter(adapter);
                    view.setHasFixedSize(true);

                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

                    view.setLayoutManager(layoutManager);
                }
        );

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnListFragmentInteractionListener){
            m_Listener = (OnListFragmentInteractionListener) context;
        } else{
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        m_Listener = null;
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Matches item);
    }
}
