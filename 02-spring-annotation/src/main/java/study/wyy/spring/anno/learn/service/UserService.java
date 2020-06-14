package study.wyy.spring.anno.learn.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import study.wyy.spring.anno.learn.model.Person;

/**
 * @author ：wyaoyao
 * @date ： 2020-06-13 14:43
 */
@Service
@Scope("prototype")
public class UserService {

    public UserService() {
        System.out.println("创建UserService");
    }

    public Person findPerson(){
        return new Person("Wade", 12);
    }
}
