package calculator;

import static calculator.Utils.getString;
import static calculator.Utils.printResult;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Machine {
    static final String baseRegex = "[,;]";
    static final String metaChars = ".^$*+?()[]{}|\\";

    String custom;
    String string;

    public Machine() {
    }


    private static String escapeMetaChars(String input) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            // 입력 문자가 정규식 메타 언어일 때
            if (metaChars.indexOf(c) != -1) {
                result.append('\\');
            }
            result.append(c);
        }
        return result.toString();
    }

    private void setDelimiter(String string) {
        String regex = "//(.)\\\\n";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        if (matcher.find()) {
            // 커스텀 구분자 지정 문자열이 입력문자열의 앞이 아닐 때, 예외 처리
            if (matcher.start() != 0) {
                throw new IllegalArgumentException("커스텀 구분자가 문자열의 앞이 아닌 부분에서 정의됨");
            }

            this.custom = escapeMetaChars(matcher.group(1));
            this.string = string.substring(matcher.end());
        }
    }

    private String[] splitString(String string) {
        String regex = baseRegex;

        if (string.isEmpty()) {
            return new String[0];
        }

        if (this.custom != null) {
            regex = regex + "|" + this.custom;
        }

        return string.split(regex);
    }

    private static long sum(String[] strArray) {
        long result = 0L;

        for (String str : strArray) {
            // 빈 문자열은 0으로 취급
            if (str.isEmpty()) {
                continue;
            }
            // 양수 형식이 아닌 문자열일 시 예외 처리
            if (!str.matches("[0-9.]+")) {
                throw new IllegalArgumentException("양수가 아닌 형태의 문자열");
            }

            long num;
            num = Long.parseLong(str);
            result += num;
        }
        return result;
    }

    public void run() {
        this.string = getString();
        setDelimiter(this.string);

        String[] temp = splitString(this.string);
        long result = sum(temp);

        printResult(result);
    }
}
