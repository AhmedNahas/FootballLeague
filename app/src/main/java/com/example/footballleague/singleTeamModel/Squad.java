
package com.example.footballleague.singleTeamModel;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Squad {

    @SerializedName("countryOfBirth")
    private String mCountryOfBirth;
    @SerializedName("dateOfBirth")
    private String mDateOfBirth;
    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("nationality")
    private String mNationality;
    @SerializedName("position")
    private String mPosition;
    @SerializedName("role")
    private String mRole;
    @SerializedName("shirtNumber")
    private Object mShirtNumber;

    public String getCountryOfBirth() {
        return mCountryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        mCountryOfBirth = countryOfBirth;
    }

    public String getDateOfBirth() {
        return mDateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        mDateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getNationality() {
        return mNationality;
    }

    public void setNationality(String nationality) {
        mNationality = nationality;
    }

    public String getPosition() {
        return mPosition;
    }

    public void setPosition(String position) {
        mPosition = position;
    }

    public String getRole() {
        return mRole;
    }

    public void setRole(String role) {
        mRole = role;
    }

    public Object getShirtNumber() {
        return mShirtNumber;
    }

    public void setShirtNumber(Object shirtNumber) {
        mShirtNumber = shirtNumber;
    }

}
