package com.example.footballleague.Service;

import com.example.footballleague.leagueModel.LeagueResponse;
import com.example.footballleague.singleTeamModel.SingleTeamInfo;
import com.example.footballleague.teamsModel.TeamsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WebService {

    @GET("competitions")
    Call <LeagueResponse> getLeagues(@Header("X-Auth-Token") String token);

    @GET("competitions/{id}/teams")
    Call <TeamsResponse> getTeams(@Header("X-Auth-Token") String token, @Path("id") long id);

    @GET("teams/{id}")
    Call <SingleTeamInfo> getTeamInfo(@Header("X-Auth-Token") String token, @Path("id") long id);


}
