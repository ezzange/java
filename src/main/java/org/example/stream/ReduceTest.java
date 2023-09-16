package org.example.stream;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReduceTest {
    public static void main(String[] args){

        String[] strArr = {
                "sum", "count", "max", "min",
                "Java", "Lambda", "stream", "reduce"
        };
//        Stream<String> strStream = Stream.of(strArr);
//        strStream.forEach(System.out::println);
        //=> 위 아래 동일 코드
        //직렬형 스트림
        Stream.of(strArr).forEach(System.out::println);

        //병렬형 스트림 =>여러 스레드로 나눠서 하기 때문에 기본적으로 출력 순서는 달라짐
        // 만약 순서를 유지하고 싶다면 .parallel().forEachOrdered() 사용
//        Stream.of(strArr).parallel().forEach(System.out::println);

        //객체가 비어 있지 않을 때 ture 반환하는 스트림 noEmptyStream //람다식(s->s.length()==0)
        boolean noEmptyStream = Stream.of(strArr).noneMatch(String::isEmpty);

        //직렬형 스트림
        //첫번째 문자가 s로 시작 하는 조건에 맞는 첫 번째 요소를 반환하는 스트림
//        Optional<String> sWordStream = Stream.of(strArr)
//                .filter(s-> s.charAt(0)=='s')
//                .findFirst();
        //병렬형 스트림
        Optional<String> sWordStream = Stream.of(strArr)
                .parallel()
                .filter(s-> s.charAt(0)=='s')
                .findAny();

        System.out.println("noEmptyStream = " + noEmptyStream);
        System.out.println("sWordStream = " + sWordStream.get());

        //Stream<String[]>을 IntStream으로 변환
        Stream<Integer> integerStream = Stream.of(strArr).map(String::length);
        System.out.println("integerStream : " + integerStream);
        //Stream<String>을 IntStream으로 변환. IntStream 기본형 스트림
        IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);

        int count = intStream1.reduce(0, (a,b) -> a + 1);
        int sum = intStream2.reduce(0, (a,b) -> a + b);
        OptionalInt max = intStream3.reduce(Integer::max);
        OptionalInt min = intStream4.reduce(Integer::min);

        //비어 있는 스트림 중 최소값을 반환하고 없으면 0을 반환해라.
//        OptionalInt min = IntStream.empty().reduce(Integer::min);
//        System.out.println("min : " + min.orElse(0));
//        System.out.println("min : " + min.orElseGet( () -> 0 ));

        System.out.println("count : " + count);
        System.out.println("sum : " + sum);
        System.out.println("max : " + max.getAsInt());
        System.out.println("min : " + min.getAsInt());

    }
}
