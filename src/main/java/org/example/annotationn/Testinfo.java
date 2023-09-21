package org.example.annotationn;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) //실행 시 사용 가능 하도록 지정.
@interface Testinfo {
    int count() default 1; //기본형 타입의 요소
    String TestedBy(); //String 타입의 요소
    String[] testTools() default "mini"; //배열의 경우 값이 1개이면 {}생략
    //열거형 타입의 상수를 호출하도록 선언.

}

