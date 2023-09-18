package org.example.Inheritanceeee;
                //컴파일 시 컴파일러가 자동 추가
class MyPoint extends Object{
    int x;
    int y;
}
class Circle extends Object{
    MyPoint p =new MyPoint();
    int r;
}
public class InheritanceTest {
    public static void main(String[] args){
        Circle c = new Circle();
        System.out.println(c.toString()); //"Circle@6504e3b2"
    }                       //Object의 메서드
}
