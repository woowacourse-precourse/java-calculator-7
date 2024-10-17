package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ArrayFunction {
    //문자열을 지정기호 등을 구하고 숫자만 남은 문자형 배열로 리턴한다.
    static String[] parseNumbersFromString(String inputVal) {
        String[] parseArray;
        String customSymbol = "";
        if (inputVal.startsWith("//")) {// 커스텀 기호 포함!
            // 우선 특수기호를 구한다.
            Pattern pattern = Pattern.compile("//(.*?)\\\\n");
            Matcher matcher = pattern.matcher(inputVal);

            while (matcher.find()) {
                customSymbol = matcher.group(1);
            }

            inputVal = inputVal.replaceAll("//.*?\\\\n", "");
        }

        if (customSymbol.isEmpty()) {
            parseArray = inputVal.split("[:|,]");
        } else {
            parseArray = inputVal.split("[:|,|" + customSymbol + "]");
        }

        return parseArray;
    }

    // 문자형 배열을 전달받고 파싱하여 더한 값을 리턴해준다.
    static int resultSumValue(String[] parseArray) {
        int[] numArray = Arrays.stream(parseArray).mapToInt(value -> {
            try {
                if (value.isEmpty()) {
                    return 0;
                }

                int idNum =  Integer.parseInt(value.replace(" ", ""));
                if (idNum > 0) {
                    return idNum;
                } else {
                    throw new IllegalArgumentException("숫자 중 음수가 존재하면 안됩니다.");
                }
            } catch (NumberFormatException nfe) {
                throw new IllegalArgumentException("지정되지 않은 기호가 문자열에 있습니다.");
            }
        }).toArray();

        return Arrays.stream(numArray).sum();
    }


    // private 생성자
    private ArrayFunction() {
        throw new IllegalArgumentException("lint에 따라 유틸리티 클래스는 생성자를 private으로 생성합니다.");
    }
}
