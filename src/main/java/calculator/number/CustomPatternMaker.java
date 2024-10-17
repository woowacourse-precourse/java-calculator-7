package calculator.number;

public class CustomPatternMaker {

    public static String getCustomPattern(String input) {
        StringBuilder customPattern = new StringBuilder();
        // 커스텀 구분자를 찾아낸다.
        String customSeparator = input.substring(input.indexOf("//") + 2, input.indexOf("\\n"));
        // 커스텀 구분자가 문자로 되어있고 여러 개 사용할 수 있으므로 분리시켜준다.
        String[] customSeparators = customSeparator.split("");
        // 분리 시켜준 커스텀 구분자를 구분자로서 사용하기 위해 패턴을 생성한다.
        for (String separator : customSeparators) {
            customPattern.append("\\").append(separator).append("|");
        }
        return customPattern.toString();
    }
}
