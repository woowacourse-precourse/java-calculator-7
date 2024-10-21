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
                throw new IllegalArgumentException("한글과 알파벳은 입력할 수 없습니다.");

            if (line.isEmpty() || line == null) {
                throw new IllegalArgumentException("입력이 비어 있습니다.");
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
                    if (Integer.parseInt(str[i]) <= 0) throw new IllegalArgumentException("양수를 입력하세요.");
                    if (str[i].isEmpty()) {
                        str[i] = "0";
                    }


                    total += Integer.parseInt(str[i]);
                } catch (NumberFormatException e) {

                    throw new IllegalArgumentException("숫자가 아닙니다.");

                }
            }

            System.out.println("결과 : " + total);
        } catch (IllegalArgumentException e) {
            //throw new IllegalArgumentException();


            System.out.println("입력이 올바르지 않습니다." + e.getMessage());
        }
    }
}