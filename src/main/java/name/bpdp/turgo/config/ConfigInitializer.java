package name.bpdp.turgo.config;

import java.io.File;

import javax.json.Json;
import javax.json.JsonReader;
import javax.json.JsonStructure;


/**
 * Created by bpdp on 4/14/14.
 */
public class ConfigInitializer {

	public boolean isConfigExists() {

		File turgoConf = new File("conf/turgo.json");
 
	  if(turgoConf.exists()){
			return true;
	  } else {
			return false;
	  }	

	}


}
