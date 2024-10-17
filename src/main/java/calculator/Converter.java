package calculator;

public class Converter {

    public static String[] convert(String data) { // 구분자를 포함한 입력값을 숫자 배열로 변환
        data = data.replace(" ", "");
        String seperators = ",:";

        int start = data.indexOf("//");
        int end = data.indexOf("\\n");
        if (start != -1 && end != -1) {
            seperators = data.substring(start + 2, end);
            return data.substring(end + 2).split("[" + seperators + "]");
        } else {
            return data.split("[" + seperators + "]");
        }

    }
}
