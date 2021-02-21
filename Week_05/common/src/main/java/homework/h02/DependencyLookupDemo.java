package homework.h02;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * LoadBeanByXml
 *
 * @author KevinChen
 * @since 21/2/2021
 */
public class DependencyLookupDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/application-context-h02.xml");
        // by name
        User user1 = (User) beanFactory.getBean("user1");
        System.out.println("ByName: " + user1);

        // by type
        User user2 = beanFactory.getBean(User.class);
        System.out.println("ByType: " + user2);
    }
}
