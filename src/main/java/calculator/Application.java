package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input;
        String[] tokens;

        System.out.println("덧셈할 문자열을 입력해주세요.");
        input = Console.readLine();

        if (input.startsWith("//")) {
            if (!input.contains("\\n")) {
                throw new IllegalArgumentException("잘못된 구분자 형식입니다. 커스텀 구분자는 //로 시작하고 \\n으로 끝나야 합니다.");
            }

            int customIndex = input.indexOf("\\n");

            String customSeparator = input.substring(2, customIndex);
            String tokenPart = input.substring(customIndex + 2);

            tokens = tokenPart.split(customSeparator + "|,|:");
        } else {
            tokens = input.split("[,:]");
        }

        int sum = getSum(tokens);
        System.out.println("결과 : " + sum);
    }

    private static int getSum(String[] tokens) {
        int sum = 0;
        for (String token  : tokens) {
            if (token.contains(" ")) {
                throw new IllegalArgumentException("잘못된 입력입니다. 토큰에 공백을 포함할 수 없습니다.");
            } else {
                try {
                    int parsedNumber = Integer.parseInt(token.trim());

                    if (parsedNumber <= 0) {
                        throw new IllegalArgumentException("잘못된 숫자입니다. 숫자는 양수만 사용 가능합니다.");
                    }
                    sum += parsedNumber;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("잘못된 입력입니다. 토큰은 숫자로만 이루어집니다.");
                }
            }
        }
        return sum;
    }
}

