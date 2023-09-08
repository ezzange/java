package org.example;

import java.util.Queue;

class display { //부모클래스의 멤버 5개
    boolean power; //전원상태
    int lightness; //밝기

    void power() { power = !power; }
    void lightnessUp() { ++lightness; }
    void lightnessDown() { --lightness; }

}

class SmartDisplay extends display{ //자식클래스의 멤버 7개 (2개 + 상속받은 5개)
    boolean standbyMode;    //대기모드 on/off
    void displayStandbyMode(String text){    //대기모드 상태가 on(true)이면 text를 보여준다.
        if (standbyMode){
            System.out.println(text);
        }
    }
}
class Ex7_1{
    public static void main(String args[]){
        SmartDisplay sdis = new SmartDisplay();
        sdis.lightness = 50; //부모 클래스로부터 상속받은 멤버
        sdis.lightnessUp();  //부모 클래스로부터 상속받은 멤버
        System.out.println(sdis.lightness);
        sdis.displayStandbyMode("대기모드가 실행되었습니다.");
        sdis.standbyMode = true;
        sdis.displayStandbyMode("대기모드가 실행되었습니다.");

    }

}