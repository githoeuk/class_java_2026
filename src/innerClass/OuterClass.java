package innerClass;

public class OuterClass {

    private static int num = 10;

    // 클래스 파일안에 내부에 또 클래스 선언(중첩클래스)
    // 인스턴스 내부 클래스라고도 불린다
    // static의 여부의 차이점
    static class InnerClass{
        public void display(){
            System.out.println("num : " + num); // num변수가 inner에서도 사용할 수 있다.
        }
    }


} // end of outerClass
