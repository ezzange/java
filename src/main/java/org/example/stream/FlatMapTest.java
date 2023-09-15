package org.example.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class FlatMapTest {
    public static void main(String[] args) {
        //문자열배열을 가지고 이쓴 스트림 생성
        Stream<String[]> strArrStream = Stream.of(
                new String[]{"abc", "def", "ghi"},
                new String[]{"ABC", "GHI", "JKL"});
        //map()을 이용하여 문자열배열스트림을 문자열스트림으로 변환 시키려고 한다면 스트림안에 스트림 형태가 된다.
        //Stream<String[]> => Stream<Stream<String>>
//        Stream<Stream<String>> strStrStream = strArrStream.map(Arrays::stream);

        //이를 flatMap()중간연산을 사용한다면 Stream의 Stream에서 => Stream으로 변환 가능하다.
        //Stream<String[]> => Stream<String>
        Stream<String> strStream = strArrStream.flatMap(Arrays::stream); //Arrays.Stream(T[])

        strStream.map(String::toLowerCase) //소문자로 전환
                .distinct() //중복 제거
                .sorted() //정렬
                .forEach(System.out::println); //스트림 요소를 한 줄씩 출력
        System.out.println(); //마지막 빈 줄 추가


        //각 요소는 공백으로 구분된 문장으로 이루어진 문자열배열 선언 및 초기화
        String[] lineArr = {
                "I like you a lot and I love you",
                "I hope you have a good day today"
        };
        //lineArr의 요소를 lineStream 스트림으로 변환 (각 문장의 요소들을 스트림으로 갖는다.)
        Stream<String> lineStream = Arrays.stream(lineArr);
        lineStream.peek(s -> System.out.printf("현재 스트림의 요소 : %s%n", s))
                //현재 스트림의 요소 : I like you a lot and I love you, I hope you have a good day today

                //각 문장을 공백을 기준으로 분할하고, 분할된 단어들을 개별적인 요소로 가지는 스트림으로 변환
                .flatMap(line -> Stream.of(line.split(" +")))
                                    //split() 메서드는 주어진 정규 표현식 또는 문자열로 문자열을 분할하는 데 사용
                                    //정규 표현식 " +" => 하나 이상의 연속된 공백 문자
                                    //공백마다 요소를 분리

                .peek(s -> System.out.printf("현재 스트림의 요소 : %s%n", s))
                //스트림을 소모 하지 않고 확인 =>현재 스트림의 요소 : I, like, ...더보기

                .map(String::toLowerCase) //소문자로 전환
                .distinct() //중복 제거
                .sorted() //정렬
                .forEach(System.out::println); //스트림 요소를 한 줄씩 출력
        System.out.println(); //마지막 빈 줄 추가


    }
}
