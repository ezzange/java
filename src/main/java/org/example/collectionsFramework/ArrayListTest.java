package org.example.collectionsFramework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ArrayListTest {
    public static void main(String[] args){

        //ㄱㅣ본 길이(용량, capacity)가 10인 ArrayList를 생성
        ArrayList list1 = new ArrayList(10);

        //원래는 ArrayList는 객체만 저장 가능하여 이렇게 작성해야 하지만
        list1.add(new Integer(5));
        //컴파일러가 자동으로 autoboxing(기본형이 참조형으로 자동 변환)해주기 떄문에 아래와 같이 작성 가능하다.
        list1.add((1));
        list1.add((7));
        list1.add((6));
        list1.add((0));
                        //list1의 읽기전용으로 1보다 크고 4미만(1<x4) 위치를 추출하여 새로 생성
        ArrayList list2 = new ArrayList(list1.subList(1,4));
        print(list1, list2);

        //Collection = 인터페이스 Collections = 유틸 클래스
        Collections.sort(list1); //sort(객체) : 오름차순으로 정렬해주는 메서드 기능
        Collections.sort(list2);
        print(list1, list2);

        //A에 B가 모두 포함되어 있는지 확인
        System.out.println("list1. containsAll(list2) : "+ list1.containsAll(list2));




    }
    static void print(ArrayList list1, ArrayList list2){
        System.out.println("list1 : " + list1);
        System.out.println("list2 : " + list2);
        System.out.println();
    }

}
