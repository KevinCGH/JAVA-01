package homework.h02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * AnnotationBeanDefinitionDemo
 *
 * @author KevinChen
 * @since 21/2/2021
 */
// 通过 @Import 方式
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationBeanDefinitionDemo.class);
        applicationContext.refresh();

        System.out.println(applicationContext.getBeansOfType(Config.class));
        System.out.println(applicationContext.getBeansOfType(User.class));

        applicationContext.close();
    }

    // 通过 @Component 方式
    @Component
    public static class Config {

        // 通过 @Bean 方式
        @Bean(name = "user1")
        public User user() {
            User user = new User();
            user.setId(1L);
            user.setName("小明");
            return user;
        }
    }
}
