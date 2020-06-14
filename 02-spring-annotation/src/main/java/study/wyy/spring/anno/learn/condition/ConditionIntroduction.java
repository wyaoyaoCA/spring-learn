package study.wyy.spring.anno.learn.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author ：wyaoyao
 * @date ： 2020-06-14 15:55
 */
public class ConditionIntroduction implements Condition {

    /**
     *
     * @param context  上下文环境
     * @param metadata 上下文环境
     * @return true表示条件匹配成功，false表示匹配失败
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 获取ioc容器的Bean工厂
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        // 获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        // 获取环境信息
        Environment environment = context.getEnvironment();
        // 获取bean的定义注册类：
        //   可以使用BeanDefinitionRegistry查询注册了哪些类，
        //   也可以使用它注册一个Bean
        //   移除一个Bean的定义
        //   判断容器中是否已经有一个Bean的定义
        BeanDefinitionRegistry registry = context.getRegistry();

        return false;
    }
}
