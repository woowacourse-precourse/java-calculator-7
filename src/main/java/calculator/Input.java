package calculator;

import camp.nextstep.edu.missionutils.Console;


public class Input {
    static String input;
    static String[] tokens;
    public String inputCal(){
        input = Console.readLine();
        isEmpty();
        return input;
    }
    public String[] inputSplit(){
        String delimiter = "[,:]";
        if (input.startsWith("//")) {

            int delimiterIndex = input.indexOf("\\n");
            System.out.println(delimiterIndex);
            delimiter = (input.substring(2,delimiterIndex));
            System.out.println(delimiter);
            input = input.substring(delimiterIndex+2);
        }
        tokens = input.split(delimiter);
        isValidNumber();
        return tokens;
    }
    public int sumToken(){
        int sum = 0;
        for(String token : tokens){
            sum += stringToInt(token);
        }
        return sum;
    }

    private void isEmpty(){
        if(input == null || input.isEmpty()){
            throw new IllegalArgumentException("입력이 비었습니다.");
        }
    }
    private void isValidNumber(){
        try {
            for (String token : tokens) {
                stringToInt(token);
            }
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("토큰이 숫자가 아닙니다");
        }

        //다른 특수문자 사용
    }
    private int stringToInt(String str){
        return Integer.parseInt(str);
    }


}
