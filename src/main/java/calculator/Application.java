package calculator;
import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        UserInput input = new UserInput();
        SumNumbers sumNumber = new SumNumbers();

        System.out.println("결과 : " + sumNumber.sum(input.userInput()));

    }
}

class UserInput {
    public String[] userInput() {
        String input = Console.readLine();

        String delimiter = ",|:";
        String[] strList;

        if(input.startsWith("//")) {
            int customDelimiterIndex = input.indexOf("\\n");

            String customDelimiter = input.substring(2, customDelimiterIndex);
            String regex = delimiter + "|" + Pattern.quote(customDelimiter);
            input = input.substring(customDelimiterIndex + 2);

            strList = input.split(regex);
        } else {
            strList = input.split("[,:]");
        }

        isValid(strList);

        return strList;
    }
    //IllegalArgumentException
    public void isValid(String[] strList) {
        for(String s : strList) {
            if(!s.matches("\\d+")) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
    }
}

class SumNumbers {
    public int sum(String[] strList) {
        int result = 0;

        for(String s : strList) {
            int num = Integer.parseInt(s);

            if(num > 0) {
                result += num;
            }
        }

        return result;
    }
}