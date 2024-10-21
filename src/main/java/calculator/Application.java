package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String numDelimiterString = Console.readLine();

        int addResult = separator(numDelimiterString);
        System.out.println("결과 : " + addResult);
        return;
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
                throw new IllegalArgumentException("IllegalArgumentException");
            }
        }

        if(numDelimiterString.substring(0,2).equals("//") && numDelimiterString.substring(3,5).equals("\\n")) { // 커스텀 구분자인 경우
            delimiter = numDelimiterString.charAt(2);
            custom = true;
        }else {
            custom = false;
        }

        for(int i = 0; i <numDelimiterString.length(); i++) {
            if(custom && i > 4 && Character.isDigit(numDelimiterString.charAt(i)) == prevIsNum) { //커스텀 구분자일때 숫자나 구분자가 연속으로 들어온 경우 (음수가 들어온 경우 포함)
                throw new IllegalArgumentException("IllegalArgumentException");
            }else if(custom && i > 4 && prevIsNum && numDelimiterString.charAt(i) != delimiter) { //커스텀 구분자일때 구분자로 다른 구분자가 들어온 경우
                throw new IllegalArgumentException("IllegalArgumentException");
            }else if(!custom && Character.isDigit(numDelimiterString.charAt(i)) == prevIsNum) { //일반 구분자일때 숫자나 구분자가 연속으로 들어온 경우 (음수가 들어온 경우 포함)
                throw new IllegalArgumentException("IllegalArgumentException");
            }else if(!custom && prevIsNum && numDelimiterString.charAt(i) != ',' && numDelimiterString.charAt(i) != ':') { //일반 구분자일때 쉼표와 콜론 이외의 구분자가 들어온 경우
                throw new IllegalArgumentException("IllegalArgumentException");
            }else if(!Character.isDigit(numDelimiterString.charAt(i))) {
                prevIsNum = false;
                continue;
            }else {
                addResult += Character.getNumericValue(numDelimiterString.charAt(i));
                prevIsNum = true;
            }
        }

        return addResult;
    }
}