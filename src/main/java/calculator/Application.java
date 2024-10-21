package calculator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // 1. 사용자에게서 입력값 받기
        // Scanner 클래스의 인스턴스 생성하기
        Scanner scanner = new Scanner(System.in);
        // nextLine() 메서드를 통해 입력 값 변수에 저장하기
        String inputValue = scanner.nextLine();

        // 2. "입력값에서 기본 구분자(쉼표, 콜론)를 통해 숫자를 추출하는 기능"
        ArrayList<Integer> result = new ArrayList<Integer>();
        String[] nums={};
        if (inputValue.length()>1) {
            nums = inputValue.split(",|;");
        }



    }
}
