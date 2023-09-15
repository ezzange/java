package org.example.stream;

import java.io.File;
import java.util.stream.Stream;

public class MapStreamTest {
    public static void main(String[] args){

        File[] fileArr = {
                new File("Test1.java"),
                new File("Test1"),
                new File("Test1.bak"),
                new File("Test2.java"),
                new File("Test1.txt")
        };

        //Stream.of()를 이용하여 Stream<File> 생성
        Stream<File> fileStream = Stream.of(fileArr);

        //  Stream<File>을 getName()를 이용해서 파일의 이름을 얻어 Stream<String>으로 변환.
        //Stream<String> filenameStream = fileStream.map(File::getName);
        //파일객체를 주면 파일객체에서 파일객체이름으로 뽑아내는
        Stream<String> filenameStream = fileStream.map(File::getName);       //람다식으로 표현
        //Stream의 모든 파일의 이름을 출력
        filenameStream.forEach(System.out::println);

        //Stream.of()를 이용하여 Stream<File>  다시 생성
        fileStream = Stream.of(fileArr);
        //Stream<File>을 파일 확장자(대문자)를 중복없이 뽑아내기 이름을 얻어 Stream<String>으로 변환.
        fileStream
                .map(File::getName)                                    //Stream<File> -> Stream<String> [ Test1.java, Test1, Test1.bak, Test2.java, Test1.txt ]
                .filter(s -> s.indexOf('.') != -1)                     //[ Test1.java, Test1.bak, Test2.java, Test1.txt ]
                //문자열 내에 점(.)이 있는지 확인하고, -1이 아닌 경우에만 해당 요소를 필터링
                .peek(s -> System.out.printf("제외된 파일 이름 = %s%n ", s))
                .map(s -> s.substring( s.indexOf('.') + 1) ) //Stream<String> -> Stream<String> [ java, bak,  java, txt ]
                // 확장자만 추출 (substring)
                .peek(s -> System.out.printf("제외된 확장자 이름 = %s%n ", s))
                .map(String::toUpperCase)                              //Stream<String> -> Stream<String> [ JAVA, BAK, JAVA, TXT ]
                // 대문자로 변환
                .distinct()                                            //중복 제거
                .forEach(System.out::println);                         //JAVA BAK TXT 최종 연산으로 스트림을 소비
        System.out.println();
    }

}

