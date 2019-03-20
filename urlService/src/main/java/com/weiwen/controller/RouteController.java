package com.weiwen.controller;

import com.weiwen.util.GenerateJsonUtils;
import com.weiwen.util.LngAndLatUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.jfunc.json.impl.JSONObject;

import java.io.*;

/**
 *  路径类接口
 */
@RestController
@RequestMapping("/route")
public class RouteController {
    //步行路径接口
    @RequestMapping("/walk")
    public String walkRoute(@RequestParam(value = "origin") String origin,
    @RequestParam(value="destination") String destination) throws IOException {
        String s ="walkRoute";
        String ak = "eulX3AwU0Vh1Fmf0aQQtDiFbm8eMmKx0";

        LngAndLatUtils utils = new LngAndLatUtils();
        Double olatitude = utils.getLngAndLat(origin).get("lat");
        Double olongitude = utils.getLngAndLat(origin).get("lng");
        Double dlatitude = utils.getLngAndLat(destination).get("lat");
        Double dlongitude = utils.getLngAndLat(destination).get("lng");

        GenerateJsonUtils jsonUtils = new GenerateJsonUtils();

        JSONObject json = jsonUtils.readJsonFromUrl("http://api.map.baidu.com/directionlite/v1/walking?origin="+olatitude+","+olongitude+"&destination="+dlatitude+","+dlongitude+"&ak="+ak);
        for(String key:json.keySet()){
            System.out.println(key+":"+json.getString(key));
        }
        return s;
    }

    //骑行路径接口
    @RequestMapping("/ride")
    public String rideRoute(@RequestParam(value = "origin") String origin,
                            @RequestParam(value = "destination")String destination) throws IOException {
        String s= "rideRoute";
        String ak = "eulX3AwU0Vh1Fmf0aQQtDiFbm8eMmKx0";

        LngAndLatUtils utils = new LngAndLatUtils();
        Double olatitude = utils.getLngAndLat(origin).get("lat") ;
        Double olongitude = utils.getLngAndLat(origin).get("lng");
        Double dlatitude = utils.getLngAndLat(destination).get("lat");
        Double dlongitude = utils.getLngAndLat(destination).get("lng");

        GenerateJsonUtils jsonUtils = new GenerateJsonUtils();

        JSONObject json = (JSONObject) jsonUtils.readJsonFromUrl("http://api.map.baidu.com/directionlite/v1/riding?origin="+olatitude+","+olongitude+"&destination="+dlatitude+","+dlongitude+"&ak="+ak);
        for(String key:json.keySet()){
            System.out.println(key+":"+json.getString(key));
        }
        return  s;
    }

    //驾车路径接口
    @RequestMapping("/drive")
    public String dirveRoute(@RequestParam(value = "origin")String origin,
                             @RequestParam(value = "destination")String destination) throws IOException {
        String s = "driveRoute";
        String ak = "eulX3AwU0Vh1Fmf0aQQtDiFbm8eMmKx0";

        LngAndLatUtils utils = new LngAndLatUtils();
        Double  olatitude = utils.getLngAndLat(origin).get("lat");
        Double  olongitude = utils.getLngAndLat(origin).get("lng");
        Double  dlatitude = utils.getLngAndLat(destination).get("lat");
        Double  dlongitude = utils.getLngAndLat(destination).get("lng");

        GenerateJsonUtils jsonUtils = new GenerateJsonUtils();

        JSONObject json = (JSONObject)jsonUtils.readJsonFromUrl("http://api.map.baidu.com/directionlite/v1/driving?origin="+olatitude+","+olongitude+"&destination="+dlatitude+","+dlongitude+"&ak="+ak);
        for(String key:json.keySet()){
            System.out.println(key+":"+json.getString(key));
        }
        return s;
    }

}
