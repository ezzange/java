package org.example.Inheritanceeee;

abstract class Player{ //추상(미완성)클래스

    boolean pause;
    int currentPos;

    Player(){ //추상클래스도 기본 생성자가 생략되어 있다.
        pause = false;
        currentPos = 0;

    }
    //지정된 위치에서 재생 시작 기능
    abstract void play(int pos); //구현부가 없는 추상(미완성)메서드
    //재생을 즉시 멈추는 기능
    abstract void stop(); //추상메서드

    void play(){
        play(currentPos); //인스턴스 메서드 play는 추상메서드를 호출할 수 있다.
        /* (Player를 상속받은 완전한 클래스가 존재하여 객체 생성이 가능 할 경우 자식클래스의 객체가 생성 되고 구현부가 생성된 이후
         쿠상클래스의 인스턴스 메서드 play()가 호출되고 play(currentPos)를 호출한다.
         그 때 currentPos값으로 들어올 추상메서드 매개변수 int pos는 상속을 통해 자식클래스에서 구현한 구현부 코드인 것. ) */
    }
}
    //Player player = new Player() {} => 추상메서드는 인스턴스 객체 생성 불가라 ERROR 발생

//상속받은 추상메서드를 모두 구현하지 않고 1개만 구현했기 때문에 그래도 추상메서드
abstract class AabstractPlayer extends Player{
    void play(int pos){ /*내용 생략*/ } //추상메서드 구현
    //abstract void stop(); 상속 받았기 때문에 생략되어 있음.
    }

//상속받은 클래스의 추상메서드를 모두 구현 함으로 완전한 클래스
class QuickTimePlayer extends Player{

    void play(int pos) { System.out.println(pos + " 위치부터 paly 됩니다.");}
    void stop(){ System.out.println("재생을 중지합니다.");}
}

public class AbstractTest {
    public static void main (String[] args){
        Player qp = new QuickTimePlayer(); //다형성을 이용하여 인스턴스 생성
        //Player 타입의 참조변수 qp가 생성되어도 실제적으로 구햔된 QuickTimePlayer의 인스턴스 객체의 기능(메서드)을 가르킨다.
        qp.play(10); //추상 메서드 호출
        qp.stop();
    }
}
