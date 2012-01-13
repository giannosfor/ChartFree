
package api;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FileIn {
    public FileIn (String filename) throws FileNotFoundException
    {
        try {
            filein = filename;
            FileInputStream inputStream = new FileInputStream(filename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            sb = new StringBuilder();
            String input = "";
            String NL = System.getProperty("line.separator");
            while ((input = reader.readLine()) != null) {
                sb.append(input + NL);
            }
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(FileIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String toString()
    {
        return sb.toString();
    }
    public String getFileIn()
    {
        return filein;
    }
    private StringBuilder sb;
    private String filein;
}
