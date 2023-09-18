package org.example.Inheritanceeee;

abstract class Unit{ //공통부분을 추출하여 만든 추상클래스
    int x,y;
    abstract void move(int x, int y);
    void stop(){}
}

//클래스에 추상메서드를 호출하여 중복코드 제거 -> 코드 간결

class Infantry extends Unit{
    void move(int x, int y){/* 지정된 위치로 이동 */}
    void rifleAttack(){/* 소총공격을 시작한다. */}
    public String toString() {return "Infantry";}
}
class Tank extends Unit{
    void move(int x, int y){/* 지정된 위치로 이동 */}
    void changeNode(){/* 공격모드로 변환한다. */}
    public String toString() {return "Tank";}
}
class TransportShip extends Unit{
    void move(int x, int y){/* 지정된 위치로 이동 */}
    void load(){/* 선택된 대상을 태운다. */}
    void unload(){/* 선택된 대상을 내린다. */}
    public String toString() {return "TransportShip";}
}




public class AbstractTest2 {
    public static void main(String[] args){
        Unit[] group = { new Infantry(), new Tank(), new TransportShip()};

        /* 배열의 선언 및 초기화를 한 줄로 작성 할 수 있다.
        Unit[] group = new Unit[3];
        group[0] = new Infantry();
        group[1] = new Tank();
        group[2] = new TransportShip();
        */
        //모든 유닛을 한 번씩 모두 호출하여 한번에 이동하는 반복문
        for(int i = 0; i < group.length; i++) {
            group[i].move(100, 200);
            System.out.println(group[i]+"의 이동이 완료되었습니다.");
        }

    }
}
