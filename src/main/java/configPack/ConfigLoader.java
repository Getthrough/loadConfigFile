package temp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

/**
 * author: getthrough
 * date: 2018/2/28
 * description: a class for loading properties files
 */
public class ConfigLoader {
    private static Properties properties = new Properties();
    private static Logger logger = LoggerFactory.getLogger(ConfigLoader.class);
//    @Autowired
//    private static temp.AppContext appContext;

    static {
        try {
            /**
             * TODO 从app上下中获取属性文件路径
             */

            String configPath = getConfigPath();
            InputStream is = new FileInputStream(new File(configPath));
            properties.load(is);
            logger.info("####### properties file has loaded! #######");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getConfigPath() {
        String configPath = (String) AppContext.getBean("configPath");
        logger.info("configPath:>>>>>>>>>>>>>>>>>>>" + configPath);
        if (null != configPath && configPath.startsWith("file:")) {
            configPath = configPath.replace("file:", "");
        }
        if (null != configPath && configPath.startsWith("classpath:"))
            configPath = configPath.replace("classpath:", "");
        return configPath;
    }

    public static String getValueByKey(String key) {
        return getValueByKey(key, "");
    }

    public static String getValueByKey(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}
