package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    // "덧셈할 문자열을 입력해주세요." 구문 출력
    private static void init_print() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    // ``Console.readLine()`` 함수를 이용하여 구분자와 양수로 구분된 문자열 입력받기
    private static String input() {
        return Console.readLine();
    }

    // 커스텀 구분자 존재 시, 커스텀 구분자 부분 분리하여 구분자에 추가하기
    private static String[] getCustomDelimiter(String str) {
        String regex = "//(.*?)\\\\n";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String remainingString = str.substring(matcher.end());
            // 구분자가 존재하지 않거나, 구분자가 빈 문자열인 경우
            if (customDelimiter.isEmpty()) {
                throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다. 구분자가 없습니다.");
            }
            return new String[]{customDelimiter, remainingString};
        } else {
            // 잘못된 커스텀 구분자 형식인 경우 처리
            if (str.startsWith("//")) {
                throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
            }
            // 커스텀 구분자가 없을 경우 기본 구분자로 처리
            return new String[]{"", str};
        }
    }

    // 나머지 문자열을 구분자로 파싱하기
    private static String[] parseString(String delimiter, String str) {
        checkLastCharacter(delimiter, str);
        String[] result = str.split(delimiter);
        if(result.length == 1 && str.length() != 1) {
            throw new IllegalArgumentException("입력 문자열에 유효한 구분자가 없습니다.");
        }
        return result;
    }

    // 구분자가 특수문자인지, 문자 or 숫자인지 판단
    private static String checkNewDelimiter(String delimiter) {
        if (delimiter.matches(".*[.*+?^${}()|\\[\\]\\\\].*")) {
            return Pattern.quote(delimiter);
        } else {
            return delimiter;
        }
    }

    // 마지막 글자가 구분자면 예외처리
    private static void checkLastCharacter(String delimiter, String str) {
        String[] delimiterList = delimiter.split("\\|");
        for (String del : delimiterList) {
            if (str.endsWith(del)) {
                throw new IllegalArgumentException("마지막 글자가 구분자일 수 없습니다.");
            }
        }
    }

    // 파싱된 양수를 더하는 기능
    private static int add(String[] integerList) {
        int sum = 0;
        for(String i : integerList) {
            int num;
            try {
                num = Integer.parseInt(i.trim());  // 숫자로 변환
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
            }
            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
            sum += num;
        }
        return sum;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            StringBuilder delimiter = new StringBuilder();
            delimiter.append(",|:");
            init_print();
            String str = input();
            if(str.isEmpty()) {
                str = "0";
            }
            String[] tempResult = getCustomDelimiter(str);
            if (!tempResult[0].isEmpty()) {
                String newDelimiter = checkNewDelimiter(tempResult[0]);
                delimiter.append("|").append(newDelimiter);
            }
            str = tempResult[1];
            String[] result = parseString(delimiter.toString(), str);
            System.out.println("결과 : " + add(result));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
