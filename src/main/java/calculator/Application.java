package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 1. 사용자로부터 입력을 받는 기능
        String input = Console.readLine();
        System.out.println("입력받은 문자열: " + input);

        // 2. 입력된 문자열을 파싱하는 기능
        String delimiter = ",|:";
        String numbers = input;

        // 커스텀 구분자 확인
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");
            if (delimiterIndex != -1) {
                delimiter = input.substring(2, delimiterIndex);
                numbers = input.substring(delimiterIndex + 1);
            }
        }

        System.out.println("사용된 구분자: " + delimiter);
        System.out.println("파싱할 숫자 문자열: " + numbers);

        // 3. 분리된 문자열에서 숫자를 추출하는 기능
        String[] numberArray = numbers.split(delimiter);
        System.out.println("추출된 숫자들: ");
        for (String num : numberArray) {
            System.out.println(num);
        }

        // 4. 추출된 숫자들의 합을 계산하는 기능
        int sum = 0;
        for (String num : numberArray) {
            sum += Integer.parseInt(num);  // 숫자로 변환하여 합 계산
        }

        // 5. 결과를 출력하는 기능
        System.out.println("최종 결과: " + sum);
    }
}
