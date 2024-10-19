package calculator;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Application {
    private final static String DEFAULT_SEPARATOR = ",|:";

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
        String separator = DEFAULT_SEPARATOR;
        }

        String[] str = input.split(separator);

        IntStream numbers = Arrays.stream(str).mapToInt(
                s -> {
                    try {
                        return Integer.parseInt(s);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("숫자가 아닌 값이 존재합니다.");
                    }
                });

        System.out.println("결과 : "+ numbers.sum());
    }
}
