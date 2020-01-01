package com.example.footballleague.leagueModel;

import io.realm.RealmObject;
import io.realm.annotations.Required;

public class RealmLeague extends RealmObject {
    @Required
    String longName;
    @Required
    String shortName;

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
