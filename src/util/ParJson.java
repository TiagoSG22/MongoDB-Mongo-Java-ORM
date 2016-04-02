package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ParJson {
	/**String Formatada Pretty*/
	public static Gson gson = new GsonBuilder().setPrettyPrinting().create();
	/**String Não formatada*/
	public static Gson gson2 = new Gson(); 
}
