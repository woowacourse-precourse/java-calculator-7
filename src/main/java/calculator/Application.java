package calculator;

import java.util.Scanner;
public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = "";
        if (scanner.hasNextLine()) { // 입력 문자열이 null이 아니라면, 버퍼로부터 입력값을 가져온다.
            input = scanner.nextLine();
        }else{ // 빈 문자열의 경우 0 출력 후 바로 종료한다.
            System.out.println("결과 : 0");
            return;
        }
        }
    }
}
