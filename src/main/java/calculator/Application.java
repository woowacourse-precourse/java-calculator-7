package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요");
        String input = Console.readLine();

        boolean isNegative = false;
        int sum = 0;
        StringBuilder numberBuilder = new StringBuilder(); // 리스트 대신에 사용하는 StringBuilder

        if (input.isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }

        // 커스텀 구분자 설정
        String customDelimiter = null;

        // 커스텀 구분자 추출
        if (input.startsWith("//")) {
            // Escape 문자와 헷갈리는 문제 발생 - > "\\n"을 실제 개행 문자로 변환
            input = input.replace("\\n", "\n");

            if (input.startsWith("//")) {
                // 커스텀 구분자가 여러 글자일 경우를 위한 start, end 인덱스
                int delimiterStartIndex = input.indexOf("//") + 2;
                int delimiterEndIndex = input.indexOf("\n");

                if (delimiterEndIndex > delimiterStartIndex) {
                    customDelimiter = input.substring(delimiterStartIndex, delimiterEndIndex);  // 커스텀 구분자 추출
                    input = input.substring(delimiterEndIndex + 1);  // 구분자 이후의 입력값만 남김
                }
            }

            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);

                if (ch == '-') {
                    // 음수 부호가 나오면 isNegative = true 설정
                    isNegative = true;
                } else if (Character.isDigit(ch)) {
                    // 숫자인 경우 숫자 빌더에 추가
                    numberBuilder.append(ch);
                } else if (ch == ':' || ch == ',' || (customDelimiter != null && input.substring(i).startsWith(customDelimiter))) {
                    // 기본 구분자 또는 커스텀 구분자를 만나면 그 전까지의 숫자를 합산
                    if (!numberBuilder.isEmpty()) {
                        int number = Integer.parseInt(numberBuilder.toString());

                        // 음수 값인지 확인
                        if (isNegative) {
                            number = -number; // 음수로 변환
                        }

                        // 양수가 아닌 수 처리
                        if (number <= 0) {
                            throw new IllegalArgumentException("양수만 입력 가능합니다: " + number);
                        }

                        sum += number;
                        numberBuilder.setLength(0);
                        isNegative = false;
                    }

                    // 커스텀 구분자일 경우 구분자의 길이만큼 건너뜀
                    if (customDelimiter != null && input.substring(i).startsWith(customDelimiter)) {
                        i += customDelimiter.length() - 1;
                    }
                } else {
                    throw new IllegalArgumentException("잘못된 입력입니다: " + ch);
                }
            }

            // 마지막 숫자 처리
            if (!numberBuilder.isEmpty()) {
                int number = Integer.parseInt(numberBuilder.toString());

                if (isNegative) {
                    number = -number;
                }

                if (number <= 0) {
                    throw new IllegalArgumentException("양수만 입력 가능합니다: " + number);
                }

                sum += number;
            }

            System.out.println("결과 : " + sum);
        }
    }
}
