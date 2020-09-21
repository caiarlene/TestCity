package com.CityBik.CityInfo;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class CityBik {
    private String url="";

    public String geturl() {
        return url;
    }

    public static String formatString(String s) {
        if (s != null) {
            s = s.replaceAll("\ufeff", "");
            }
        return s;
        }

    public String getHttpRespone() throws IOException {
        String line = "";
        String httpResults = "";
        url=("http://api.citybik.es/v2/networks");
        try {
            HttpURLConnection connection = URLConnection.getConnection(url);

            connection.connect();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                httpResults = httpResults + line.toString();
                }
            reader.close();

            connection.disconnect();
            } catch (Exception e) {
            e.printStackTrace();
            }
        return httpResults;
    }
}
