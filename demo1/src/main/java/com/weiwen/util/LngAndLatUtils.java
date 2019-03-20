package com.weiwen.util;

import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * json返回形式
 * {"status":0,
 * "result":{"location":{"lng":118.77807440802562,"lat":32.05723550180587},
 * "precise":0,"confidence":12,
 * "comprehension":100,"level":"城市"}}
 */
public class LngAndLatUtils {
    public  Map<String,Double> getLngAndLat(String address){
        //百度地图ak
        String ak="eulX3AwU0Vh1Fmf0aQQtDiFbm8eMmKx0";
        Map<String,Double> map = new HashMap<String,Double>();
        //调用百度接口
        String url = "http://api.map.baidu.com/geocoder/v2/?address=" + address
                + "&output=json&ak=" + ak;
        String json = loadUrl(url);
        JSONObject obj = JSONObject.fromObject(json);
        if (obj.get("status").toString().equals("0"))
        {
            double lng = obj.getJSONObject("result").getJSONObject("location").getDouble("lng");
            double lat = obj.getJSONObject("result").getJSONObject("location").getDouble("lat");
            map.put("lng", lng);
            map.put("lat", lat);
        }
        return map;
    }
    public String loadUrl(String url){
        StringBuilder json = new StringBuilder();
        try {
            URL url1 = new URL(url);
            URLConnection uc = url1.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            String inputLine = null;
            while ((inputLine = in.readLine()) != null)
            {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json.toString();
    }
}
