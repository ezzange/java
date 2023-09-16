package org.example;


abstract class Unit2{ //공통부분을 추출하여 만든 추상클래스
    int x,y;
    abstract void move(int x, int y);
    void stop(){System.out.println("정지합니다.");}
}

interface Fightable{
    public abstract void move(int x, int y);
    public abstract void attack(Fightable f);
}
class Fighter extends Unit2 implements Fightable{

    //오버라이딩 규칙 : 부모보다 접근제어자의 범위가 좁으면 안된다.
    public void move(int x, int y){
        System.out.println("[ "+x+" , "+y+" ] 로 이동");
    }
    public void attack(Fightable f){
        System.out.println(f+" 를 공격");
    }
    //싸울 수 있는 상대를 불러온다.
    Fightable getFightable(){
        Fighter f = new Fighter(); //Fighter를 생성해서 반환
        return f;

    }
    public String toString(){return "Fighter";}
}

public class FighterTest {
    public static void main(String[] args){

        Fighter f = new Fighter();
        Fightable f2 = f.getFightable(); //사용할 메서드의 반환타입과 일치 해야 한다.
        System.out.println("새로운 "+f+"가 등장했습니다.");

        Fightable f1 = new Fighter();
        f1.move(100,200); //f.attack(new Fighter());
        f1.attack(new Fighter()); /* =>Fighter f2 = new Fighter(); f.attack(f2);*/
        // f.stop(); => ERROR (Fightable 선언된 멤버인 메서드만 사용가능 없어서 불가)

        //Unit2에 선언된 멤버인 메서드 move()만 사용 가능
//        Unit2 u = new Fighter();
//        u.move(100,200);
//        u.stop();



    }
}
