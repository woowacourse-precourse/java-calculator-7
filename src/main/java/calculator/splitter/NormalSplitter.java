package calculator.splitter;

import calculator.calc.CalculatorConst;

import java.util.regex.Pattern;

public class NormalSplitter implements Splitter { //todo -> Make Regex splitter

    public String[] split(String input) {
        String delimiter = CalculatorConst.DEFAULT_DELIMITERS; // 기본 문자열 설정

        if (input.startsWith("//")) {       // 커스텀 문자열 설정했는지
            int idx = input.indexOf("\\n"); // '\n' 인덱스 찾기
            if (idx == -1) {                // 없으면 Exception
                throw new IllegalArgumentException();
            }

            String token = input.substring(2, idx);     // 커스텀 구분자 추출
            delimiter += "|" + escapeRegex(token);      // 특수 문자를 Escape 처리 후 구분자에 추가

            return input.substring(idx + 2)
                    .split(delimiter); //커스텀 구분자가 맞다면 '\n' 이후 문자열로부터 분리
        }
        return input.split(delimiter); //커스텀 구분자가 아니면 기본 구분자를 통해 분리
    }

    private String escapeRegex(String input) {
        return Pattern.quote(input); //특수 문자 Escape 처리
    }
}