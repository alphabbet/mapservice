package com.weiwen.controller;

import com.weiwen.util.LngAndLatUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.jfunc.json.JsonObject;
import top.jfunc.json.impl.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

@RestController
@RequestMapping("/bus")
public class BusController {
    @RequestMapping("/info")
    public String BusRoute(@RequestParam(value="origin",required = true) String origin,
                           @RequestParam(value="destination",required = true) String destination) throws IOException {
        String s= "bus";
        String ak = "Yq66ji3LuQMutK2W4tTNlBxhlzkKUv9P";

        LngAndLatUtils utils = new LngAndLatUtils();
        Double olatitude = utils.getLngAndLat(origin).get("lat");
        Double olongitude = utils.getLngAndLat(origin).get("lng");
        Double dlatitude = utils.getLngAndLat(destination).get("lat");
        Double dlongitude = utils.getLngAndLat(destination).get("lng");

        JsonObject json = readJsonFromUrl("http://api.map.baidu.com/directionlite/v1/transit?origin="+olatitude+","+olongitude+"&destination="+dlatitude+","+dlongitude+"&ak="+ak);
        for(String key:json.keySet()){
            System.out.print(key+":"+json.getString(key));
        }
        return s;
    }

    public String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while((cp = rd.read())!=-1){
            sb.append((char)cp);
        }
        return sb.toString();
    }

    public JsonObject readJsonFromUrl(String url) throws IOException {
        InputStream in = new URL(url).openStream();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in,Charset.forName("UTF-8")));
            String jsonText = readAll(reader);
            JSONObject json = new JSONObject(jsonText);
            return  json;
        } finally {
            in.close();
        }
    }

}
