package com.example.footballleague;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.footballleague.Service.RetrofitClient;
import com.example.footballleague.Service.WebService;
import com.example.footballleague.adapter.PlayerInformationAdapter;
import com.example.footballleague.helper.Utils;
import com.example.footballleague.singleTeamModel.SingleTeamInfo;
import com.example.footballleague.singleTeamModel.Squad;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamInformation extends AppCompatActivity {
    ImageView teamLogo;
    TextView teamAddress , teamPhone , teamWebsite , clubName;
    RecyclerView teamInfoRv;
    private static final String TOKEN = "ac1581b7e82d44429e977f775e8d5e56";
    private PlayerInformationAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_information);

        teamLogo=findViewById(R.id.team_logo);
        teamAddress=findViewById(R.id.team_address);
        teamPhone=findViewById(R.id.team_phone);
        teamWebsite=findViewById(R.id.team_website);
        teamInfoRv=findViewById(R.id.player_infoRv);
        clubName=findViewById(R.id.club_name);

        Intent intent = getIntent();
        String address = intent.getStringExtra("address");
        String phone = intent.getStringExtra("phone");
        String website = intent.getStringExtra("website");
        String name = intent.getStringExtra("name");
        String image = intent.getStringExtra("image");
        long id = intent.getLongExtra("id", 0);

        teamAddress.setText(address);
        teamPhone.setText(phone);
        teamWebsite.setText(website);
        clubName.setText(name);
        if (image==null) {
            Glide.with(this).load(R.drawable.not).into(teamLogo);


        }else{
            if (!image.endsWith("svg")) {
                Glide.with(this).load(image).into(teamLogo);

            } else {
                Utils.fetchSvg(this, image, teamLogo);

            }
        }
        RetrofitClient.getINSTANCE().create(WebService.class).getTeamInfo(TOKEN,id).enqueue(new Callback<SingleTeamInfo>() {
            @Override
            public void onResponse(Call<SingleTeamInfo> call, Response<SingleTeamInfo> response) {
                List<Squad> squad = response.body().getSquad();
                adapter=new PlayerInformationAdapter(TeamInformation.this,squad);
                teamInfoRv.setLayoutManager(new LinearLayoutManager(TeamInformation.this));
                teamInfoRv.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<SingleTeamInfo> call, Throwable t) {

            }
        });


    }
}
