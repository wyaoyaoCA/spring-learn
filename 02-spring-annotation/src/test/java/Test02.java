import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import study.wyy.spring.anno.learn.config.MainConfig;
import study.wyy.spring.anno.learn.model.Person;
import study.wyy.spring.anno.learn.service.AddressService;
import study.wyy.spring.anno.learn.service.UserService;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.IsEqual.equalTo;
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
        UserService bean = applicationContext.getBean(UserService.class);
        Person person = bean.findPerson();
        // 使用class
        Assert.assertThat(person.getName(), equalTo("Wade"));
        Assert.assertThat(person.getAge(), equalTo(12));
    }

    @Test
    public void testAnno() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            log.info("ioc 容器中定义的bean: {}", beanName);
        }
        UserService bean = applicationContext.getBean(UserService.class);
        Person person = bean.findPerson();
        // 使用class
        Assert.assertThat(person.getName(), equalTo("Wade"));
        Assert.assertThat(person.getAge(), equalTo(12));
    }

    @Test(expected=NoSuchBeanDefinitionException.class)
    public void testExcludeFilters() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            log.info("ioc 容器中定义的bean: {}", beanName);
        }
        // 这里会抛出NoSuchBeanDefinitionException
        UserService userService = applicationContext.getBean(UserService.class);
    }

    /**
     * Person: 是通过BeanConfig这个配置类注入的，由于只会扫描@Service注解的组件
     * 故BeanCo这个类就没有生效，所以Person不存在
     */
    @Test(expected=NoSuchBeanDefinitionException.class)
    public void testIncludeFilters() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            log.info("ioc 容器中定义的bean: {}", beanName);
        }
        // 这里会抛出NoSuchBeanDefinitionException
        Person person = applicationContext.getBean(Person.class);
    }

    @Test(expected=NoSuchBeanDefinitionException.class)
    public void testExcludeFilters2() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            log.info("ioc 容器中定义的bean: {}", beanName);
        }
        AddressService addressService = applicationContext.getBean(AddressService.class);
        Assert.assertThat(addressService,notNullValue());
        // 这里会抛出NoSuchBeanDefinitionException
        UserService userService = applicationContext.getBean(UserService.class);
    }

    @Test(expected=NoSuchBeanDefinitionException.class)
    public void testExcludeFilters3() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            log.info("ioc 容器中定义的bean: {}", beanName);
        }
        AddressService addressService = applicationContext.getBean(AddressService.class);
        Assert.assertThat(addressService,notNullValue());
        // 这里会抛出NoSuchBeanDefinitionException
        UserService userService = applicationContext.getBean(UserService.class);
    }
}
