import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import study.wyy.spring.anno.learn.config.MainConfig;
import study.wyy.spring.anno.learn.model.Person;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @author ：wyaoyao
 * @date ： 2020-06-13 12:31
 */
@Slf4j
public class Test04 {

    @Test
    public void testGetEnv() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        // 获取环境信息
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String os = environment.getProperty("os.name");
        log.info("当前系统为：{}", os);
    }

    @Test
    public void testConditionOnMac() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Map<String, Person> beansOfType = applicationContext.getBeansOfType(Person.class);
        Collection<Person> values = beansOfType.values();

        List<Person> jobs = values.stream().filter(v -> v.getName().equals("Jobs")).collect(Collectors.toList());
        Assert.assertThat(jobs.size(), equalTo(1));
        Assert.assertThat(jobs.get(0).getName(), equalTo("Jobs"));

        List<Person> gates = values.stream().filter(v -> v.getName().equals("Gates")).collect(Collectors.toList());
        Assert.assertThat(gates.size(), equalTo(0));

    }
}
