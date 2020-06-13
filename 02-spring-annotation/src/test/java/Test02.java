import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import study.wyy.spring.anno.learn.config.MainConfig;

/**
 * @author ：wyaoyao
 * @date ： 2020-06-13 12:31
 */
@Slf4j
public class Test02 {

    @Test
    public void testXml() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            log.info("ioc 容器中定义的bean: {}", beanName);
        }
    }

    @Test
    public void testAnno() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            log.info("ioc 容器中定义的bean: {}", beanName);
        }
    }
}
