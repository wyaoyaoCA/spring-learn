package study.wyy.spring.anno.learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.wyy.spring.anno.learn.model.Person;

/**
 * @author ：wyaoyao
 * @date ： 2020-06-13 13:24
 * Configuration: 表明是一个配置类
 */
@Configuration
public class BeanConfig {

    /**
     * @Bean : 给容器中注册一个一个bean
     * 类型为返回值类型
     * id默认为方法名
     *
     */
    @Bean
    Person person(){
        Person kobe = new Person("Kobe", 20);
        return kobe;
    }
}
