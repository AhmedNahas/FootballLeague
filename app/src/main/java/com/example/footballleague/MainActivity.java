package com.example.footballleague;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.footballleague.Service.RetrofitClient;
import com.example.footballleague.Service.WebService;
import com.example.footballleague.adapter.LeagueAdapter;
import com.example.footballleague.leagueModel.Competition;
import com.example.footballleague.leagueModel.LeagueResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String TOKEN = "ac1581b7e82d44429e977f775e8d5e56";
    private LeagueAdapter leagueAdapter;
    private RecyclerView leagueRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leagueRv=findViewById(R.id.leagues_rv);

        RetrofitClient.getINSTANCE().create(WebService.class).getLeagues(TOKEN).enqueue(new Callback<LeagueResponse>() {
            @Override
            public void onResponse(Call<LeagueResponse> call, Response<LeagueResponse> response) {
                List<Competition> competitions = response.body().getCompetitions();
                leagueAdapter = new LeagueAdapter(MainActivity.this,competitions);
                leagueRv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                leagueRv.setAdapter(leagueAdapter);
                leagueAdapter.notifyDataSetChanged();
                Log.d(TAG, "onResponse: "+response.message());
            }

            @Override
            public void onFailure(Call<LeagueResponse> call, Throwable t) {

            }
        });
    }
}
