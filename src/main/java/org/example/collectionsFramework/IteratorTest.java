package org.example.collectionsFramework;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

public class IteratorTest {
    public static void main(String[] args){
        //참조변수 타입을 부모타입인 Collection으로 사용하면 어떤 Set이든 List 코드를 변경할 때 최소화할 수 있다.
        Collection c = new TreeSet();
        c.add(1);
        c.add(2);
        c.add(3);
        c.add(4);
        c.add(5);

        Iterator it = c.iterator();

        while (it.hasNext()){
            Object o = it.next();
            System.out.println(o);
        }
        //만약 두번 읽고싶다면 Iterator는 일회용이기 때문에 다 쓰면 다시 얻어 와야 한다. (그렇지 않는 다면 next()값은 fales로 더 이상 읽히지 않음.)
        it = c.iterator(); //새로운 Iterator객체를 얻어옴.

        while (it.hasNext()){
            Object o = it.next();
            System.out.println(o);
        }

    }
}
