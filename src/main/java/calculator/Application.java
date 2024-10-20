package calculator;
import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int total = 0;
        String separator = null;
        String num = null;
        String[] str;


        System.out.println("덧셈할 문자열을 입력해주세요. ");
        String line = Console.readLine();

        Pattern pattern = Pattern.compile("//(.)\\\\n(.*)");
        Matcher sep = pattern.matcher(line);

        if (sep.find()) {
            separator = sep.group(1);
            num = sep.group(2);
            str = num.split(Pattern.quote(separator) + "|,|:");

        } else {
            str = line.split(":|,");
        }


        for (int i = 0; i < str.length; i++) {
            try {
                total += Integer.parseInt(str[i]);
            } catch (NumberFormatException e) {
                total += 0;
            }
        }

        System.out.println("결과 : " + total);
    }
}