package Utils;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
public class Utils {
    public static String setEnvVariable(String value) throws ConfigurationException {

        PropertiesConfiguration configuration=new PropertiesConfiguration("./src/test/resources/config.properties");
        configuration.setProperty("token",value);
        configuration.setProperty("id",value);
        configuration.save();
        return value;

    }

    public static String setEnvVariable1(String value) throws ConfigurationException {

        PropertiesConfiguration configuration=new PropertiesConfiguration("./src/test/resources/config.properties");
        configuration.setProperty("id",value);
        configuration.save();
        return value;

    }
}
