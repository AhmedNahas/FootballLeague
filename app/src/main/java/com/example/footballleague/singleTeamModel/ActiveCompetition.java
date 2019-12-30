
package com.example.footballleague.singleTeamModel;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class ActiveCompetition {

    @SerializedName("area")
    private Area mArea;
    @SerializedName("code")
    private String mCode;
    @SerializedName("id")
    private Long mId;
    @SerializedName("lastUpdated")
    private String mLastUpdated;
    @SerializedName("name")
    private String mName;
    @SerializedName("plan")
    private String mPlan;

    public Area getArea() {
        return mArea;
    }

    public void setArea(Area area) {
        mArea = area;
    }

    public String getCode() {
        return mCode;
    }

    public void setCode(String code) {
        mCode = code;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getLastUpdated() {
        return mLastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        mLastUpdated = lastUpdated;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPlan() {
        return mPlan;
    }

    public void setPlan(String plan) {
        mPlan = plan;
    }

}
