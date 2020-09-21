package com.CityBik.CityInfo;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.util.ArrayList;

public class Common {
    public static JSONObject getJsonValue(String JsonString, String CityString) {
        JSONObject  return_arr = new JSONObject();
        if (JsonString == null || JsonString.trim().length() < 1) {
            return null;
            }
        try {
            JSONObject network_obj = new JSONObject(JsonString);
            JSONArray network_arr = network_obj.getJSONArray("networks");

            for(int i=0; i<network_arr.length();i++)
            {
                if(network_arr.getJSONObject(i).getJSONObject("location").get("city").equals(CityString))
                {
                    return_arr = network_arr.getJSONObject(i).getJSONObject("location");
                    break;
                }
            }
        } catch (JSONException e) {
                     e.printStackTrace();
        }
        return  return_arr;
    }
}
