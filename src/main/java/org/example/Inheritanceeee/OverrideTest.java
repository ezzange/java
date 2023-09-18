package org.example.Inheritanceeee;
class Point extends Object{
    int x;
    int y;

    //Object 클래스의 toString()을 오버라이딩
    public String toString(){
        return " x : "+ x + ", y : " + y;
    }
}

public class OverrideTest {
    public static void main(String[] args){
        Point p = new Point();
        p.x = 3;
        p.y = 5;
        System.out.println(p.toString());

    }
}
