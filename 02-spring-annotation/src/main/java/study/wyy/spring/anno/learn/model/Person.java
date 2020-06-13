package study.wyy.spring.anno.learn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ：wyaoyao
 * @date ： 2020-06-13 12:07
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;

    private Integer age;


}
