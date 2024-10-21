package calculator;

import java.util.regex.Pattern;

public class StringCalculator {

    public String[] splitString(String input, String delimiter) {
        return input.split(delimiter);
    }

    public int stringToInt(String number){
        if(number.isEmpty()) return 0;
        try{
            return Integer.parseInt(number);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자가 아닌 문자가 있습니다.");
        }
    }

    public long addString(String[] numbers){
        long sum=0;
        for(String number:numbers){
            if(number.isEmpty()) continue;
            int num = stringToInt(number);
//            System.out.println(number);
            if(num <= 0)
                throw new IllegalArgumentException("양수만 입력할 수 있습니다.");
            sum+=num;
        }
        return sum;
    }

    public boolean isValidCustomDelimiter(String input){
        if(input.charAt(3) == '\\' && input.charAt(4) == 'n'){
            if(input.charAt(2)>='0'&&input.charAt(2)<='9')
                throw new IllegalArgumentException("숫자는 커스텀 구분자가 될 수 없습니다.");
        } else{
            throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
        }
        return true;
    }

    public boolean isSpecialChar(char delimiter) {
        String specialChars = ".^$*+?()[]{}\\|/";
        return specialChars.indexOf(delimiter) != -1;
    }

    public String findCustomDelimiter(String input){
        String customDelimiter = "";

        if(isValidCustomDelimiter(input)) {
            if(isSpecialChar(input.charAt(2)))
                customDelimiter += "\\";
            customDelimiter += input.charAt(2);
        }
        return customDelimiter;
    }



    public long stringCalculate(String input){
        if(input.isEmpty())
            return 0;

        String delimiter = ",|:";

        if(input.startsWith("//")){ // 커스텀 구분자 형식으로 시작하면
            if(input.charAt(3) == '\\' && input.charAt(4) == 'n'){
                delimiter += findCustomDelimiter(input);
                input = input.substring(5);
            } else{
                throw new IllegalArgumentException("커스텀 구분자 형식이 유효하지 않습니다.");
            }
        }
        String[] numbers = splitString(input, delimiter);
        long sum = addString(numbers);

        return sum;
    }

}
