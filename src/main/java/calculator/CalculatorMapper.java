package calculator;

public class CalculatorMapper {
    private static final String CUSTOM_FORMAT_START = "//";
    private static final String CUSTOM_FORMAT_END = "\\n";

    public int[] splitStringToNumbers(String str) {
        if (str.startsWith(CUSTOM_FORMAT_START)) {
            return splitWithCustomSegment(str);

        } else if (str.contains(",") || str.contains(":")) {
            return splitWithDefaultSegment(str);

        } else {
            if (str.isEmpty()) {
                return new int[0];
            }
            return null;
        }
    }

    private int[] splitWithCustomSegment(String str) {
        int customEndIndex = str.indexOf(CUSTOM_FORMAT_END);    //커스텀 지정 형식이 끝나는 인덱스 추출
        String customSegment = str.substring(2, customEndIndex);  //지정 커스텀 문자 추출
        String[] splitStr = str.substring(customEndIndex + 2).split(customSegment);    //커스텀 형식을 제외한 문자열 분리
        return mapStringToNumbers(splitStr);
    }

    private int[] splitWithDefaultSegment(String str) {
        String[] defaultSplit = str.split(",|:");   //기본 구분자로 문자 분리
        return mapStringToNumbers(defaultSplit);
    }

    //구분자를 기준으로 추출된 문자열 배열을 숫자 배열로 매핑 해주는 함수
    private int[] mapStringToNumbers(String[] str) {
        int[] newIntArray = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            newIntArray[i] = Integer.parseInt(str[i]);
        }
        return newIntArray;
    }
}
