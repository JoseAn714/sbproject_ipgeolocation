package com.springbootproject.ipgeolocation.service;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

public class LocationService {
    
    public static JSONObject getJson(URL url) throws IOException {
        String json = IOUtils.toString(url, Charset.forName("UTF-8"));
        return new JSONObject(json);
    }

    public static JSONObject GetIp() throws IOException {
        URL url = new URL("https://api.ipify.org/?format=json");
        JSONObject jsonObject = getJson(url);
        
        return jsonObject;
    }

    public static JSONObject GetIpInfo() throws IOException {
        URL url = new URL("https://ipinfo.io/" + GetIp().getString("ip") + "/geo");
        JSONObject jsonObject = getJson(url);
        return jsonObject;
    }

    public static JSONObject GenerateUrl() throws IOException {
        String[] lon = GetIpInfo().getString("loc").split(",");
        //URL url = new URL();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("url","https://www.openstreetmap.org/?mlat="+lon[0]+"&mlon="+lon[1]+"#map=18/"+lon[0]+"/"+lon[1]+"&layers=N");
        return jsonObject;        
    }

}
