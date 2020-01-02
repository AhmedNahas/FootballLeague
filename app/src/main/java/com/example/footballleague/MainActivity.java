package com.example.footballleague;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.footballleague.Service.RetrofitClient;
import com.example.footballleague.Service.WebService;
import com.example.footballleague.adapter.LeagueAdapter;
import com.example.footballleague.dbHelper.LeagueContract;
import com.example.footballleague.dbHelper.LeagueHelper;
import com.example.footballleague.leagueModel.Area;
import com.example.footballleague.leagueModel.Competition;
import com.example.footballleague.leagueModel.LeagueResponse;

import java.util.List;


import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String TOKEN = "ac1581b7e82d44429e977f775e8d5e56";
    private LeagueAdapter leagueAdapter;
    private RecyclerView leagueRv;
    private RealmConfiguration realmConfiguration;
    private Realm realm;
    private TextView notAvailable ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        leagueRv=findViewById(R.id.leagues_rv);
        notAvailable=findViewById(R.id.unavailable);
//        Realm.init(this);
//        realmConfiguration = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
//        Realm.setDefaultConfiguration(realmConfiguration);
//        realm = Realm.getDefaultInstance();

//        RealmResults<Competition> areas = realm.where(Competition.class).findAll();
//        if (areas.size()<=0){
//            loadLeagues();
//        }else {
//            leagueAdapter = new LeagueAdapter(MainActivity.this,areas);
//            leagueRv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//            leagueRv.setAdapter(leagueAdapter);
//
//        }
        if (isNetworkAvailable()){
            notAvailable.setVisibility(View.GONE);
            loadLeagues();

        }else{
            notAvailable.setVisibility(View.VISIBLE);

        }



    }

    private void loadLeagues() {
        RetrofitClient.getINSTANCE().create(WebService.class).getLeagues(TOKEN).enqueue(new Callback<LeagueResponse>() {
            @Override
            public void onResponse(Call<LeagueResponse> call, Response<LeagueResponse> response) {
                List<Competition> competitions = response.body().getCompetitions();
                leagueAdapter = new LeagueAdapter(MainActivity.this,competitions);
                leagueRv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                leagueRv.setAdapter(leagueAdapter);
                leagueAdapter.notifyDataSetChanged();
                Log.d(TAG, "onResponse: "+response.message());

//                //save local
//                for (int i = 0; i < competitions.size(); i++) {
//                    realm.beginTransaction();
//                    Competition competition = realm.createObject(Competition.class);
//                    competition.setName(response.body().getCompetitions().get(i).getName());
//                    realm.commitTransaction();
//
//
//                }
            }

            @Override
            public void onFailure(Call<LeagueResponse> call, Throwable t) {

            }
        });
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
