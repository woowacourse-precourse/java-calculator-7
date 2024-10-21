package calculator;

public class Application {
    public static void main(String[] args) {

      String input = InputService.readLine();

      // TODO: int로 바뀐 숫자 sum 기능 구현, class나 함수로 분리
        int number = Integer.parseInt(input);
        System.out.println("number의 타입; : " + ((Object) number).getClass().getName());
        number += 10;
        System.out.println("number + 10 = " + (number));
        System.out.println("number의 타입; : " + ((Object) number).getClass().getName());
    }
}
