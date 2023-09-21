package org.example.annotationn;

import java.util.ArrayList;

class Parent{
    void parentMethod(){}
}
class AnnotationTest extends Parent {

    @SuppressWarnings("unchecked")
    ArrayList list = new ArrayList();
//    List.add(obj);

    @Override
    @Deprecated
    void parentMethod(){}


}
