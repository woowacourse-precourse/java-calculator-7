package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static int calc(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("잘못된 입력 형식");
        }

        String delimiter = ",|:"; //기본 구분자 쉼표(,)와 콜론(:)
        String numbers = input;

        //커스텀 구분자가 확인
        if (input.startsWith("//")) {
            int delimiterIdx = input.indexOf("\\n"); //\n문자 확인
            if (delimiterIdx == -1) { // //로 시작하는데 \n이 없으면 잘못된 입력 형식
                throw new IllegalArgumentException("잘못된 입력 형식");
            }
            delimiter = input.substring(2, delimiterIdx); // "//"와 "\n" 사이의 문자를 구분자로 사용
            numbers = input.substring(delimiterIdx + 2);
        }

        //구분자를 기준으로 문자열을 분리
        String[] num = numbers.split(delimiter);

        //숫자의 합을 계산
        int sum = 0;
        for (String n : num) { //분리된 문자열에서 숫자 꺼내오기
            if (!n.isEmpty()) {
                int number = Integer.parseInt(n.trim());
                if (number < 0) {
                    throw new IllegalArgumentException("음수 입력됨");
                }
                sum += number;
                }
            }
            return sum;
        }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();  // 사용자 입력 받기

        int result = calc(input);
        System.out.println("결과 : " + result);

    }
}
