package org.example.annotationn;

import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({FIELD, TYPE, TYPE_USE})
@interface MyAnnotast{}
@MyAnnotast // TYPE
class MyClass{
    @MyAnnotast // FIELD
    int i;

    @MyAnnotast // TYPE_USE
    MyClass my;
}