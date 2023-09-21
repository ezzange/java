package org.example.annotationn;
//함수형 인터페이스는 하나의 추상 메서드만 가져야 한다.

@FunctionalInterface
public interface Runnable{
    public abstract void run();
}