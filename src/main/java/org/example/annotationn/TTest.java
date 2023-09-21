package org.example.annotationn;

import java.lang.annotation.Annotation;
import java.util.Arrays;

@Deprecated
@SuppressWarnings("1111") //유효 하지 않은 어노테이션은 무시
@Testinfo(
        count = 3, //디폴트값은 값을 지정하지 않아도 알아서 오지만 지정하여 변경함.
        TestedBy = "test",
        testTools = {"mini","max"}
)
public class TTest {
    public static void main(String[] args){
        //TTest의 객체 얻기
        Class<TTest> c = TTest.class;
        Testinfo an = c.getAnnotation(Testinfo.class);

        //어노테이션의 값 가져오기
        System.out.println(an.count());
        System.out.println(an.TestedBy());
        System.out.println(Arrays.toString(an.testTools()));

        // 애너테이션의 정의된 모든 정보를 배열로 가져오기
        Annotation[] anArray = c.getAnnotations();
        for (Annotation i : anArray)
            System.out.println(i);




    }
}
