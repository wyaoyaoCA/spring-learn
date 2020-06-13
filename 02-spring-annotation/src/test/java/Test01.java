import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import study.wyy.spring.anno.learn.config.BeanConfig;
import study.wyy.spring.anno.learn.model.Person;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
/**
 * @author ：wyaoyao
 * @date ： 2020-06-13 12:31
 */
public class Test01 {

    @Test
    public void testXml(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        // 使用name
        Person person = (Person) applicationContext.getBean("person");
        Assert.assertThat(person.getName(), equalTo("Wade"));
        Assert.assertThat(person.getAge(), equalTo(18));

        // 使用class
        Person bean = applicationContext.getBean(Person.class);
        Assert.assertThat(bean.getName(), equalTo("Wade"));
        Assert.assertThat(bean.getAge(), equalTo(18));
    }

    @Test
    public void testAnno(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
        Person bean = applicationContext.getBean(Person.class);
        Assert.assertThat(bean,notNullValue());
        Assert.assertThat(bean.getName(), equalTo("Kobe"));
        Assert.assertThat(bean.getAge(), equalTo(20));
    }
}
