
package com.example.footballleague.leagueModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class LeagueResponse {

    @SerializedName("competitions")
    private List<Competition> mCompetitions;
    @SerializedName("count")
    private Long mCount;
    @SerializedName("filters")
    private Filters mFilters;

    public List<Competition> getCompetitions() {
        return mCompetitions;
    }

    public void setCompetitions(List<Competition> competitions) {
        mCompetitions = competitions;
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

}
