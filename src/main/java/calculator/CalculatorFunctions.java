package calculator;

public class CalculatorFunctions {

    private static String DEFAULT_DELIMITER = ",|:";

    public static int splitAndSum(String str) {

        String[] token = str.split(DEFAULT_DELIMITER);
        return addToken(token);
    }

    public static int addToken(String[] tokens) {
        int sum = 0;

        for (String token : tokens) {
            if(token.isEmpty()) {
                throw new IllegalArgumentException("잘못된 형식: 구분자를 연속으로 사용하였습니다.");
            }

            if(!token.matches("\\d+")) {
                throw new IllegalArgumentException("잘못된 형식 : 숫자가 아닌 값이 포함되었습니다.");
            }

            sum += Integer.parseInt(token);
        }
        return sum;
    }

    public static String customDelimiter(String input) {
        int delimiterIndex = input.indexOf("\\n");
        if(delimiterIndex == -1 ) {
            throw new IllegalArgumentException("잘못된 형식 : 커스텀 구분자가 잘못 지정되었습니다.");
        }

        String customDelimiter = input.substring(2, delimiterIndex);
        if(customDelimiter.length() != 1) {
            throw new IllegalArgumentException("잘못된 형식 : 커스텀 구분자가 잘못 지정되었습니다.");
        }
        String str = input.substring(delimiterIndex + 2);
        addNewDelimiter(changeMetaCharacters(customDelimiter));

        return str;
    }

    public static String changeMetaCharacters(String customDelimiter) {
        // 메타 문자들
        String[] metaCharacters = {".", "*", "+", "?", "^", "$", "(", ")", "[", "]", "{", "}", "|", "\\"};

        // 각 메타 문자를 이스케이프 처리
        for (String metaCharacter : metaCharacters) {
            if (customDelimiter.contains(metaCharacter)) {
                customDelimiter = "\\" + customDelimiter;
                break;
            }
        }
        return customDelimiter;
    }

    public static void addNewDelimiter(String customDelimiter) {
         DEFAULT_DELIMITER = DEFAULT_DELIMITER + "|" + customDelimiter;
    }
}
