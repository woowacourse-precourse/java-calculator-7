package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static int getSum(String[] numberArray){
        int sum=0;
        for (String number : numberArray) {
            String trimmed = number.trim();
            if (trimmed.isEmpty()) {
                return sum;
                // throw new IllegalArgumentException("빈 숫자가 있습니다.");
            }
            // 숫자 형식 검증
            if (!trimmed.matches("\\d+")) {
                throw new IllegalArgumentException("숫자 형식이 올바르지 않습니다.");
            }

            int num = Integer.parseInt(trimmed);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
            sum+=num;
        }
        return sum;
    }
    public static int calculate(String input) {
        String numbers;
        if (input.length() >= 2 && input.substring(0, 2).equals("//")) {
            int slashIndex = input.indexOf("\\n");
            // 앞의 구분자를 제외하고 numbers에 다시 저장한다
            numbers = input.substring(slashIndex + 2);
            if (slashIndex != -1) {
                String customDivider = input.substring(2, slashIndex);
                String[] numberArray = numbers.split(String.valueOf(customDivider));
                return getSum(numberArray);
            }
            else{
                throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
            }
         }
        else {
            numbers = input;
            // 쉼표와 콜론을 기준으로 분리
            String[] numberArray = numbers.split("[,;]");
            return getSum(numberArray);
        }
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            System.out.println("숫자를 입력하세요");
            String input = Console.readLine();
            int result = calculate(input);
            System.out.printf("결과 : %d",result);
        }
        finally {
            Console.close();
        }
    }
}