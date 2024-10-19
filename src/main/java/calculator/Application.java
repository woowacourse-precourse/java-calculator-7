package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.net.InterfaceAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        List<String> sepList = inputSeparate(input);

        String delimiter = sepList.get(0);
        String str = sepList.get(1);

        // 문자열파트가 공백이라면 0 출력
        if (str.isEmpty()){
            System.out.println("결과 : " + 0);
        }
    }

    // 입력을 구분자파트와 문자열파트로 분리하는 메서드
    public static List<String> inputSeparate(String input){
        int start = input.indexOf("//");
        int end = input.indexOf("\\n");

        // 구분자파트가 없는 경우
        if (start == -1 && end == -1){
            return Arrays.asList("", input);
        }
        // 구분자 파트가 잘 들어온 경우
        else if (start == 0 && end == 3) {
            String delPart = String.valueOf(input.charAt(2));
            String strPart = input.substring(end + 2);

            return Arrays.asList(delPart, strPart);
        } else {
            throw new IllegalArgumentException("올바른 입력값을 넣어주세요.");
        }
    }

    // 문자열을 구분자로 구분해주는 메서드
    private static List<Integer> splitter(String delimiter, String str) {
        String[] splitedStringList = str.split("[" + Pattern.quote(delimiter) + ",:]");
        System.out.println("strSplitByDelimiter : " + Arrays.toString(splitedStringList));

        List<Integer> intList = new ArrayList<>();

        try {
            for (String strNum : splitedStringList){
                int intNum = Integer.parseInt(strNum);
                intList.add(intNum);
            }
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("구분자를 올바르게 입력하세요.");
        }

        return intList;
    }


}
