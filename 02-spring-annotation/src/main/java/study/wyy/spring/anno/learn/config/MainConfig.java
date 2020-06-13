package study.wyy.spring.anno.learn.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import study.wyy.spring.anno.learn.service.UserService;

/**
 * @author ：wyaoyao
 * @date ： 2020-06-13 14:42
 * @ComponentScan : 配置包扫描
 *
 */
@Configuration
@ComponentScan(value = {"study.wyy.spring.anno.learn"},
        excludeFilters = {
            @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {UserService.class})
        }
)
//@ComponentScan(value = {"study.wyy.spring.anno.learn"},
//        includeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Service.class})
//        }
//,useDefaultFilters = false)
public class MainConfig {


}
