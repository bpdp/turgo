package name.bpdp.turgo.config;

import java.io.*;

import javax.json.Json;
import javax.json.JsonReader;
import javax.json.JsonObject;
import javax.json.JsonValue;

/**
 * Created by bpdp on 4/14/14.
 */
public class TurgoConfig {

    JsonObject configString;

    public TurgoConfig() {
        
        try (JsonReader reader = Json.createReader(new FileReader("conf/turgo.json"))) {
            configString = reader.readObject();
        } catch (IOException e) {
            System.err.println("Configuration file not found");
        }

    }

    public boolean isConfigExists() {
        if (configString==null) {
            return false;
        } else {
            return true;
        }
    }

    public String getValue(String key) {

        String value = configString.getString(key);
        return value;
        
    }

}
