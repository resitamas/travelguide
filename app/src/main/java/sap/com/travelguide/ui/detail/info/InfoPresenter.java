package sap.com.travelguide.ui.detail.info;

import sap.com.travelguide.ui.detail.DetailPresenter;

/**
 * Created by I344065 on 2018. 01. 19..
 */

public class InfoPresenter extends DetailPresenter<InfoScreen> {

    public String getWikiUrl() {
        return "http://www.google.com/search?q=Wikipedia%20"+getCityModel().getName()+"%20UK&btnI";
        //return getCityModel().getInfo();
    }

}
