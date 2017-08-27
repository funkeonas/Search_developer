package com.example.g6ix.search_developer.Utilities;

import com.example.g6ix.search_developer.DevActivities.Developers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by g6ix on 21-Aug-17.
 */

public final class DeveloperJsonUtils {

    public static List<Developers> getDevelopers(String developerJson) throws JSONException {
        List<Developers> data=new ArrayList<>();
        JSONObject mDeveloperJsonObject = new JSONObject(developerJson);

        JSONArray namesArray = mDeveloperJsonObject.getJSONArray("items");
        for (int i=0;i<namesArray.length();i++){
            JSONObject object=namesArray.getJSONObject(i);
            data.add(new Developers(object.getString("login"),object.getString("avatar_url"),
                    object.getString("html_url")));
        }
        return data;
    }
}
