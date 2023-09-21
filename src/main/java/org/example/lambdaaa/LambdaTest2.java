package org.example.lambdaaa;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaTest2 {
    public static void main(String[] args){

        Supplier<Integer> supplier = () -> (int)(Math.random()*100)+1; //1~100 난수
        Consumer<Integer> consumer = i -> System.out.print(i+", ");
        Predicate<Integer> predicate = i -> i%2==0; //짝수 확인
        Function<Integer, Integer> function = i -> i/10*10; //i의 1의 자리를 제거

        List<Integer> list = new ArrayList<>();
        makeRandomLost(supplier, list);
        System.out.println(list);
        printEvenNum(predicate, consumer, list);
        List<Integer> newList = doSomething(function, list);
        System.out.println(newList);
    }
//    function을 이용하여 1의 자리를 제거하고 새로운 newList에 저장하는 메서드
    private static <T> List<T> doSomething(Function<T, T> function, List<T> list){
        List<T> newList = new ArrayList<T>(list.size());
        for(T i : list){
            newList.add(function.apply(i));
        }return newList;
    }
    //predicate로 짝수인지 검사하고 consumer를 이용하여 출력하는 메서드
    private static <T> void printEvenNum(Predicate<T> predicate, Consumer<T> consumer, List<T> list) {
        System.out.print("[");
        for (T i : list) {
            if (predicate.test(i)) {
                consumer.accept(i);
            }
        }System.out.println(" ]");
    }
    //supplier로 부터 1~100의 난수를 받아 list에 추가하는 메서드
    private static <T> void makeRandomLost(Supplier<T> supplier, List<T> list) {
        for(int i=0; i<10; i++ ){
            list.add(supplier.get());
        }
    }
}
