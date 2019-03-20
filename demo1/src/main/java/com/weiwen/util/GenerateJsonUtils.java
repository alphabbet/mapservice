package com.weiwen.util;

import top.jfunc.json.impl.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class GenerateJsonUtils {
    public String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while((cp = rd.read())!=-1){
            sb.append((char)cp);
        }
        return sb.toString();
    }

    public JSONObject readJsonFromUrl(String url) throws IOException {
        InputStream in = new URL(url).openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in,Charset.forName("UTF-8")));
        String readText = readAll(reader);
        JSONObject json = new JSONObject(readText);
        return json;
    }
}
