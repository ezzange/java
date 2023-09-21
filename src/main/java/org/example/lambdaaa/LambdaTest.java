package org.example.lambdaaa;

public class LambdaTest {
    public static void main(String[] args){
        //메소드를 람다식으로 생략하지 않았을 경우
//        Object ob = new Object(){ // 람다식,  익명객체
//          int max(int a, int b){
//              return a > b ? a: b;
//          }
//        };
//        int value = ob.max(3, 5); //함수형 인터페이스

//        MyFunction2 obj = new MyFunction2() {
//            @Override
//            public int max(int a, int b) {
//                return 0;
//            }
//        }; int value = obj.max(3, 5);

        //람다식은 익명 객체라 호출하기 위해서는 일반적인 호출은 어렵고 함수형 인터페이스로 참조변수를 사용하여 호출 할 수 있다.
        //함수형 인터페이스의 추상메서드와 매개변수와 동일해야 호출 가능.
        MyFunction2 function2 = (a, b) ->a > b ? a : b; // 람다식 익명 객체

        int value = function2.max(3, 5); //함수형 인터페이스
        System.out.println("value="+value);

        //람다식으로 MyFunction의 추상메소드 구현
        MyFunction f1 = ()-> System.out.println("f1.run()");
        //익명클래스로 MyFunction의 추상메소드 구현 (함수형 인터페이스를 직접 구현)
        MyFunction f2 = new MyFunction(){
            public void run(){ //public 필수
                System.out.println("f2.run()");
            }
        };
        // 메소드 내부에서 Myfunction을 람다식으로 구현
        MyFunction f3 = getMyFunction();
        f1.run();
        f2.run();
        // MyFunction의 참조변수 function을 매개변수로 사용하여 호출
        execute(() -> System.out.println("f1.run()"));
        //함수형 인터페이스 MyFunction의 추상메서드 run()을 구현한 람다식을 매개변수로 직접 작성하고 호출
        execute( () -> System.out.println("run()"));
    }
    static void execute(MyFunction function){ //매개변수 타입이 MyFunction
        function.run();
    }

    static MyFunction getMyFunction(){ //반환타입이 MyFunction
//        MyFunction function = () -> System.out.println("f3.run()");
        return () -> System.out.println("f3.run()") ;
    }
}
@FunctionalInterface
interface MyFunction2{
    //public abstract 생략
    int max(int a, int b);
//    public abstract int max2(int a, int b); 함수형 인터페이스는 단 하나의 추상메서드만 가질 수 있음.
}

@FunctionalInterface
interface MyFunction{
    void run();
}


