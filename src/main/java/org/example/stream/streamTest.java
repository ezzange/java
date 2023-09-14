package org.example.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class streamTest {
    public static void main(String[] args) {

//        IntStream intStream = new Random().ints(); //무한 스트림
//        intStream.limit(5).forEach(System.out::println); //5로 자르고 출력
//        위 아래 같은 코드이다.                     //ints(5, 10);처럼 범위를 지정하는 것도 가능하다.
        IntStream intStream = new Random().ints(5); // 무한 스트림중 5까지만.
        intStream.forEach(System.out::println); //출력

        //sorted() 으로 스트림 정렬하기
        //배열 생성
        List<String> names = Arrays.asList("Alice", "Charlie", "Bob");
        //1. 스트림 요소의 기본 정렬(Comparable)로 정렬
//        names.stream()
//                .sorted()
//                //sorted()를 사용하여 이름들을 알파벳 순서로 정렬
//                .forEach(System.out::println);


        //스트림 요소의 기본 정렬(Comparable)로 정렬
//        names.stream()
//                .sorted()
//                //sorted()를 사용 하여 이름 들을 알파벳 순서로 정렬
//                .forEach(System.out::println);

        //2. Comparator.comparing()으로 정렬 기준을 제공하여 출력 해보기
//        names.stream()
//                .sorted((name1, name2) -> name2.compareTo(name1))
//                //compareTo 메서드는 첫 번째 인자(name1)와 두 번째 인자(name2)를 비교 하고,
//                //결과에 따라 음수, 양수 또는 0을 반환 하는데
//                //"Charlie"가 "Bob"보다 크므로 앞으로 오게 되고, "Bob"이 "Alice"보다 크므로
//                //이름 들을 내림차순으로 정렬
//                .forEach(System.out::println);

        //2-1 이름을 길이로 정렬하여 출력하는 예시
        names.stream()
                .sorted(Comparator.comparing(String::length))
                .forEach(System.out::println);
        //2-2 나이가 적은 순으로 객체를 정렬하여 출력하는 예시

        Stream<Student> studentStream = Stream.of(
                new Student("Alice", 25, "Sydney"),
                new Student("Charlie", 20, "London"),
                new Student("Bob", 30, "Paris"),
                new Student("Eve", 20, "Sydney"),
                new Student("Frank", 25, "Seoul"),
                new Student("Grace", 25, "Seoul"),
                new Student("Henry", 20, "Seoul"),
                new Student("Ivy", 30, "London"),
                new Student("Jack", 20, "London")
        );

//        studentStream                                     // .reversed() 를 추가 하면 역순
//                .sorted(Comparator.comparing(Student::getAge) //1. 나이 정렬
//                        .thenComparing(Comparator.naturalOrder())) //2. 기본 정렬
//                        .forEach(System.out::println);
        //[ Charlie, 20, London ]
        //[ Eve, 20, Sydney ]
        //[ Henry, 20, Seoul ]
        //[ Jack, 20, London ]
        //[ Alice, 25, Sydney ]
        //[ Frank, 25, Seoul ]
        //[ Grace, 25, Seoul ]
        //[ Bob, 30, Paris ]
        //[ Ivy, 30, London ]

        studentStream
                .sorted(Comparator
                        .comparing(Student::getAge).reversed() //1. 나이 정렬
                        .thenComparing(Student::getName).reversed() //2. 이름 역정렬
                        .thenComparing(Student::getCity) //3. 도시 정렬
                        )
                .forEach(System.out::println);
        //[ Jack, 20, London ]
        //[ Henry, 20, Seoul ]
        //[ Eve, 20, Sydney ]
        //[ Charlie, 20, London ]
        //[ Grace, 25, Seoul ]
        //[ Frank, 25, Seoul ]
        //[ Alice, 25, Sydney ]
        //[ Ivy, 30, London ]
        //[ Bob, 30, Paris ]

        //람다식으로 표현
//        studentStream
//                .sorted(Comparator
//                        .comparing((Student s) -> s.age).reversed() //1. 나이 정렬
//                        .thenComparing((Student s) -> s.name).reversed() //2. 이름 역정렬
//                        .thenComparing((Student s) -> s.city) //3. 도시 정렬
//                )
//                .forEach(System.out::println);


    }


    static class Student implements Comparable<Student> {
        String name;
        int age;
        String city;


        public Student(String name, int age, String city) {
            this.name = name;
            this.age = age;
            this.city = city;
        }

        public String toString() {
            return String.format("[ %s, %d, %s ]", name, age, city);
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getCity() {
            return city;
        }

        //내림차순으로 나이를 기본 정렬 한다는 메서드
        public int compareTo(Student s) {
            return s.age - this.age;
        }
    }
}