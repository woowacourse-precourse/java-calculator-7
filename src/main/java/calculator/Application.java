package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    static Character customDelemiter;
    public static void main(String[] args) {

        String input = Console.readLine();
        String prefix = input.split("\n")[0];

        if (prefix != null && !prefix.isEmpty()) {
            customDelemiter = getCustomDelimiter(prefix);
        }


        Console.close();
    }

    private static Character getCustomDelimiter(String input) {

        Pattern pattern = Pattern.compile("//(.*?)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String delimiter = matcher.group(1);    // //와 \n 사이의 내용 추출
            if (delimiter.length() > 1) return null;    // 예외처리 필요
            return delimiter.charAt(0);
        }
        return null;
    }

}
