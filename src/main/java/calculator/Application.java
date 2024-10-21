package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String numDelimiterString = Console.readLine();
        System.out.println(numDelimiterString);
        try {
            int addResult = separator(numDelimiterString);
            System.out.println("결과 : " + addResult);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    public static int separator(String numDelimiterString) { //문자열에서 숫자 추출하여 더한 값 반환
        char delimiter = '\u0000';
        boolean custom = false;
        int addResult = 0;
        boolean prevIsNum = false;


        if(numDelimiterString.isEmpty()) { // 빈 문자열일때 0 반환
            return 0;
        }
        if(numDelimiterString.length() == 1) {
            if(Character.isDigit(numDelimiterString.charAt(0))) {
                return Character.getNumericValue(numDelimiterString.charAt(0));
            }else {
                throw new IllegalArgumentException("Illegal Argument");
            }
        }

        if(numDelimiterString.substring(0,2).equals("//") && numDelimiterString.substring(3,5).equals("\\n")) { // 커스텀 구분자인 경우
            delimiter = numDelimiterString.charAt(2);
            custom = true;
        }else {
            custom = false;
        }

        for(int i = 0; i <numDelimiterString.length(); i++) {
            if(custom && i > 4 && Character.isDigit(numDelimiterString.charAt(i)) == prevIsNum) {
                throw new IllegalArgumentException("Illegal Argument");
            }else if(custom && i > 4 && (prevIsNum && numDelimiterString.charAt(i) != delimiter)) {
                throw new IllegalArgumentException("Illegal Argument");
            }else if(!custom && Character.isDigit(numDelimiterString.charAt(i)) == prevIsNum) {
                throw new IllegalArgumentException("Illegal Argument");
            }else if(!custom && prevIsNum && (numDelimiterString.charAt(i) != ',' || numDelimiterString.charAt(i) != ':')) {
                throw new IllegalArgumentException("Illegal Argument");
            }else if(Character.getNumericValue(numDelimiterString.charAt(i)) <= 0) {
                throw new IllegalArgumentException("Illegal Argument");
            }else if(!Character.isDigit(numDelimiterString.charAt(i))) {
                continue;
            }else {
                addResult += Character.getNumericValue(numDelimiterString.charAt(i));
            }
        }

        return addResult;
    }
}