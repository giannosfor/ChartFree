
package main;

import api.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class mainp extends FileStringer
{
    public mainp(String filename)
    {
       super(filename);
    }
    public void doProcedure()
    {
        try {
            JSONParser parser = new JSONParser();
            JSONObject obj1 = (JSONObject) parser.parse(input.toString());
            JSONArray data = (JSONArray) obj1.get("data");
            String[] categories = new String[data.size()];
            for (int i = 0; i < data.size(); i++) {
                JSONObject obj = (JSONObject) data.get(i);
                categories[i] = obj.get("category").toString();
            }
            counts = new HashMap<String, Integer>();
            for (int i = 0; i < categories.length; i++) {
                if (counts.containsKey(categories[i])) {
                    counts.put(categories[i], counts.get(categories[i]) + 1);
                } else {
                    counts.put(categories[i], 1);
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(mainp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Map<String,Integer> getCounts() {
        return counts;
    }
    private HashMap<String,Integer>counts;
}
