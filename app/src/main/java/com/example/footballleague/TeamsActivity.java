package com.example.footballleague;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.footballleague.Service.RetrofitClient;
import com.example.footballleague.Service.WebService;
import com.example.footballleague.adapter.TeamsAdapter;
import com.example.footballleague.teamsModel.Team;
import com.example.footballleague.teamsModel.TeamsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamsActivity extends AppCompatActivity {

    private static final String TOKEN = "ac1581b7e82d44429e977f775e8d5e56";
    private long leagueId = 0;
    private TeamsAdapter teamsAdapter;
    private RecyclerView teamsRv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);
        teamsRv=findViewById(R.id.teams_rv);

        Intent intent = getIntent();
        leagueId = intent.getLongExtra("leagueId", 0);

        RetrofitClient.getINSTANCE().create(WebService.class).getTeams(TOKEN,leagueId).enqueue(new Callback<TeamsResponse>() {
            @Override
            public void onResponse(Call<TeamsResponse> call, Response<TeamsResponse> response) {

                if (response.body()==null){

                    Toast.makeText(TeamsActivity.this,"No data Available", Toast.LENGTH_SHORT).show();


                }else{
                    List<Team> teams = response.body().getTeams();
                    teamsAdapter = new TeamsAdapter(TeamsActivity.this,teams);
                    teamsRv.setLayoutManager(new LinearLayoutManager(TeamsActivity.this));
                    teamsRv.setAdapter(teamsAdapter);
                    teamsAdapter.notifyDataSetChanged();



                }

            }

            @Override
            public void onFailure(Call<TeamsResponse> call, Throwable t) {

            }
        });
    }
}
