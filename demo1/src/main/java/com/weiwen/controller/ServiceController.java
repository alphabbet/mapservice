package com.weiwen.controller;

import com.weiwen.util.GenerateJsonUtils;
import com.weiwen.util.LngAndLatUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.jfunc.json.impl.JSONObject;

/**
 *  生活服务类接口
 */
@RestController
@RequestMapping("/find")
public class ServiceController {
    //美食接口
    @RequestMapping("/food")
    public String findFood(@RequestParam(value="address") String address) throws Exception {
        String s = "food";
        String ak = "eulX3AwU0Vh1Fmf0aQQtDiFbm8eMmKx0";
        LngAndLatUtils utils = new LngAndLatUtils();
        Double latitude = utils.getLngAndLat(address).get("lat");
        Double longitude = utils.getLngAndLat(address).get("lng");

        GenerateJsonUtils jsonUtils = new GenerateJsonUtils();

        JSONObject json = jsonUtils.readJsonFromUrl("http://api.map.baidu.com/place/v2/search?query=美食&location="+latitude+","+longitude+"&radius=2000&output=json&ak="+ak);
        for(String key:json.keySet()){
            System.out.println(key+":"+json.getString(key));
        }
        return s;
    }

    //酒店接口
    @RequestMapping("/hotel")
    public String findHotel(@RequestParam(value="address") String address) throws Exception {
        String s = "hotel";
        String ak = "bphCL3lgAhz3m3TWK5sqOlhCFsCShzVh";

        LngAndLatUtils utils = new LngAndLatUtils();
        Double latitude = utils.getLngAndLat(address).get("lat");
        Double longitude = utils.getLngAndLat(address).get("lng");

        GenerateJsonUtils jsonUtils = new GenerateJsonUtils();

        JSONObject json = jsonUtils.readJsonFromUrl("http://api.map.baidu.com/place/v2/search?query=酒店&tag=快捷酒店&location="+latitude+","+longitude+"&radius=2000&output=json&ak="+ak);
        for(String key:json.keySet()){
            System.out.println(key+":"+json.getString(key));
        }
        return s;
    }
    //商场接口
    @RequestMapping("/mall")
    public String findMall(@RequestParam(value="address") String address) throws Exception {
        String s = "mall";
        String ak = "bphCL3lgAhz3m3TWK5sqOlhCFsCShzVh";

        LngAndLatUtils utils = new LngAndLatUtils();
        Double latitude = utils.getLngAndLat(address).get("lat");
        Double longitude = utils.getLngAndLat(address).get("lng");

        GenerateJsonUtils jsonUtils = new GenerateJsonUtils();

        JSONObject json = jsonUtils.readJsonFromUrl("http://api.map.baidu.com/place/v2/search?query=购物&tag=超市&location="+latitude+","+longitude+"&radius=2000&output=json&ak="+ak);
        for(String key:json.keySet()){
            System.out.println(key+":"+json.getString(key));
        }
        return s;
    }
    //娱乐接口
    @RequestMapping("/happy")
    public String findHappy(@RequestParam(value="address") String address) throws Exception {
        String s = "happy";
        String ak = "bphCL3lgAhz3m3TWK5sqOlhCFsCShzVh";

        LngAndLatUtils utils = new LngAndLatUtils();
        Double latitude = utils.getLngAndLat(address).get("lat");
        Double longitude = utils.getLngAndLat(address).get("lng");

        GenerateJsonUtils jsonUtils = new GenerateJsonUtils();

        JSONObject json = jsonUtils.readJsonFromUrl("http://api.map.baidu.com/place/v2/search?query=休闲娱乐&tag=KTV&location="+latitude+","+longitude+"&radius=2000&output=json&ak="+ak);
        for(String key:json.keySet()){
            System.out.println(key+":"+json.getString(key));
        }
        return s;
    }
    //医疗接口
    @RequestMapping("/healthy")
    public String findHealthy(@RequestParam(value="address") String address) throws Exception {
        String s = "healthy";
        String ak = "bphCL3lgAhz3m3TWK5sqOlhCFsCShzVh";

        LngAndLatUtils utils = new LngAndLatUtils();
        Double latitude = utils.getLngAndLat(address).get("lat");
        Double longitude = utils.getLngAndLat(address).get("lng");

        GenerateJsonUtils jsonUtils = new GenerateJsonUtils();

        JSONObject json = jsonUtils.readJsonFromUrl("http://api.map.baidu.com/place/v2/search?query=医疗&tag=药店&location="+latitude+","+longitude+"&radius=2000&output=json&ak="+ak);
        for(String key:json.keySet()){
            System.out.println(key+":"+json.getString(key));
        }
        return s;
    }
    //通讯接口
    @RequestMapping("/comm")
    public String findLogistic(@RequestParam(value="address") String address) throws Exception {
        String s= "communication";
        String ak = "bphCL3lgAhz3m3TWK5sqOlhCFsCShzVh";

        LngAndLatUtils utils = new LngAndLatUtils();
        Double latitude = utils.getLngAndLat(address).get("lat");
        Double longitude = utils.getLngAndLat(address).get("lng");

        GenerateJsonUtils jsonUtils = new GenerateJsonUtils();

        JSONObject json = jsonUtils.readJsonFromUrl("http://api.map.baidu.com/place/v2/search?query=生活服务&tag=通讯营业厅&location="+latitude+","+longitude+"&radius=2000&output=json&ak="+ak);
        for(String key:json.keySet()){
            System.out.println(key+":"+json.getString(key));
        }
        return s;
    }

}
