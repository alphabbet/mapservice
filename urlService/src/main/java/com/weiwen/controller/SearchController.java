package com.weiwen.controller;

import com.weiwen.util.GenerateJsonUtils;
import com.weiwen.util.LngAndLatUtils;
import org.springframework.web.bind.annotation.*;
import top.jfunc.json.impl.JSONObject;

import java.io.*;

/**
 * 用于查询某一位置周边推荐上车点位置分布及与请求位置的距离。
 */
@RestController
@RequestMapping("/search")
public class SearchController {
    @RequestMapping(value="/parking",method = RequestMethod.GET)
    public String parking(@RequestParam(value="address") String address) throws IOException {
        String ak = "NGi6f8LSALsgIhtef1squiyeiVYDkKIK";
        String s = "parking";

        LngAndLatUtils utils = new LngAndLatUtils();
        Double latitude = utils.getLngAndLat(address).get("lat") ;
        Double longitude = utils.getLngAndLat(address).get("lng");

        GenerateJsonUtils jsonUtils = new GenerateJsonUtils();

        String url = "http://api.map.baidu.com/parking/search?location="+longitude+","+latitude+"&coordtype=bd09ll&ak="+ak;
        JSONObject json = jsonUtils.readJsonFromUrl(url);
        for(String key:json.keySet()){
            System.out.print(key+":"+json.getString(key));
        }
        return s;
    }
}
