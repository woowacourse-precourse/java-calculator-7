package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String inputText = Console.readLine();
        int totalSum;

        if (isCustomSeparator(inputText)) {
            totalSum = getTotalSum(inputText, true);
        } else if (isDefaultSeparator(inputText)) {
            totalSum = getTotalSum(inputText, false);
        } else {
                System.out.println("입력 오류: 올바른 구분자를 입력해주세요");
                throw new IllegalArgumentException();
        }
        System.out.printf("결과 : %d\n", totalSum);
        }

    private static boolean isCustomSeparator(String inputText) {
        if (inputText.startsWith("//")) {
            try {
                // "//문자\n" 형태라면 올바른 입력
                if (inputText.startsWith("\\n", 3)) {
                    return true;
                }
                // 에러 식별
                if (inputText.contains("\\n")) {
                    System.out.println("입력 오류: 커스텀 구분자가 두 글자 이상입니다.");
                } else {
                    System.out.println("입력 오류: 올바른 커스텀 구분자 양식이 아닙니다.");
                }
                throw new IllegalArgumentException();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("입력 오류: 커스텀 구분자 양식을 확인해주세요");
                throw new IllegalArgumentException();
            }
        }
        return false;
    }

    private static boolean isDefaultSeparator(String inputText) {
        return inputText.contains(",") || inputText.contains(":");
    }

    private static int getTotalSum(String inputText, boolean isCustomSeparator) {
        String[] splitText;
        int totalSum = 0;

        String separator = isCustomSeparator ? inputText.substring(2, 3) : "[,:]";
        splitText = isCustomSeparator ? inputText.substring(5).split(separator) : inputText.split(separator);

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
        return totalSum;
    }
}