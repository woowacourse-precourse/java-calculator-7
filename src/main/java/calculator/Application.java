package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;
import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static String[] searchIdentifier(String equation){
        String splitText[] = equation.split("//(.*)\\\\n");

        Pattern pattern = Pattern.compile("//(.*)\\\\n");
        Matcher matcher = pattern.matcher(equation);

        String t = " ";

        while (matcher.find()) {  // 일치하는 게 있다면
            t = matcher.group(1);

            if(matcher.group(1) ==  null)
                break;
        }
        String newEquation[] = new String[2];
        newEquation[0] = t;
        newEquation[1] = splitText[1];

        return newEquation;
    }
    public static int calculate(String equation, String identifier){
        int sum = 0;
        for (String num : equation.split(identifier)) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String equation = readLine();
        int result = 0;

        try{
            if(equation.matches("//(.*)\\\\n(.*)")) {

                String[] newEquation = searchIdentifier(equation);
                result = calculate(newEquation[1], newEquation[0]);

            }
            else if(!(!equation.contains(",") || !equation.contains(":"))){
                result = calculate(equation, ",|:");
            }
            else{
                throw new IllegalArgumentException();
            }
            System.out.println("결과 : " + result);
        }catch(IllegalArgumentException e) {
            throw e;
        }

    }
}
