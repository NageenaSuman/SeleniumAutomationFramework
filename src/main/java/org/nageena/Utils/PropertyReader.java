package org.nageena.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    public static String readKeys(String Key){
        try {
        FileInputStream io = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/Data.properties");
            Properties p = new Properties();
            p.load(io);
            return p.getProperty(Key);

        } catch (FileNotFoundException e){
        throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
