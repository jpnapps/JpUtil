package com.jpndev.utilitylibrary.network;


import com.google.gson.reflect.TypeToken;
import com.jpndev.utilitylibrary.LogUtilsutility;
import com.jpndev.utilitylibrary.model.MAgencyRoot;
import com.jpndev.utilitylibrary.model.MJobs;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jpndev.utilitylibrary.model.MLaunchRoot;
import com.jpndev.utilitylibrary.model.MMissionRoot;
import com.jpndev.utilitylibrary.model.MPadRoot;
import com.jpndev.utilitylibrary.model.MRocketsRoot;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by ceino on 12/9/15.
 */
public class GsonUtils<T> {
    static GsonUtils gson;

    public static GsonUtils getInstance() {
        if(gson==null)
             gson = new GsonUtils();
        return gson;
    }
    public MAgencyRoot gsonToMAgencyRoot(JSONObject json) {

        MAgencyRoot users = null;
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonString =  json.toString();
            users = gson.fromJson(jsonString, MAgencyRoot.class);

        } catch (Exception e){
            LogUtilsutility.LOGD("exception", "NS JSONObject MAgencyRoot " + e.getMessage());
            //Crashlytics.logException(e);
            e.printStackTrace();
        }
        return users;
    }
    public MLaunchRoot gsonToMLaunchRoot(JSONObject json) {

        MLaunchRoot users = null;
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonString =  json.toString();
            users = gson.fromJson(jsonString, MLaunchRoot.class);

        } catch (Exception e){
            LogUtilsutility.LOGD("exception", "NS JSONObject MLaunchRoot " + e.getMessage());
            //Crashlytics.logException(e);
            e.printStackTrace();
        }
        return users;
    }
    public MMissionRoot gsonToMMissionRoot(JSONObject json) {

        MMissionRoot users = null;
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonString =  json.toString();
            users = gson.fromJson(jsonString, MMissionRoot.class);

        } catch (Exception e){
            LogUtilsutility.LOGD("exception", "NS JSONObject MMissionRoot " + e.getMessage());
            //Crashlytics.logException(e);
            e.printStackTrace();
        }
        return users;
    }
    public MPadRoot gsonToMPadRoot(JSONObject json) {

        MPadRoot users = null;
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonString =  json.toString();
            users = gson.fromJson(jsonString, MPadRoot.class);

        } catch (Exception e){
            LogUtilsutility.LOGD("exception", "NS JSONObject MPadRoot " + e.getMessage());
            //Crashlytics.logException(e);
            e.printStackTrace();
        }
        return users;
    }

    public MRocketsRoot gsonToMRocketsRoot(JSONObject json) {

        MRocketsRoot users = null;
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonString =  json.toString();
            users = gson.fromJson(jsonString, MRocketsRoot.class);

        } catch (Exception e){
            LogUtilsutility.LOGD("exception", "NS JSONObject MRocketsRoot " + e.getMessage());
            //Crashlytics.logException(e);
            e.printStackTrace();
        }
        return users;
    }

/*    public MJobs gsonToMJobs(JSONObject json) {

        MJobs users = null;
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonString =  json.toString();
            users = gson.fromJson(jsonString, MJobs.class);

        } catch (Exception e){
            LogUtilsutility.LOGD("exception", "NS JSONObject MJobs " + e.getMessage());
            //Crashlytics.logException(e);
            e.printStackTrace();
        }
        return users;
    }*/

    public ArrayList<MJobs> gsonToMJobs(JSONArray json) {

        ArrayList<MJobs> posts= null;
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonString =  json.toString();
            Type listType = new TypeToken<ArrayList<MJobs>>(){}.getType();
           posts = (ArrayList<MJobs>) gson.fromJson(jsonString, listType);
           // users = gson.fromJson(jsonString, MJobs.class);

        } catch (Exception e){
            LogUtilsutility.LOGD("exception", "NS  JSONArray MJobs " + e.getMessage());
            //Crashlytics.logException(e);
            e.printStackTrace();
        }
        return posts;
    }


/*
*
*
*
*
atlas-android-jan

  git checkout 0.3.0  -0.22.0

  git checkut 0.2.9  -0.20.4



*/

}

