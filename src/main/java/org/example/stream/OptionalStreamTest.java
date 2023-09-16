package org.example.stream;

import java.util.Optional;

public class OptionalStreamTest {
    public static void main(String[] args) {

        //int[] arr = null; 변수arr에 null 을 직접적으로 넣어 주는 초기화 X
        int[] arr = new int[0]; //변수arr != null => 객체(비어있는 배얄)를 가지고 있음.
        System.out.println("arr.length : " + arr.length);// => arr.length : 0


        Optional<String> optVal = Optional.empty();
        System.out.println("optVal : " + optVal);  // => optVal : Optional.empty
//        System.out.println("optVal : "+ optVal.get()); //optVal 의 객체는 비어있기 때문에 해당 변수의 저장된 값은 null이다. 그러므로 예외발생
        System.out.println("optVal : " + optVal.orElse("")); // 변수에 저장된 값이 null이면 ""를 반환 => optVal :
        // => optVal :

        String str = "";
//        try {
//            str = optVal.get();
//        } catch (Exception e) {
//            str = ""; //예외발생시 빈문자열로 초기화
//        } //예외발생
//
//        System.out.println("str = " + str);

        //예외 처리시 좀 더 간결한 코드
//        str = optVal.orElse("EMPTY");//Optional에 저장된 값이 null 이면 "" 반환

        str = optVal.orElseGet( () -> "");
                                //람다식
        System.out.println("str  : "+ str);
        // => optVal :

        //한 번 더 연습

        //Optional 변수 opt 선언 및 초기화.
        Optional<String> opt = Optional.of("abc");

        //빈문자열의 값을 가진 문자열 변수 stt 생성
        String stt = "";

        //Optional 객체에 저장된 값이 null일 이면 ""반환
        stt = opt.orElseGet(String::new);
                            //메서드 참조
        System.out.println("stt  : "+ stt);//stt출력
        // => stt  : abc
    }

}
