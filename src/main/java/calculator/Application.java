package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public long add(String input) {
        if (input == null || input.isEmpty()) {
            return 0L;
        }

        String[] parts = parseInput(input);
        return sumNumbers(parts);
    }

    private String[] parseInput(String input) {

        if (input.length() > 50) {
            throw new IllegalArgumentException("입력 길이 제한을 초과했습니다.");
        }

        String delimiter = extractDelimiter(input);
        String numbersPart = extractNumbersPart(input);

        // split 결과를 배열로 받음
        String[] parts = numbersPart.split(delimiter, -1);

        for (String part : parts) {
            if (part.isEmpty()) {
                throw new IllegalArgumentException("잘못된 입력 형식: 연속된 구분자는 허용되지 않습니다.");
            }
        }

        return parts;
    }

    public static void main(String[] args) {
        Application calculator = new Application();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();  // 사용자로부터 입력을 받음

        try {
            long result = calculator.add(input);
            System.out.println("결과 : " + result);
        } finally {
            Console.close();
        }
    }
}
