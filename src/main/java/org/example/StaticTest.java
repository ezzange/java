package org.example;

public class StaticTest {
    static int a = 100; //모든 인스턴스에 공통적으로 사용 되는 클래스 변수가 된다.

                        //클래스 변수는 인스턴스 객체를 생성 하지 않고 사용 가능
    static int b = 200; //클래스가 메모리에 로드될 때 생성

    static int max(int a, int b){
        return a > b ? a : b; //인스턴스 객체를 생성하지 않고 호출이 가능한 static 메서드가 된다.
    }                          //static 메서드 내 에서는 인스턴스 멤버( iv, mathod )를 직접 사용할 수 없다.
}

