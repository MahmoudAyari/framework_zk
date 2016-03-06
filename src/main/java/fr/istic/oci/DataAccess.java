package fr.istic.oci;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
 
public class DataAccess {
    File file;
    public DataAccess(){
       
    }

    public String getData(String chemin){
    	file = new File(chemin);
        String data="";
        String str="";
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            while((data = in.readLine()) != null)
            {
                str = str +'\n' +data;
            }
            in.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}