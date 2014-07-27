package name.bpdp.turgo.config;

import java.io.*;

import javax.json.Json;
import javax.json.JsonReader;
import javax.json.JsonStructure;

/**
 * Created by bpdp on 4/14/14.
 */
public class TurgoConfig {

    JsonStructure configString;
    
    public TurgoConfig() {
        
        try (JsonReader reader = Json.createReader(new FileReader("conf/turgo.json"))) {
            configString = reader.read();
        } catch (IOException e) {
            System.err.println("Configuration file not found");
        }

    }
    
    public String getValue(String key) {
        
        return "asd";
        
    }

}
