package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.InstanceOfAssertFactories.type;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            int total = 0;
            String separator = null;
            String num = null;
            String[] str;

            System.out.println("덧셈할 문자열을 입력해주세요. ");
            String line = Console.readLine().trim();

            if (line.matches(".*[A-Z가-힣]+.*"))
                throw new IllegalArgumentException();

            if (line.isEmpty() || line == null) {
                throw new IllegalArgumentException();
            }

            Pattern pattern = Pattern.compile("//(.)\\\\n(.*)");
            Matcher sep = pattern.matcher(line);


            if (sep.find() && !sep.group(1).isEmpty() && !sep.group(1).equals(" ")) {
                separator = sep.group(1);
                num = sep.group(2);
                String fullseperator = Pattern.quote(separator) + "|,|:";

                str = num.split(fullseperator);


            } else {
                str = line.split(":|,");
            }


            for (int i = 0; i < str.length; i++) {
                try {
                    if (Integer.parseInt(str[i]) <= 0) throw new IllegalArgumentException();
                    if (str[i].isEmpty()) {
                        str[i] = "0";
                    }
                    total += Integer.parseInt(str[i]);
                } catch (NumberFormatException e) {

                    throw new IllegalArgumentException();

                }
            }

            System.out.println("결과 : " + total);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}