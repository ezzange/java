package org.example.Encapsulationnn;

public class EncapsulationTest {

    //private을 사용하여 외부에서 변수에 직접적인 접근을 제한
    private int hour;
    private int minute;
    private int second;

    public int getHour(){ return hour;}
    public void setHour(int hour){//외부에서 메서드를 통해 간접적인 접근만 허용 한다.
        if(hour < 0 || hour > 23 )//if문을 통해 유효한 값만 접근 되도록 보호
            return;
            this.hour = hour;

    }
}
