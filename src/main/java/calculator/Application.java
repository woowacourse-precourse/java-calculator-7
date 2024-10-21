package calculator;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // 0. 문자열 입력받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();

        Calc calc = new Calc(input);

    }
}

class Calc {
    private static Set<String> sep = new HashSet<String>();
    private String input;
    private int[] numArr;

    Calc(String input) {
        this.input = input;
        setSepAndInput();
    }

    // 1. 구분자 저장 및 input에서 커스텀 구분자 분리하기
    private void setSepAndInput() {
        sep.add(",");
        sep.add(":");

        // "//" "\n" 사이 단어 추출
        Pattern pattern = Pattern.compile("//(.*?)(?=\\\\n)");
        Matcher matcher = pattern.matcher(input);

        if(matcher.find()) {
            String customSep = matcher.group(1);
            sep.add(escapeRegexSpecialChars(customSep)); // 이스케이프 처리 후 추가
            this.input = input.replace(matcher.group(0), "").replace("\\n", "").trim(); // 첫 번째 매칭된 문자열 제거

        }
    }

    // 정규 표현식 특수 문자 앞에 "\\" 붙이기
    private String escapeRegexSpecialChars(String input) {
        String[] specialChars = {"\\", "[", "]", "(", ")", "{", "}", "^", "$", ".", "|", "*", "+", "?"};

        StringBuilder escapedString = new StringBuilder();

        for (char c : input.toCharArray()) {
            boolean isSpecialChar = false;
            for (String special : specialChars) {
                if (String.valueOf(c).equals(special)) {
                    escapedString.append("\\").append(c);
                    isSpecialChar = true;
                    break;
                }
            }
            if (!isSpecialChar) {
                escapedString.append(c);
            }
        }
        return escapedString.toString();
    }

    // 2. 숫자 구분하기
    private int[] getNumArr() {
        String regex = String.join("|", sep);

        try {
            numArr = Arrays.stream(input.split(regex))
                    .mapToInt(s -> {
                        try {
                            if (s == null || s.isEmpty()) {
                                return 0; // 빈 문자열 또는 null은 0으로 처리
                            }

                            int value = Integer.parseInt(s); // 문자열을 숫자로 변환

                            if (value < 0) {
                                throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + value);
                            }

                            return value; // 양수는 그대로 반환
                        } catch (NumberFormatException e) {
                            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + s);
                        }
                    })
                    .toArray();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        return numArr;
    }


}

