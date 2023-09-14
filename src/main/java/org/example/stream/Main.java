package org.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){

//        List<Integer> list = Arrays.asList(1,2,3,4,5);
//        Stream<Integer> intStream = list.stream(); // list를 Stream으로 변환
//        //메서드참조 (it) -> system.out.print(it)
////스트림의 모든 요소를 출력
//        intStream.forEach(System.out::print); // 12345
//      //intStream.forEach(System.out::print); ERROR
//        //스트림은 한번의 최종 연산으로 끝 새로 생성해야하는 일회성

        //ㅁ문자형 스트림
//        String[] strArr = new String[] {"a", "b", "c", "d"};
//        Stream<String> strStream = Stream.of(strArr);
        //위와 같은 두줄이 바로 아래 한줄로 줄알 수 있다.
        //Stream<String> strStream  = Stream.of(new String[]{"a", "b", "c"});
        //strStream.forEach(System.out::println);

        //int배열을 integer배열로 바꿔 스트림으로
//        Integer[] intArr = {1, 2, 3, 4, 5};
//        Stream<Integer> intStream = Arrays.stream(intArr);
//        intStream.forEach(System.out::println);             //최종연산
//        //다르게 출력
//        System.out.println("count = " + intStream.count()); //최종연산


        //int배열을 IntStream으로
        int[] intArr = {1,2,3,4,5};
        IntStream intStream = Arrays.stream(intArr);
        //intStream.forEach(System.out::println);              //최종연산
//        System.out.println("count = " + intStream.count());  //최종연산
//        System.out.println("sum = " + intStream.sum());      //최종연산
        System.out.println("average = " + intStream.average());//최종연산



        //인티저 스트림은 객체기 때문에 count밖에 없지만 intStream은 데이터의 종류가 모두 숫자임을 알기 떄문에
        // count,sum,average 의 최종 연산이 가능한 메서드의 차이이다. int배열을 스트림으로 변환할 때에는
        // 보다 편리한 기능을 가지고 있는 intStream을 활용하는 것이 좋다.
    }

}
