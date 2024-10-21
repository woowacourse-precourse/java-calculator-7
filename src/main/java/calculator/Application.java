package calculator;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static int sumNumbers(String input) {
        // 정규식을 사용하여 , 혹은 : 로 문자열을 분리
        String[] parts = input.split("[,:]");
        int sum = 0;

        for (String part : parts) {
            // 문자열을 정수로 변환하여 더하기
            sum += Integer.parseInt(part.trim());
        }

        return sum;
    }

    public static void main(String[] args) {
        String string;

        Scanner sc = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요");
        string= sc.nextLine();;

        int result = sumNumbers(string);
        System.out.println("Sum: " + result);
    }
}
