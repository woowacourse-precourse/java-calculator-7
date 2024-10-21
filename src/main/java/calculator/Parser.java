package calculator;

import java.util.ArrayList;
import java.util.Arrays;

public class Parser {

    public static ArrayList<String> separatorList = new ArrayList();

    private Parser() {

    }

    public static int parseAndCalculate(String inputStr) {
        // 입력값이 null인 경우
        if(inputStr == null) {
            throw new IllegalArgumentException();
        }

        if(inputStr.trim().isEmpty()) {
            return 0;
        }

        if(isCustomSeparator(inputStr)) {
            addCustomSeparator(inputStr);
            inputStr = inputStr.replace("//"+inputStr.charAt(2)+"\\n","");
        }
        int result = 0;

        // TODO: 구분자에 걸리는 숫자 하나씩 떼야함
        StringBuilder regex = new StringBuilder("[");
        for(String string : separatorList) {
            regex.append(string);
        }
        regex.append("]");

        String[] splitResult = inputStr.split(regex.toString());

        for(String numStr : splitResult) {
            int num = Integer.parseInt(numStr);
            if(num <=0 ) {
                throw new IllegalArgumentException();
            }
            result += num;
        }

        return result;
    }

    public static void addCustomSeparator(String inputStr) {

        separatorList.add(Character.toString(inputStr.charAt(2)));
    }

    public static boolean isCustomSeparator(String inputStr) {
        return inputStr.startsWith("//");
    }

    public static void setSeparator() {
        separatorList.add(",");
        separatorList.add(":");
    }
}