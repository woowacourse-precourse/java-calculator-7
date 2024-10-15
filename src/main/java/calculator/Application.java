package calculator;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    private static int result = 0;
    private static List<String> delimiterList = new ArrayList<>(List.of(",", ":"));
    private static final String startCustom = "//";
    private static final String endCustom = "\\n";

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();
        if (input.startsWith(startCustom)) {
            addCustomDelimiter(input);
        }
        valid(input);
        calculate(input);
        System.out.println("결과 : " + result);
    }

    private static void addCustomDelimiter(String input) {
        Integer startIdx = input.indexOf(startCustom) + 2;
        Integer endIdx = input.indexOf(endCustom);
        if (startIdx != -1 && endIdx != -1 && startIdx < endIdx) {
            if (delimiterList.contains(input.substring(startIdx, endIdx))) {
                throw new IllegalArgumentException("이미 추가한 구분자는 custom 으로 지정할 수 없습니다.");
            }
            delimiterList.add(input.substring(startIdx, endIdx));
        } else {
            if (startIdx == -1 || endIdx == -1) {
                throw new IllegalArgumentException("커스텀 구분자를 추가 하기 위해선 //구분자\\n 형식 으로 입력 하세요.");
            }
            if (startIdx >= endIdx) {
                throw new IllegalArgumentException("커스텀 구분자를 입력 하세요.");
            }
        }
    }

    private static void valid(String input) {
        if(input.contains("\\n")){
            input = input.substring(input.indexOf("\\n") + 2);
        }
        if (isThereWrongValue(input)) {
            throw new IllegalArgumentException("잘못된 값이 입력 되었습니다.");
        }
        if (isWrongEquation(input)) {
            throw new IllegalArgumentException("잘못된 수식 입니다.");
        }
    }

    private static boolean isThereWrongValue(String input) {
        boolean wrongValue = false;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // 1. 숫자인지 확인
            if (isDigit(c)) continue;
            // 2. 구분자인지 확인
            boolean pass = true;
            for (String delimiter : delimiterList) {
                for (int j = 0; j < delimiter.length(); j++) {
                    if (input.charAt(i + j) != delimiter.charAt(j)) {
                        pass = false;
                        break;
                    } else {
                        pass = true;
                    }
                }
                if (pass) break;
            }
            if (pass) continue;
            wrongValue = true;
        }
        return wrongValue;
    }

    private static boolean isWrongEquation(String input) {
        boolean wrongEquation = false;
        // 맨 처음과 끝이 숫자 인지 확인
        if (!isDigit(input.charAt(0)) || !isDigit(input.charAt(input.length() - 1))) {
            return true;
        }
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (!isDigit(ch)) { // 구분자가 나타났다면
                for (String delimiter : delimiterList) {
                    if (input.startsWith(delimiter, i)) {
                        if (!isDigit(input.charAt(i - 1)) || !isDigit(input.charAt(i + delimiter.length()))) {
                            wrongEquation = true;
                        }
                    }
                }
            }
        }
        return wrongEquation;
    }

    private static boolean isDigit(char c) {
        return (c > 47 && c < 58) ? true : false;
    }

    private static void calculate(String input) {
        for (char ch : input.toCharArray()) {
            if (isDigit(ch)) result += ch - '0';
        }
    }
}
