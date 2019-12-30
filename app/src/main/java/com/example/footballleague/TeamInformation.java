package com.example.footballleague;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class TeamInformation extends AppCompatActivity {
    ImageView teamLogo;
    TextView teamAddress , teamPhone , teamWebsite;
    RecyclerView teamInfoRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_information);

        teamLogo=findViewById(R.id.team_logo);
        teamAddress=findViewById(R.id.team_address);
        teamPhone=findViewById(R.id.team_phone);
        teamWebsite=findViewById(R.id.team_website);
        teamInfoRv=findViewById(R.id.player_infoRv);
    }
}
