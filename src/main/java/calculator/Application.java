package calculator;
import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Character.isDigit;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            int total = 0;
            String separator = null;
            String num = null;
            String[] str= null;

            System.out.println("덧셈할 문자열을 입력해주세요. ");
            String line = Console.readLine();

            if(line.isEmpty()|| line==null){
                str[0] = String.valueOf(0);
            }

            if(line.matches(".*[가-힣]+.*")|| line.contains("-"))
                throw new IllegalArgumentException("한글은 입력할 수 없습니다.");

            Pattern pattern = Pattern.compile("//(.)\\\\n(.*)");
            Matcher sep = pattern.matcher(line);

            if (sep.find()) {
                separator = sep.group(1);
                if(isDigit(Integer.parseInt(separator))) throw new IllegalArgumentException("구분자 오류");
                else{num = sep.group(2);
                str = num.split(separator + "|,|:");}

            } else {
                str = line.split(":|,");
            }

            for (int i = 0; i < str.length; i++) {
                try {
                    if(Integer.parseInt(str[i])<=0) throw new IllegalArgumentException("양수를 입력하세요.");
                    else total += Integer.parseInt(str[i]);

                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("숫자를 입력하세요.");
                }
            }

            System.out.println("결과 : " + total);
        } catch(IllegalArgumentException e){
            System.out.println("입력이 올바르지 않습니다." + e.getMessage());
        }
    }
}