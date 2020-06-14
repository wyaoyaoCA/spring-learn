package study.wyy.spring.anno.learn.condition;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author ：wyaoyao
 * @date ： 2020-06-14 15:55
 */
@Slf4j
public class MacOsCondition implements Condition {

    /**
     *
     * @param context  上下文环境
     * @param metadata 上下文环境
     * @return true表示条件匹配成功，false表示匹配失败
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        String mac = environment.getProperty("os.name");
        log.info("当前系统为: {}",mac);
        boolean isMAc = mac.contains("Mac");
        return isMAc;
    }
}
