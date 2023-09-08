package org.example;


import javax.sql.rowset.serial.SerialStruct;
import java.lang.management.MonitorInfo;
import java.util.Vector;

class Product {
    int price;
    int bonusPoint;

    //제품 가격의 10%를 보너스 포인트로 받는다.
    Product(int price){
        this.price = price;
        bonusPoint = (int)(price/10.0);
    }
    Product(){
        price=0;
        bonusPoint=0;
    }

}

class HandBalm extends Product {
    HandBalm(){
        super(300); //부모의 생성자 super() 를 호출하여 가격을 지정
    }
    // HandBalm 객체가  "HandBalm"이라는 문자열로 표현되도록 Object의 메서드 toString() 오버라이딩
    public String toString() {return "HandBalm";}
}

class LipOil extends Product {
    LipOil(){
        super(200);
    }
    public String toString() {return "LipOil";}
}

class Halls extends Product {
    Halls(){
        super(100);
    }
    public String toString() { return "Halls";}
}

class Buyer {
    int morey = 1000;
    int bonusPoint = 0;

    //구입한 제품을 저장하는데 사용할 Vector 객체
    Vector item = new Vector();

    //제품과 각 상품들의 상속관계를 이용하여 매개변수를 부모타입의 참조변수로 제품의 자식들은 어느 것이나 매개변수로 받을 수 있다.
    void buy(Product p) {
        if(morey <p.price){
            System.out.println("금액이 부족합니다. 다른 지불 방법이 필요합니다.");
            return;
        }

        morey = morey - p.price;
        bonusPoint = bonusPoint + p.bonusPoint;
        item.add(p);//구매한 제품을 Vactor item에 저장
        System.out.println(p.price+ "원의 " +p + " 제품을 구매하셨습니다.");
    }
    void refund(Product p){
        if(item.remove(p)){  //환불 시 구매한 제품을 Vactor item에 제거
            morey += p.price;
            bonusPoint-= p.bonusPoint;
            System.out.println(p.price+ "원의 " +p + " 제품 구매를 취소하셨습니다.");
        } else { //제거 실패시
            System.out.println("구매하신 제품 중 해당 제품은 존재하지 않습니다.");
        }
    }
    void summary(){ //구매한 제품에 대한 정보를 요약해서 보여준다.
        int sum = 0;
        String itemList = "";

        if(item.isEmpty()){
            System.out.println("구매하신 제품이 없습니다.");
            return;
        }
        for(int i=0; i<item.size(); i++){
            Product  p = (Product) item.get(i);
            sum += p.price;
            itemList += (i==0) ? "" + p : ", " + p;
        }//문자열과 참조변수의 덧샘은 참조변수에 toString()을 호출하여 문자열을 얻어 결합하기 때문에 결국 인스턴스의 문자열이 호출된다.
        System.out.println("구매하신 제품들의 총 금액은 " + sum + "원 입니다.");
        System.out.println("구매하신 제품은 " + itemList + " 입니다. ");

    }
}


public class polymorphismTest {
    public static void main(String[] args) {
        Buyer buyer = new Buyer();
        HandBalm handBalm = new HandBalm();
        LipOil lipOil = new LipOil();
        Halls halls = new Halls();

        buyer.buy(handBalm);
        buyer.buy(lipOil);
        buyer.buy(halls);
        buyer.summary();
        System.out.println();
        buyer.refund(lipOil);
        buyer.summary();
    }
}