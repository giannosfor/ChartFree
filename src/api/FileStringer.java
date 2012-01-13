 /*
 Η FileStringer είναι μία κλάση που με τη βοήθεια των κλάσεως FileIn,FileOut
 πέρνει το περιεχόμενο ενός αρχείου και το επεξεργάζετε.Με τη δυνατότητα να
 αποθηκεύσει τις αλλαγές στο ίδιο ή σε άποιο άλλο αρχείο.
 */
package api;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class FileStringer implements Procedure{
    //Opens a file and procedure the data
    public FileStringer(String filein)
    {
        try {
            FileIn finput = new FileIn(filein);
            input = finput.toString();
            doProcedure();
        } catch (IOException ex) {
            Logger.getLogger(FileStringer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Open a file procedure the data and save it to another file
    public FileStringer(String filein, String fileout)
    {      
        this(filein);
        try {    
            /*FileOut output = */new FileOut(fileout , input.toString());
        } catch (IOException ex) {
            Logger.getLogger(FileStringer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Open a file procedure the data and save it again,same file
    public FileStringer(String filename , boolean flag)
    {
        this(filename,filename);
    }

    public abstract void doProcedure();

    protected String input;
}
