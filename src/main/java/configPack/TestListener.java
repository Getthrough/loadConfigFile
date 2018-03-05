package temp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * author: getthrough
 * date: 2018/3/5
 * description:
 */
public class TestListener implements ServletContextListener {
    private Logger logger = LoggerFactory.getLogger(TestListener.class);

    public void contextInitialized(ServletContextEvent sce) {
        String valueByKey = ConfigLoader.getValueByKey("jdbc.username");
//        System.out.println("value to \"jdbc.username\" is >>>>>>>>>>>>>>>" + valueByKey);
        logger.info("value to \"jdbc.username\" is >>>>>>>>>>>>>>>" + valueByKey);
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }
}
