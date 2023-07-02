package com.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Will
 * @project FSOFT
 * @date 6/30/2023
 */
public class Service {

    public Service() {
    }


    public static boolean ReadFile(String user,String pass) {
        boolean isExist = false;
        JSONParser jsonParser = new JSONParser();
        String filePath = "D:\\Project\\FSOFT\\src\\main\\data\\users.json";
        try (FileReader reader = new FileReader(filePath)) {
            // Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray userList = (JSONArray) obj;
           isExist = SaveToMap(userList,user,pass);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return isExist;
    }
    // Save to map
    private static boolean SaveToMap(JSONArray a,String user,String pass) {
        Map<String, String> map = new HashMap<String, String>();
        for (Object us : a) {
            JSONObject userJson = (JSONObject) us;
            String username = (String) userJson.get("username");
            String password = (String) userJson.get("password");
            map.put(username, password);
        }
       return check(map, user, pass);
    }

    public static boolean check(Map map, String username, String password) {
        boolean isExist = false;
        for (Object key : map.keySet()) {
            if (key.equals(username) && map.get(key).equals(password)) isExist = true;
        }
        return isExist;
    }
}
