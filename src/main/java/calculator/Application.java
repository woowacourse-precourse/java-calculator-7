package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String separators = ",|:";
        int sum = 0;
        Application app = new Application();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();

        String pattern = "^(//.+\\\\n)*([0-9]+(.+[0-9]+)*|)$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        if (!m.find()) {
            throw new IllegalArgumentException();
        }
        System.out.println(m.group(1));
        if (!(m.group(1) == null)) {
            separators = app.buildSeparators(m.group(1));
        }
        sum = app.sumNums(m.group(2), separators);
        System.out.println("결과 : " + sum);
    }

    private String buildSeparators(String input) {
        String separators = ",|:";
        String[] inputSeparators = input.split("\\\\n");
        for (String separator : inputSeparators) {
            separators += "|";
            separators += separator.substring(2);
        }
        return separators;
    }

    private int sumNums(String input, String separators) {
        int sum = 0;
        String[] inputNums = input.split(separators);
        for (String num : inputNums) {
            sum += stringToInt(num);
        }
        return sum;
    }

    private int stringToInt(String num) {
        if (num.isBlank()) {
            return 0;
        }
        try {
            return Integer.parseInt(num);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
