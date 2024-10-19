package calculator;

public class CalculatorFactory {
    private static final String CUSTOM_FORMAT_START = "//";
    private static final String CUSTOM_FORMAT_END = "\\n";

    public int[] splitStringToNumbers(String str) {
        //입력된 문자열이 커스텀 지정 구분자일경우
        if (str.startsWith(CUSTOM_FORMAT_START)) {
            int customEndIndex = str.indexOf(CUSTOM_FORMAT_END);    //커스텀 지정 형식이 끝나는 인덱스 추출
            String customSegment = str.substring(2, customEndIndex);  //지정 커스텀 문자 추출
            String removedCustomFormat = str.substring(customEndIndex + 2);    //커스텀 형식을 제외한 문자열 추출
            String[] splitStr = removedCustomFormat.split(customSegment);  //커스텀 문자를 기준으로 문자열 분리
            return mapStringToNumbers(splitStr); //분리된 문자열 배열을 숫자 배열로 매핑

        } else if (str.contains(",") || str.contains(":")) {     //입력된 문자열에 기본 구분자가 포함될 경우
            String[] defaultSplit = str.split(",|:");   //기본 구분자로 문자 분리
            return mapStringToNumbers(defaultSplit);

        } else { //구분자가 포함되어 있지 않을 경우
            if (str.isEmpty()) {
                return new int[0];
            }
            return null;
        }
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
