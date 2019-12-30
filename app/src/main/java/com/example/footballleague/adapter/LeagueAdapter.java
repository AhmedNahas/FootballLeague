package com.example.footballleague.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footballleague.R;
import com.example.footballleague.TeamsActivity;
import com.example.footballleague.leagueModel.Competition;

import java.util.List;

public class LeagueAdapter extends RecyclerView.Adapter<LeagueAdapter.LeagueViewHolder>{
    private Context context;
    private List<Competition> competitions;
    private Long leagueId;
    private Long id;


    public LeagueAdapter(Context context , List<Competition> competitions) {
        this.context = context;
        this.competitions = competitions;

    }

    @NonNull
    @Override
    public LeagueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.leagues_row,parent,false);
        return new LeagueViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeagueViewHolder holder, int position) {

        for (int i = 0; i < competitions.size(); i++) {
            String area = competitions.get(position).getArea().getName();
            String name = competitions.get(position).getName();
            leagueId = competitions.get(position).getId();
            id = competitions.get(position).getArea().getId();


            holder.longLeagueName.setText(area + " (" +name +  " ) ");

        }
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,TeamsActivity.class);
                intent.putExtra("leagueId",id);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return competitions.size();
    }

    public interface onRowClickListener {
        void onRowClick(int position);

    }

    public class LeagueViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView longLeagueName , teams , matches;
        private RelativeLayout parent;
        private onRowClickListener onRowClickListener;
        public LeagueViewHolder(@NonNull View itemView) {
            super(itemView);

            longLeagueName=itemView.findViewById(R.id.long_league_name);
            teams=itemView.findViewById(R.id.teams);
            matches=itemView.findViewById(R.id.matches);
            parent=itemView.findViewById(R.id.parent_layout);
            this.onRowClickListener= onRowClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            onRowClickListener.onRowClick(getAdapterPosition());

        }
    }
}
