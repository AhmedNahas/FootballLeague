
package com.example.footballleague.singleTeamModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class SingleTeamInfo {

    @SerializedName("activeCompetitions")
    private List<ActiveCompetition> mActiveCompetitions;
    @SerializedName("address")
    private String mAddress;
    @SerializedName("area")
    private Area mArea;
    @SerializedName("clubColors")
    private String mClubColors;
    @SerializedName("crestUrl")
    private String mCrestUrl;
    @SerializedName("email")
    private Object mEmail;
    @SerializedName("founded")
    private Long mFounded;
    @SerializedName("id")
    private Long mId;
    @SerializedName("lastUpdated")
    private String mLastUpdated;
    @SerializedName("name")
    private String mName;
    @SerializedName("phone")
    private String mPhone;
    @SerializedName("shortName")
    private String mShortName;
    @SerializedName("squad")
    private List<Squad> mSquad;
    @SerializedName("tla")
    private String mTla;
    @SerializedName("venue")
    private String mVenue;
    @SerializedName("website")
    private String mWebsite;

    public List<ActiveCompetition> getActiveCompetitions() {
        return mActiveCompetitions;
    }

    public void setActiveCompetitions(List<ActiveCompetition> activeCompetitions) {
        mActiveCompetitions = activeCompetitions;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public Area getArea() {
        return mArea;
    }

    public void setArea(Area area) {
        mArea = area;
    }

    public String getClubColors() {
        return mClubColors;
    }

    public void setClubColors(String clubColors) {
        mClubColors = clubColors;
    }

    public String getCrestUrl() {
        return mCrestUrl;
    }

    public void setCrestUrl(String crestUrl) {
        mCrestUrl = crestUrl;
    }

    public Object getEmail() {
        return mEmail;
    }

    public void setEmail(Object email) {
        mEmail = email;
    }

    public Long getFounded() {
        return mFounded;
    }

    public void setFounded(Long founded) {
        mFounded = founded;
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

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public String getShortName() {
        return mShortName;
    }

    public void setShortName(String shortName) {
        mShortName = shortName;
    }

    public List<Squad> getSquad() {
        return mSquad;
    }

    public void setSquad(List<Squad> squad) {
        mSquad = squad;
    }

    public String getTla() {
        return mTla;
    }

    public void setTla(String tla) {
        mTla = tla;
    }

    public String getVenue() {
        return mVenue;
    }

    public void setVenue(String venue) {
        mVenue = venue;
    }

    public String getWebsite() {
        return mWebsite;
    }

    public void setWebsite(String website) {
        mWebsite = website;
    }

}
