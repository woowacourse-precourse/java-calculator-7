package calculator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String a = readLine();
        System.out.println("결과 : " + calculate(a));
    }

    public static int calculate(String text){
        int sum = 0;
        String[] separatorAndText = {"",""};
        String separator = "[,:]";
        if(text.isEmpty()){
            return 0;
        }
        if(isPattern(text)){
            separatorAndText = CustomSeparator(text);
            separator = separatorAndText[0];
            text = separatorAndText[1];
        }

        String[] suspectedNumbers = text.split(separator);

        for (String suspectedNumber : suspectedNumbers) {
            int parsedNumber = Integer.parseInt(suspectedNumber);
            if(parsedNumber < 0){
                throw new IllegalArgumentException("음수가 입력되었습니다.");
            }

            sum += parsedNumber;
        }
        return sum;
    }

    public static String[] CustomSeparator(String text){
        String[] separatorAndText = {"",""};
        Pattern pattern = Pattern.compile("//(.*?)(\\\\n)");
        Matcher matcher = pattern.matcher(text);

        if(matcher.find()){
            separatorAndText[0] = matcher.group(1);
            separatorAndText[1] = text.replace(matcher.group(0), "");
            return separatorAndText;
        }else{
            return new String[0];
        }
    }
    public static boolean isPattern(String text){
        Pattern pattern = Pattern.compile("//(.*?)\\\\n");
        Matcher matcher = pattern.matcher(text);

        return matcher.find();
    }
}
