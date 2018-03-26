package sap.com.travelguide.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

/**
 * Created by I344065 on 2018. 01. 18..
 */

public class GsonHelper {

    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static Gson gson;

    static {
        gson = new GsonBuilder().setDateFormat(DATE_FORMAT).create();
    }

    public static Gson getGson() {
        return gson;
    }


    public static <T> T objectFromString(String jsonString, Type type) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(jsonString, type);
    }
}
