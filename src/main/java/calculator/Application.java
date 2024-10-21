package calculator;

import calculator.dto.CustomSeparationDto;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Application {

    private static CustomSeparationDto extractCustomSeparation(String inputStr) {
        //커스텀 구분자가 있는 경우
        if (inputStr.startsWith("//")) {
            CustomSeparationDto customSeparationDto = new CustomSeparationDto();
            int customSeparationStart = 2; // 구분자는 // 뒤에 시작됨
            int customSeparationEnd = 0;
            for (int charIndex = 0; charIndex < inputStr.length(); charIndex++) {
                if (Character.isDigit(inputStr.charAt(charIndex))) {
                    customSeparationEnd = charIndex - 2; // \n이라 2자리 빼야함.
                    break;
                }
            }
            if (customSeparationEnd != 0) {
                String customSeparation = inputStr.substring(customSeparationStart, customSeparationEnd);
                if (!customSeparation.isEmpty()) {
                    customSeparationDto.setCustomSeparation(customSeparation);
                    customSeparationDto.setCustomSeparationEnd(customSeparationEnd);
                    return customSeparationDto;
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }
        return null;
    }

    private static String[] extractToken(String inputStr, String separations) {

        if (separations.contains("\\n")) { //커스텀 구분자로 \\n을 사용하는 경우 \\n을 기본 구분자인 :로 치환
            inputStr = inputStr.replace("\\n", ":");
            separations = separations.replace("\\n", "");
        }

        separations = "[" + separations + "]";

        String[] tokens = inputStr.split(separations);
        return tokens;
    }

    private static ArrayList<Integer> extractIntegerAndDetectChar(String[] tokens) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            if (isDigit(token)) {
                int number = Integer.parseInt(token);
                if (number < 0) { //음수일 경우
                    throw new IllegalArgumentException();
                } else {
                    numbers.add(number);
                }
            } else { //숫자가 아닐 경우
                throw new IllegalArgumentException();
            }
        }
        return numbers;
    }

    private static boolean isDigit(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IllegalArgumentException {
//         TODO: 프로그램 구현

        System.out.println("덧셈할 문자열을 입력해주세요.");
        String inputStr = Console.readLine();
        String separations = ",:";
        String numbers = inputStr;
        CustomSeparationDto customSeparationDto = extractCustomSeparation(inputStr);

        if (customSeparationDto != null) {
            String customSeparation = customSeparationDto.getCustomSeparation();
            int customSeparationEnd = customSeparationDto.getCustomSeparationEnd();

            separations += customSeparation;
            numbers = inputStr.substring(customSeparationEnd + 2);
        }
        String[] tokens = extractToken(numbers, separations);
        ArrayList<Integer> integers = extractIntegerAndDetectChar(tokens);

        int sum = integers.stream().mapToInt(Integer::intValue).sum();

        System.out.println("결과 : " + sum);
    }
}
