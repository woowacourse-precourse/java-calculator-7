package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String calcFormula = readLine();
        String customSeparator = extractCustomSeparator(calcFormula);
    }

    public static String extractCustomSeparator(String calcFormula) {
        String regex = "/{2}.\\\\n";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(calcFormula);

        StringBuilder customSeparator = new StringBuilder();

        while (matcher.find()) {
            customSeparator.append(matcher.group().charAt(2));
        }

        return customSeparator.toString();
    }
}
