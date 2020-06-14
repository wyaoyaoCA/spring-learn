import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.wyy.spring.anno.learn.config.MainConfig;
import study.wyy.spring.anno.learn.model.Person;
import study.wyy.spring.anno.learn.service.UserService;

import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author ：wyaoyao
 * @date ： 2020-06-13 12:31
 */
public class Test03 {

    @Test
    public void testScope(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person1 = applicationContext.getBean(Person.class);
        Person person2 = applicationContext.getBean(Person.class);
        UserService userService1 = applicationContext.getBean(UserService.class);
        UserService userService2 = applicationContext.getBean(UserService.class);
        Assert.assertThat(person1==person2,equalTo(true));
        Assert.assertThat(userService1==userService2,equalTo(false));
    }

    @Test
    public void testScope2(){
        System.out.println("创建IOC容器开始");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        System.out.println("创建IOC容器结束");
        Person person1 = applicationContext.getBean(Person.class);
        UserService userService1 = applicationContext.getBean(UserService.class);
    }
}
