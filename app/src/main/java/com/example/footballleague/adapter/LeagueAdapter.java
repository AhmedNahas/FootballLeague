package com.example.footballleague.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footballleague.R;
import com.example.footballleague.TeamsActivity;
import com.example.footballleague.dbHelper.LeagueContract;
import com.example.footballleague.dbHelper.LeagueHelper;
import com.example.footballleague.leagueModel.Competition;

import java.util.ArrayList;
import java.util.List;


public class LeagueAdapter extends RecyclerView.Adapter<LeagueAdapter.LeagueViewHolder>{
    private Context context;
    private List<Competition> competitions;
    private List<Competition> comp;
    String searchText ="";

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


            String area = competitions.get(position).getArea().getName();
            String name = competitions.get(position).getName();
            id = competitions.get(position).getArea().getId();


            holder.longLeagueName.setText(Html.fromHtml(area));
        int length = searchText.length();

        if (length>0){
                int index = area.indexOf(searchText);


                    SpannableStringBuilder sb = new SpannableStringBuilder(area);
                    ForegroundColorSpan fcs = new ForegroundColorSpan(Color.RED);
                    sb.setSpan(fcs,0,length, Spannable.SPAN_MARK_MARK);
//                    index = area.indexOf(searchText,index+1);

                    holder.shortLeagueName.setText(sb);



            }else {
                holder.shortLeagueName.setText(Html.fromHtml(area));

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
        private TextView longLeagueName , shortLeagueName , notAvailable;
        private LinearLayout parent;
        private onRowClickListener onRowClickListener;
        public LeagueViewHolder(@NonNull View itemView) {
            super(itemView);

            longLeagueName=itemView.findViewById(R.id.long_league_name);
            shortLeagueName=itemView.findViewById(R.id.short_league_name);
            parent=itemView.findViewById(R.id.parent_layout);
            notAvailable=itemView.findViewById(R.id.unavailable);

            this.onRowClickListener= onRowClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            onRowClickListener.onRowClick(getAdapterPosition());

        }
    }
    public void setFilter(List<Competition> countryModels,String searchText) {
        comp = new ArrayList<>();
        comp.addAll(countryModels);
        this.searchText = searchText;
        notifyDataSetChanged();
    }
}

