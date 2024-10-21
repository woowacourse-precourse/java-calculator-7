package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요");
        String input = Console.readLine();

        boolean isValidInput = true;
        boolean isNegative = false;
        int sum = 0;
        StringBuilder numberBuilder = new StringBuilder(); // 리스트 대신에 사용하는 StringBuilder

        // 빈 문자일 경우
        if (input.isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '-') {
                // 음수 부호가 나오면 isNegative = true 설정
                isNegative = true;
            } else if (Character.isDigit(ch)) {
                // 숫자인 경우 숫자 빌더에 추가
                numberBuilder.append(ch);
            } else if (ch == ':' || ch == ',') {
                // 기본 구분자를 만나면 그 전까지의 숫자를 합산
                if (!numberBuilder.isEmpty()) {
                    int number = Integer.parseInt(numberBuilder.toString());

                    // 음수 값인지 확인
                    if (isNegative) {
                        number = -number; // 음수로 변환
                    }

                    if (number <= 0) {
                        System.out.println("양수만 입력 가능합니다: " + number);
                        isValidInput = false;
                        break;
                    } else {
                        sum += number; // 변환한 숫자 합계에 더하기
                    }

                    numberBuilder.setLength(0); // 빌더 초기화
                    isNegative = false; // 음수 플래그 초기화
                }
            } else {
                // 잘못된 입력일 경우
                System.out.println("잘못된 입력입니다.");
                isValidInput = false;
                break;
            }
        }

        // 유효한 입력인 경우 결과 출력
        if (isValidInput) {
            if (!numberBuilder.isEmpty()) {
                int number = Integer.parseInt(numberBuilder.toString());

                // 마지막으로 남아 있는 숫자가 음수인지 확인
                if (isNegative) {
                    number = -number; // 음수로 변환
                }

                if (number < 0) {
                    System.out.println("양수만 입력 가능합니다: " + number);
                    return;
                } else {
                    sum += number; // 마지막 숫자 합산
                }
            }
            // 결과 출력
            System.out.println("결과 : " + sum);
        }
    }
}