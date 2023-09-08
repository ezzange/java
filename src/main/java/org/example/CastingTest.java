package org.example;
class Display{
    boolean power; //전원상태
    int lightness; //밝기
    void power() { power = !power; }
    void lightnessUp() { ++lightness; }
    void lightnessDown() { --lightness; }
}
class StudioDisplay extends Display{
    void water(){
        System.out.println("mac!!!");
    }
}
public class CastingTest {
    public static void main(String[] args){

        StudioDisplay stdis = new StudioDisplay();

        Display dis = (Display)stdis; //자식에서 부모인 Display로 형변환.
        StudioDisplay stdis2 = (StudioDisplay)dis; // 부모에서 자식인 StudioDisplay로 형변환.
        //부모-자식 간 관계가 아닐 경우 에러 발생
    }
}
