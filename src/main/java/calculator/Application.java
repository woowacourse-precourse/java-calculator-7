package calculator;

import java.util.Objects;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // 입력받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String line = readLine();

        // custom 판별
        boolean custom = isCustom(line);

        // 구분자로 파싱
        String[] line_result = {};
        if (custom) {
            boolean found = false;
            char[] exceptional_chars = {'^','$','.','|','*','+','?','\\','(',')','{','}','[',']'};
            char delimiter = line.charAt(2);
            String substring = line.substring(5);

            for (char exceptional_char: exceptional_chars) {
                if (delimiter == exceptional_char) {
                    line_result = substring.split("\\" + String.valueOf(delimiter));
                    found = true;
                    break;
                }
            }
            if (!found)
                line_result = substring.split(String.valueOf(delimiter));
        }
        else {
            line_result = line.split(",|:");
        }

        // 파싱된 리스트 더하고 출력
        printSum(line_result);
    }

    // 기본 구분자 및 커스텀 구분자 판별
    public static boolean isCustom(String line) {
        //*\n
        if (line.length() >= 5) {
            if (line.charAt(0) == '/'
                    && line.charAt(1) == '/'
                    && line.charAt(3) == '\\'
                    && line.charAt(4) == 'n') {
                return true;
            } else return false;
        } else return false;
    }

    // 추출한 수 더하기 및 예외처리
    public static void printSum(String[] result) {
        int sum = 0;
        try {
            for (String s : result) {
                if (Objects.equals(s, "")) continue;
                int str2int = Integer.parseInt(s);
                if (str2int > 0) {
                    sum += str2int;
                }
                else {
                    throw new IllegalArgumentException();
                }
            }
            System.out.println("결과 : " + sum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}

