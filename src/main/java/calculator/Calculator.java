package calculator;

public class Calculator {
    private String delimiter = ",|:";

    String parseNumber(String input){
        if(input.startsWith("//")){
            int start = input.indexOf("//") + 2;
            int end = input.indexOf("\\n");
            if(end == -1){
                throw new IllegalArgumentException("잘못된 입력 형식입니다.");
            }
            delimiter = input.substring(start,end);
            input = input.substring(end+2);
        }
        return input;
    }
    int getResult(String input){
        input = parseNumber(input);
        int result = 0;
        String[] numbers = input.split(delimiter);
        for(String number : numbers){
            try{
                int num = Integer.parseInt(number);
                if(num < 0){
                    throw new IllegalArgumentException("잘못된 입력 형식입니다.");
                }
                result += num;
            }catch (NumberFormatException e){
                throw new IllegalArgumentException("잘못된 입력 형식입니다.");
            }
        }
        return result;
    }
}
