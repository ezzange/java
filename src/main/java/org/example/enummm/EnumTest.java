package org.example.enummm;


import java.awt.*;
import java.util.Arrays;

public class EnumTest {

    //상수명(값) enum 선언 (선언만 해도 객체 생성됨)
    enum Size {
        WIDTH(10),
        HEIGHT_40(40),
        HEIGHT_50(50),
        HEIGHT_60(60),
        DEPTH(10);

        //객체 마다 속해져 있는 멤버 변수(매개변수)정의
        private final int value;

        //열거형은 외부에서 객체를 생성할 수 없기 때문에 선언과 같이 객체를 생성해 줄 생성자를 작성 해야 한다.
        Size(int value) {
            this.value = value;
        }

        //(변수가 private 이기에 외부에서 가져갈 수 있도록 getter 생성)
        public int getValue() {
            return value;
        }

    }

    public static void main(String[] args) {
        //열거형 생성자와 멤버 변수 활용

        //열거형 상수 선언

        //1. 열거형이름.상수명 //열거형의 상수는 객체와 같이 선언된 멤버 변수를 속성으로 갖는다.
        Size width = Size.WIDTH;
        //2. 열거형이름.valueOf("상수명")
        Size height40 = Size.valueOf("HEIGHT_40");
        Size height50 = Size.valueOf("HEIGHT_50");
        Size height60 = Size.valueOf("HEIGHT_50");
        //3. Enum..valueOf(열거형명.class,"상수명")
        Size depth = Size.valueOf("DEPTH");


        //HEIGHT_40, HEIGHT_50, HEIGHT_60만 포함된 heights 배열 선언
        //a.values() : a 안에 존재 하는 모든 값들을 배열로 반환
        Size[] heights = Arrays.copyOfRange(Size.values(), 1, 4);

        //외부에서 가져오는 경우도 따로 객체 생성을 하지 않는다.
        Color[] colors = Color.values();
        //전부 출력해보기
        System.out.print("Color의 상수 : ");
        for (Color color : Color.values()){
            System.out.print(" "+color);
        }System.out.println();

        for(Color i : colors)
            System.out.println(i.name()+" = " +i.getColor());
        System.out.println();

        System.out.print("선택할 수 있는 가로의 길이는 [ ");
        System.out.println(width +" : " + width.getValue() + " ] 입니다. ");
        System.out.print("선택할 수 있는 높이의 길이는 [ HEIGHT : ");
        System.out.print(height40.value+", "+ height50.value+", "+ height60.value);
        System.out.println(" ] 입니다. ");

        //for문으로 heights를 순회하며 switch문의 case를 전부 출력
        for (Size size : heights) {
            switch (size) { // 첫 번째 요소와 비교
                case HEIGHT_40:
                    System.out.println("선택한 높이의 길이는 40 입니다.");
                    break;
                case HEIGHT_50:
                    System.out.println("선택한 높이의 길이는 50 입니다.");
                    break;
                case HEIGHT_60:
                    System.out.println("선택한 높이의 길이는 60 입니다.");
                    break;
                default:
                    System.out.println("해당 높이는 존재하지 않습니다.");
            }
        }

        //a.ordinal() : a에서 상수가 정해진 순서 반환
        for(Size size : Size.values()){
            System.out.println(size + " index : "+ size.ordinal());
        }
        //a.valueOf(b) : a 에 b 가 존재한다면 해당 String값을 반환
        System.out.println(Size.valueOf("WIDTH"));

        // a.equals(b), ( a == b ), a.compareTo(b)로 비교하기

        //객체의 데이터타입과 객체가 가지고 있는 값이 다르기 때문에 flase
        System.out.println("WIDTH 와 DEPTH는 동일합니다. :" + (width == depth));
        System.out.println("WIDTH 와 DEPTH는 동일합니다. :" + Size.WIDTH.equals(Size.DEPTH));
        //a.compareTo(b)는 값dml ordinal값으로 빼기 연산한 값을 반환 한다. a>b : 양수 a=b: 0 a<b : 음수
        System.out.println("WIDTH 와 DEPTH는 비교한다면? :" + Size.WIDTH.compareTo(Size.DEPTH));


    }
}
