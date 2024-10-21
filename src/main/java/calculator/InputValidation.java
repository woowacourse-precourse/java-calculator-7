package calculator;


public class InputValidation { // 입력의 유효성을 확인하는 클래스이다.

    //커스텀 구분자의 유효성에 대해 확인하는 메서드이다.
    public static String[] checkCustomDelimiter(String input) {
        String[] custom_RemainInput = new String[2];

        //커스텀 구분자가 존재한다면 유효성 검사와 함께 추출을 시도한다.
        if (input.contains("//") && input.contains("\\n")) {
            int startCustom = input.indexOf("//");
            int endCustom = input.indexOf("\\n");
            if (startCustom != 0 || startCustom > endCustom || endCustom - startCustom != 3) {
                throw new IllegalArgumentException();
            }
            custom_RemainInput[0] = input.substring(startCustom + 2, endCustom); // 커스텀 구분자
            custom_RemainInput[1] = input.substring(endCustom + 2); // 커스텀구분자와 지정문자 이후의 input으로 업데이트한다.
            return custom_RemainInput;
        }
        return null;
    }

    //Input 자체의 유효성을 확인하는 메서드이다.
    public static String CheckInput(String input, String customDelimiter) {
        if (input.isEmpty()) {
            return null;
        }

        String delimiter = "[,:";  // 기본 구분자 처리
        if (customDelimiter != null && !customDelimiter.isBlank()) {
            delimiter += customDelimiter; // 커스텀 구분자가 있었으면 이를 추가한다.
        }
        delimiter += "]";

        String[] inputTokens = input.split(delimiter); // 구분자를 바탕으로 문자열을 분류한다.
        for (String token : inputTokens) {
            checkNumber(token);
        }
        return delimiter;
    }

    //입력된 값이 숫자인지 그 유효성을 확인하는 메서드이다.
    public static void checkNumber(String token) {
        try {
            int number = Integer.parseInt(token); // 입력이 숫자가 아니라면 예외를 터뜨린다.
            if (number < 0) {
                throw new IllegalArgumentException("양수만 사용이 가능합니다. => " + token);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바르지 않은 입력입니다. => " + token);
        }
    }
}
