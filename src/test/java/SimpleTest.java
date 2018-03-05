import org.junit.Test;
import temp.ConfigLoader;

import java.io.*;

/**
 * author: getthrough
 * date: 2018/2/28
 * description:
 */
public class SimpleTest {

//    @Before
//    public void init() {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:root-context.xml");
//    }

    @Test
    public void test() {
        ConfigLoader cl = new ConfigLoader();
        String value = cl.getValueByKey("jdbc.username");
        System.out.println("value to \"jdbc.username\" is " + value);
    }

    @Test
    public void test2() throws FileNotFoundException {
//        Properties properties = new Properties();
//        InputStream is = new FileInputStream(new File("config.properties"));
        InputStream is = new FileInputStream(new File("src\\main\\resources\\config.properties"));
        System.out.println(is.toString());
    }

    @Test
    public void test3() throws IOException {
//        Properties properties = new Properties();
//        InputStream is = new FileInputStream(new File("classpath:config.properties"));
//        System.out.println(is.toString());
        File f = new File(".");
        if (null != f) {
            System.out.println(f.getAbsolutePath());
        }
    }
}
