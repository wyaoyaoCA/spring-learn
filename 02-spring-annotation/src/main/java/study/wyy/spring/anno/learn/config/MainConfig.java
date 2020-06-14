package study.wyy.spring.anno.learn.config;

import org.springframework.context.annotation.*;
import study.wyy.spring.anno.learn.condition.MacOsCondition;
import study.wyy.spring.anno.learn.condition.WindowsCondition;
import study.wyy.spring.anno.learn.model.Person;

/**
 * @author ：wyaoyao
 * @date ： 2020-06-13 14:42
 * @ComponentScan : 配置包扫描
 *
 */
@Configuration
//@ComponentScan(value = {"study.wyy.spring.anno.learn"},
//        excludeFilters = {
//            @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
//        }
//)
//@ComponentScan(value = {"study.wyy.spring.anno.learn"},
//        includeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Service.class})
//        }
//,useDefaultFilters = false)
@ComponentScan(value = {"study.wyy.spring.anno.learn"})
public class MainConfig {

        /**
         * @Bean : 给容器中注册一个一个bean
         * 类型为返回值类型
         * id默认为方法名
         *
         */
        @Bean
        @Scope("singleton")
        @Lazy
        Person person(){
                System.out.println("创建Person");
                Person kobe = new Person("Kobe", 20);
                return kobe;
        }


        @Bean
        @Conditional(MacOsCondition.class)
        Person jobs(){
                Person jobs = new Person("Jobs", 60);
                return jobs;
        }

        @Bean
        @Conditional(WindowsCondition.class)
        Person gates(){
                Person gates = new Person("Gates", 60);
                return gates;
        }

}
