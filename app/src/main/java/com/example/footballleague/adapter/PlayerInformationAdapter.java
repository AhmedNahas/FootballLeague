package com.example.footballleague.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footballleague.R;
import com.example.footballleague.singleTeamModel.Squad;

import java.util.List;

public class PlayerInformationAdapter extends RecyclerView.Adapter<PlayerInformationAdapter.PlayerViewHolder> {

    private Context context;
    private List<Squad> squad;

    public PlayerInformationAdapter(Context context, List<Squad> squad) {
        this.context = context;
        this.squad = squad;
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.player_information,parent,false);
        return new PlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {
        String playerName = squad.get(position).getName();
        String playerPosition = squad.get(position).getPosition();
        String playerNationality = squad.get(position).getNationality();

        holder.name.setText("Player Name : " + playerName);
        holder.position.setText("Player Position : " + playerPosition);
        holder.nationality.setText("Player Nationaliity : " + playerNationality);


    }

    @Override
    public int getItemCount() {
        return squad.size();
    }

    public class PlayerViewHolder extends RecyclerView.ViewHolder {
        private TextView name , position , nationality;

        public PlayerViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.player_name);
            position=itemView.findViewById(R.id.player_position);
            nationality=itemView.findViewById(R.id.player_nationality);
        }
    }
}
