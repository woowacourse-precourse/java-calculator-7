package calculator;

public class StringSeparator { //TODO: 구분자를 인식하고, 구분자로 분리된 문자열 반환
    public static String[] separator(String input) { //StringSeparator 의 메인 로직
        String separator = "[,:]";
        String refinedString = getRefinedInput(input);
        return refinedString.split(separator);
    }

    private static String getRefinedInput(String input) { //인풋값을 받아, 커스텀 구분자를 정의하고 ","로 바꾼 후 문자열 반환
        if (hasCustomSeparator(input)) {
            /*
             * "\n"을 기준으로 좌, 우 string을 나눈다.
             * 좌측 string에서는 구분자를 찾아낸다.
             * 우측 string에서 구분자를 ","로 변환해서 반환한다.
              */
            int center = input.indexOf("\\n");
            String leftString = input.substring(0, center);
            String customSpliter = findSeparator(leftString);

            String rightString = input.substring(center + 2);
            return rightString.replace(customSpliter, ",");
        }
        return input;
    }

    private static boolean hasCustomSeparator(String input) {
        return input.startsWith("//");
    }

    private static String findSeparator(String leftString) {
        return leftString.substring(2);
    }
}
