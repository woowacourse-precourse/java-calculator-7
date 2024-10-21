package calculator;

/**
 * // 만 입력했을 때 \n은 없으니까 //만 입력했을 때에 대한 예외 처리 필요함.
 */
public class DelimiterStrategyFactory {
    public static DelimiterStrategy create(String input) {
        if (input.startsWith("//")) {
            String customDelimiter = extractCustomDelimiter(input);
//            System.out.println("customDelimiter : " + customDelimiter);
            return new CustomDelimiterStrategy(customDelimiter);
        }
        return new CommaColonStrategy();
    }

    public static String extractCustomDelimiter(String input) {
        int newLineIndex = -1;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '\\' && input.charAt(i + 1) == 'n') {
                newLineIndex = i;
                break;
            }
        }
        return input.substring(2, newLineIndex);
    }
}
