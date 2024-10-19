package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 1. 입력 받은 문자열이 "커스텀 문자열"로 시작하는지 확인
        String inputText = Console.readLine();
        String separator = "";
        int totalSum = 0;
        if (inputText.startsWith("//")) {
            // "//"로 시작했기 때문에 "//문자\n" 형태여야 함. [5:]
            try {
                if (inputText.startsWith("\\n", 3)) {
                    separator = inputText.substring(2, 3);
                    String[] splitText = inputText.substring(5).split(separator);
                    for (String num : splitText) {
                        try {
                            int inputNum = Integer.parseInt(num);
                            if (inputNum <= 0) {
                                System.out.println("입력 오류: 양수를 입력해주세요");
                                throw new IllegalArgumentException();
                            }
                            totalSum += inputNum;
                        } catch (NumberFormatException e) {
                            System.out.println("입력 오류: 숫자를 입력해주세요");
                            throw new IllegalArgumentException();
                        }
                    }
                }
                else {
                    // 에러 식별을 위한 확인
                    if (inputText.contains("\\n")) {
                        System.out.println("입력 오류: 커스텀 구분자 길이가 2 이상입니다.");
                    } else {
                        System.out.println("입력 오류: 커스텀 구분자 양식을 확인해주세요");
                    }
                    throw new IllegalArgumentException();
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("입력 오류: 커스텀 구분자 양식을 확인해주세요");
                throw new IllegalArgumentException();
            }
        } else {
            // 2. 커스텀 문자열로 시작하지 않는다면, 기본 구분자를 포함하는지 확인
            if (inputText.contains(",") || inputText.contains(":")) {
                // 기본 구분자를 포함한다면, 이를 기준으로 분리
                String[] splitText = inputText.split("[,:]");
                for (String num : splitText) {
                    try {
                        int inputNum = Integer.parseInt(num);
                        if (inputNum <= 0) {
                            System.out.println("입력 오류: 양수를 입력해주세요");
                            throw new IllegalArgumentException();
                        }
                        totalSum += inputNum;
                    } catch (NumberFormatException e) {
                        System.out.println("입력 오류: 숫자를 입력해주세요");
                        throw new IllegalArgumentException();
                    }
                }
            } else {
                // 3. 기본 구분자도 포함하지 않는다면, 잘못된 입력
                System.out.println("입력 오류: 올바른 구분자를 입력해주세요");
                throw new IllegalArgumentException();
            }
        }
        System.out.printf("결과 : %d\n", totalSum);
    }
}
