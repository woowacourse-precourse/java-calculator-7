package calculator;

import camp.nextstep.edu.missionutils.Console;


public class Application {
    private static int add(String input) {

        // 올바른 input인지 확인 ..하고 예외처리 해주는 단계..
        // 커스텀 구분자 예외 처리 ..
        // 커스텀 구분자가 있으면 .. 커스텀 구분자를 기본 구분자에 추가해줌 .
        // 구분자는 혼용해서 쓸 수 있다..

        String delimiter = ",|:";
        String customDelimiter = null;

        if (input.startsWith("//")) {
            int newLineIndex = input.indexOf("\\n");
            if (newLineIndex == -1) {
                // // 다음에 \n이 없는 경우 .
                throw new IllegalArgumentException("잘못된 입력 입니다.");
            }
            customDelimiter = input.substring(2, newLineIndex); // 커스텀 구분자 파싱
            delimiter += "|" + customDelimiter;
            input = input.substring(newLineIndex + 2);
            System.out.println(input);
        }

        String[] nums = input.split(delimiter);
        int sum = 0;
        // 문자니까 int형으로 바꿔야함..
        for (String num : nums) {
            int number = Integer.parseInt(num);
            if (number < 0) {
                // 음수이면 ..
                throw new IllegalArgumentException("양수 입력만 가능합니다.");
                // 이거 밖으로 던져서 한꺼번에 처리하자
            }
            sum += number;
            // git git git git git
        }

        return sum;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 프로그램의 시작 지점 .
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();
        // 입력은 구분자와 양수로 구성된 문자열임 .. 음수가 들어오면 안됨.
        int ans = add(input);

        System.out.println(ans);
    }
}
