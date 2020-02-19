package com.example.footballleague;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
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
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.footballleague.Service.RetrofitClient;
import com.example.footballleague.Service.WebService;
import com.example.footballleague.adapter.LeagueAdapter;
import com.example.footballleague.databinding.ActivityMainBinding;
import com.example.footballleague.dbHelper.LeagueContract;
import com.example.footballleague.dbHelper.LeagueHelper;
import com.example.footballleague.leagueModel.Area;
import com.example.footballleague.leagueModel.Competition;
import com.example.footballleague.leagueModel.LeagueResponse;

import java.util.ArrayList;
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
//    private RecyclerView leagueRv;
    private RealmConfiguration realmConfiguration;
    private Realm realm;
//    private TextView notAvailable ;
//    private Spinner spinner;
    private ArrayList<String> names;
    private ActivityMainBinding binding;
    SearchView searchView;
    List<Competition> filteredList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        searchView = binding.search;
        names = new ArrayList<>();


loadLeagues();
//        leagueRv=findViewById(R.id.leagues_rv);
//        notAvailable=findViewById(R.id.unavailable);
//        spinner = findViewById(R.id.spinner);
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
//        if (isNetworkAvailable()){
//            notAvailable.setVisibility(View.GONE);
//            loadLeagues();
//
//        }else{
//            notAvailable.setVisibility(View.VISIBLE);
//
//        }



    }

    private void loadLeagues() {
        RetrofitClient.getINSTANCE().create(WebService.class).getLeagues(TOKEN).enqueue(new Callback<LeagueResponse>() {
            @Override
            public void onResponse(Call<LeagueResponse> call, final Response<LeagueResponse> response) {
                final List<Competition> competitions = response.body().getCompetitions();
                prepare(competitions);
                names = new ArrayList<>();
                for (int i = 0; i < competitions.size(); i++) {
                    String name = competitions.get(i).getName();
                    names.add(name);
                }

                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        filteredList = filter(competitions,newText);
                        if (filteredList.size()>0){
                            leagueAdapter.setFilter(filteredList,newText);
                            return true;

                        }else{
                            Toast.makeText(MainActivity.this, "not found", Toast.LENGTH_SHORT).show();
                            return false;
                        }

                    }
                });



                ArrayAdapter<String> adapter = new ArrayAdapter<>(
                        MainActivity.this,android.R.layout.simple_spinner_item,names);
                adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                binding.spinner.setAdapter(adapter);



//


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

    private void prepare(List<Competition> filteredList) {
        leagueAdapter = new LeagueAdapter(MainActivity.this,filteredList);
        binding.leaguesRv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        binding.leaguesRv.setAdapter(leagueAdapter);
        leagueAdapter.notifyDataSetChanged();
//        Log.d(TAG, "onResponse: "+response.message());
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public ArrayList<String> getNames(){
        return names;
    }

    private List<Competition> filter(List<Competition> models, String query ) {
        query = query.toLowerCase();
        final List<Competition> filteredModelList = new ArrayList<>();
        for (Competition model : models) {
            final String text = model.getArea().getName().toLowerCase();
            final String text_sub = model.getName().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(model);

            }
            else {
                if (text_sub.contains(query)) {
                    filteredModelList.add(model);
                }
            }
        }

        leagueAdapter = new LeagueAdapter(this, filteredModelList);
        binding.leaguesRv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        binding.leaguesRv.setAdapter(leagueAdapter);
        leagueAdapter.notifyDataSetChanged();
        return filteredModelList;

}
}
