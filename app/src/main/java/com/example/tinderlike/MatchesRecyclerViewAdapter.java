package com.example.tinderlike;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tinderlike.models.Matches;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MatchesRecyclerViewAdapter extends RecyclerView.Adapter<MatchesRecyclerViewAdapter.ViewHolder> {
    private final List<Matches> m_Values;
    private final FragmentMatches.OnListFragmentInteractionListener m_Listener;

    public MatchesRecyclerViewAdapter(List<Matches> items, FragmentMatches.OnListFragmentInteractionListener listener) {
        m_Values = items;
        m_Listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.matches_fragment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.m_Item = m_Values.get(position);
        holder.m_ImgUrl = m_Values.get(position).imageUrl; // get image URL from object
        Picasso.get().load(holder.m_ImgUrl).into(holder.m_Image); // set image url into ImageView
        holder.m_Name.setText(m_Values.get(position).name);
        holder.liked = m_Values.get(position).liked;

        if (!holder.liked) {
            holder.like_Btn.setColorFilter(Color.GRAY);
        } else {
            holder.like_Btn.setColorFilter(Color.RED);
        }

        holder.like_Btn.setOnClickListener(v -> {
            if (null != m_Listener) {
                // Notify the active callbacks interface (the activity, if the
                // fragment is attached to one) that an item has been selected.
                if (!holder.liked) {
                    Toast.makeText(holder.m_View.getContext(), "You liked " + m_Values.get(position).name, Toast.LENGTH_LONG).show();
                    holder.like_Btn.setColorFilter(Color.RED);
                } else {
                    holder.like_Btn.setColorFilter(Color.GRAY);
                }
                m_Listener.onListFragmentInteraction(holder.m_Item);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(m_Values != null) {
            return m_Values.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View m_View;
        public final TextView m_Name;
        public final ImageView m_Image;
        public final ImageButton like_Btn;
        public String m_ImgUrl;
        public Matches m_Item;
        public Boolean liked;

        public ViewHolder(View view) {
            super(view);
            m_View = view;
            m_Name = view.findViewById(R.id.card_title);
            m_Image = view.findViewById(R.id.card_image);
            like_Btn = view.findViewById(R.id.favorite_button);
        }
    }
}