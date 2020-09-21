package com.CityBik.CityInfo;

import java.io.IOException;
import java.util.Locale;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.CityBik.CityInfo.CityBik;
import com.CityBik.CityInfo.Common;

public class TestCase {
    public String httpResult= null,expect_city = null;
    public static String expect_country="Germany";
    CityBik citybik=new CityBik();


    @Test(priority=0)
    public void getFrankfurt() throws IOException, JSONException {
        expect_city="Frankfurt";
        expect_country="Germany";
        resultCheck(expect_country, expect_city);
    }

    public void resultCheck(String expect_country, String expect_city) throws IOException, JSONException {
        System.out.println("[Test Case] get "+expect_city+" data successfully");
        httpResult=citybik.getHttpRespone();
        System.out.println("[Request Address]: "+citybik.geturl());
        JSONObject LocationArray=Common.getJsonValue(httpResult, expect_city);
        if(LocationArray != null)
        {
            String countryStr = LocationArray.getString("country");
            String latitude = LocationArray.getString("latitude");
            String longitude = LocationArray.getString("longitude");

            Locale locale = new Locale("", countryStr);
            String countryName = locale.getDisplayCountry();

            Assert.assertEquals(countryName,expect_country);
            System.out.println("[Test Case Result] :------------------------------------------------------------------------------\r\n " +
                    "country : " + expect_country + " ,actual: "+ countryName+ " \r\n"+
                    "latitude: " + latitude + " \r\n" +
                    "longitude: " + longitude + "\r\n" +
                    "------------------------------------------------------------------------------");
        }
    }
}