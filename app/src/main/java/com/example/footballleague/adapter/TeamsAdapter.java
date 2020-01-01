package com.example.footballleague.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;
import com.example.footballleague.MainActivity;
import com.example.footballleague.R;
import com.example.footballleague.TeamInformation;
import com.example.footballleague.helper.Utils;
import com.example.footballleague.teamsModel.Team;

import java.util.List;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.TeamsViewHolder> {
    private Context context;
    private List<Team> teams;

    public TeamsAdapter(Context context, List<Team> teams) {
        this.context = context;
        this.teams = teams;
    }

    @NonNull
    @Override
    public TeamsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.teams_row,parent,false);
        return new TeamsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamsViewHolder holder, final int position) {

        final Long id = teams.get(position).getId();
        final String address = teams.get(position).getAddress();
        final String phone = teams.get(position).getPhone();
        final String website = teams.get(position).getWebsite();
        final String shortName = teams.get(position).getShortName();
        final String longName = teams.get(position).getName();
        final String crestUrl = teams.get(position).getCrestUrl();


        try {

            holder.teamLongName.setText(longName);
            holder.teamShortName.setText(shortName);
            Long id1 = teams.get(position).getId();
            if (!crestUrl.endsWith("svg")){
                Glide.with(context).load(crestUrl).into(holder.teamImage);

            }else {
                Utils.fetchSvg(context, crestUrl, holder.teamImage);

            }
        }catch (Exception e){

        }


        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(context, TeamInformation.class);
                intent.putExtra("id", id);
                intent.putExtra("address", address);
                intent.putExtra("phone", phone);
                intent.putExtra("website", website);
                intent.putExtra("image",crestUrl);
                intent.putExtra("name",longName);

                context.startActivity(intent);
            }
        });

        }



    @Override
    public int getItemCount() {
        return teams.size();
    }

    public interface onTeamClickListener{
        void onRowClick(int position);
    }

    public class TeamsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView teamImage;
        TextView teamShortName , teamLongName;
        RelativeLayout parent;
        private onTeamClickListener onTeamClickListener;
        public TeamsViewHolder(@NonNull View itemView) {
            super(itemView);

            teamImage=itemView.findViewById(R.id.team_image);
            teamShortName=itemView.findViewById(R.id.team_short_name);
            teamLongName=itemView.findViewById(R.id.team_long_name);
            parent=itemView.findViewById(R.id.parent_team);
            this.onTeamClickListener = onTeamClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            onTeamClickListener.onRowClick(getAdapterPosition());

        }
    }
}
