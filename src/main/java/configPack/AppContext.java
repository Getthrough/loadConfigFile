package temp;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.Serializable;

/**
 * author: getthrough
 * date: 2018/2/28
 * description:
 */
//@Service
public class AppContext implements ApplicationContextAware,Serializable {
    private static final long serialVersionUID = 4606527550169443963L;
    private static ApplicationContext context;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        AppContext.setContext(applicationContext);
    }

    public static <T> T getBean(String beanName) {
        if (null == context)
            throw new RuntimeException("ApplicationContext has not been injected!");
        return (T) context.getBean(beanName);
    }

    public static <T> T getBean(Class<?> clazz) {
        if (null == context)
            throw new RuntimeException("ApplicationContext has not been injected!");
        return (T) context.getBean(clazz);
    }

    public static void setContext(ApplicationContext context) {
        AppContext.context = context;
    }

    public static ApplicationContext getContext() {

        return context;
    }
}
