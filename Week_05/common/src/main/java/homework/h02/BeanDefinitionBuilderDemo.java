package homework.h02;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * BeanDefinitionBuilderDemo
 *
 * @author KevinChen
 * @since 21/2/2021
 */
public class BeanDefinitionBuilderDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.refresh();
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("id", 3L)
                .addPropertyValue("name", "小秦");

        BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), applicationContext);

        System.out.println(applicationContext.getBeansOfType(User.class));
        applicationContext.close();
    }
}
