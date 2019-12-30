
package com.example.footballleague.teamsModel;

import androidx.annotation.NonNull;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class TeamsResponse {

    @SerializedName("competition")
    private Competition mCompetition;
    @NonNull
    @SerializedName("count")
    private Long mCount;
    @SerializedName("filters")
    private Filters mFilters;
    @SerializedName("season")
    private Season mSeason;
    @SerializedName("teams")
    private List<Team> mTeams;

    public Competition getCompetition() {
        return mCompetition;
    }

    public void setCompetition(Competition competition) {
        mCompetition = competition;
    }

    public Long getCount() {
        return mCount;
    }

    public void setCount(Long count) {
        mCount = count;
    }

    public Filters getFilters() {
        return mFilters;
    }

    public void setFilters(Filters filters) {
        mFilters = filters;
    }

    public Season getSeason() {
        return mSeason;
    }

    public void setSeason(Season season) {
        mSeason = season;
    }

    public List<Team> getTeams() {
        return mTeams;
    }

    public void setTeams(List<Team> teams) {
        mTeams = teams;
    }

}
