package com.weiwen.util;

import org.json.JSONObject;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ToInterface {
    public static void interfaceUtil(String path){
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            conn.setUseCaches(false);
            conn.setInstanceFollowRedirects(true);
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.connect();
            //获取URLConnection对象对应的输出流
            DataOutputStream out = new DataOutputStream(
                    conn.getOutputStream());
            JSONObject obj = new JSONObject("{}");
            obj.put("session_id","id01");
            obj.put("result", new JSONObject("{\"type\": \"route\"}"));

            // Get data
            JSONObject apiResult = new JSONObject("{\"route\": [{\"a\": \"b\"},{\"a\": \"b\"},{\"a\": \"b\"}]}");
            obj.getJSONObject("result").put("baidu", apiResult);

            out.writeBytes("data="+obj.toString());
            System.out.println("data="+obj.toString());
            //缓冲数据
            out.flush();
            out.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            String lines;
            StringBuffer sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                sb.append(lines);
            }
            System.out.println(sb);
            reader.close();
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
