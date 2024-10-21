package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        input = input.replace("\\n", "\n");

        int result = sumFromString(input);
        System.out.println("결과 : " + result);
    }

    public static int sumFromString(String input) {

        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:"; // 기본 구분자 설정
        String numbers = input;


        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");


            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("올바르지 않은 형식입니다. \\n이 없습니다.");
            }

            String customDelimiter = input.substring(2, delimiterEndIndex); // 커스텀 구분자 추출
            delimiter = delimiter + "|" + customDelimiter; // 기본 구분자와 커스텀 구분자 결합
            numbers = input.substring(delimiterEndIndex + 1);  // 숫자 부분 추출
        }


        String[] tokens = numbers.split(delimiter);

        // 각 숫자 합산
        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }

        return sum;
    }
}
