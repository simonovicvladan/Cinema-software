package util;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SettingsLoader {

    private static SettingsLoader instance;
    private Properties props;

    private SettingsLoader() {
        try {
            props = new Properties();
            props.load(new FileInputStream("settings.properties"));
        } catch (Exception ex) {
            Logger.getLogger(SettingsLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static SettingsLoader getInstance() {
        if (instance == null) {
            instance = new SettingsLoader();
        }
        return instance;
    }

    public String getProperty(String key) {
        return props.getProperty(key, "n/a");
    }

}
