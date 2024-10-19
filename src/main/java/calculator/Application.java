package calculator;


import java.util.LinkedList;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = readLine();

        if(!checkEmpty(inputString)){
            return;
        }

        char separator;
        String[] numArray = null;
        if(inputString.charAt(0) == '/'){
            separator = checkCustom(inputString);

            if(separator == '0'){
                throw new IllegalArgumentException("IllegalArgumentException 발생");
            }else{
                inputString = inputString.substring(5);
                numArray = inputString.split(",|:|" + Pattern.quote(Character.toString(separator)));
            }
        }else{
            numArray = inputString.split(",|:");
        }

        LinkedList<Integer> numbers = checkNumber(numArray);
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println("결과 : " + sum);
    }

    static boolean checkEmpty(String string){
        try {
            if(string == null || string.trim().equals("")){
                throw new IllegalArgumentException("IllegalArgumentException 발생");
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    static char checkCustom(String string){ // 구분자 표시 : //(구분자)\n

        if(string.charAt(1) == '/' && string.charAt(3) == '\\' && string.charAt(4) == 'n'){
            if((string.charAt(2) >= 33 && string.charAt(2) <= 47) || (string.charAt(2) >= 58 && string.charAt(2) <= 64) || (string.charAt(2) >= 91 && string.charAt(2) <= 95) || (string.charAt(2) >= 123 && string.charAt(2) <= 126))
                return string.charAt(2);
        }

        return '0';
    }

    static LinkedList<Integer> checkNumber(String[] numArray){
        LinkedList<Integer> numbers = new LinkedList<>();
        for (String s : numArray) {
            try{
                int tmp = Integer.parseInt(s);
                numbers.add(tmp);
            }catch (NumberFormatException e){
                throw new IllegalArgumentException("문자열 정수로 변환 불가");
            }
        }

        return numbers;
    }
}
