package org.rest.quest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Roman Uholnikov
 */
public class Utils {

    /**
     * Get random string with specified length.
     *
     * @param length leang of string to be created.
     * @return word
     */
    public static String getRandomString(int length) {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }


    public static String toJson(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    public static String toJson(Object obj, ExclusionStrategy strategy) {
        Gson gson = new GsonBuilder()
                .setExclusionStrategies(strategy).create();
        return gson.toJson(obj);
    }


    public static String getStringFromFIle(String fileName, ClassLoader classLoader) {
        StringBuilder stringBuilder = new StringBuilder();
        try (InputStream in = classLoader.getResourceAsStream(fileName)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }


}
