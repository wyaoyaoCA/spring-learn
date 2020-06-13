package study.wyy.spring.anno.learn.service;

import org.springframework.stereotype.Service;
import study.wyy.spring.anno.learn.model.Person;

/**
 * @author ：wyaoyao
 * @date ： 2020-06-13 14:43
 */
@Service
public class UserService {

    public Person findPerson(){
        return new Person("Wade", 12);
    }
}
