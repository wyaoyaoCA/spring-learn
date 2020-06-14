package study.wyy.spring.anno.learn.filter;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;

import java.io.IOException;

/**
 * @author ：wyaoyao
 * @date ： 2020-06-13 17:02
 */
public class MyTypeFilter implements org.springframework.core.type.filter.TypeFilter {

    /**
     * 返回值为True表示匹配成功
     * @param metadataReader： 获取当前扫描到的类的信息
     * @param metadataReaderFactory: 可以获取到其他类的信息
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        // 获取当前类的注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        // 获取当前类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        // 获取当前类资源（类路径）
        Resource resource = metadataReader.getResource();

        String className = classMetadata.getClassName();
        // 类名包含User，匹配成功
        if(className.contains("User")){
            return true;
        }

        return false;
    }
}
