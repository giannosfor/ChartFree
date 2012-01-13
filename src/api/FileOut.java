
package api;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;


public class FileOut {

    public FileOut(String filename , String input) throws FileNotFoundException, IOException
    {
        Writer out = new OutputStreamWriter(new FileOutputStream(filename));
        out.write(input.toString());
        out.close();
    }
    public FileOut(FileIn filein) throws IOException 
    {
        this(filein.getFileIn(),filein.toString());
    }
}
