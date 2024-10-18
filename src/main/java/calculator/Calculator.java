package calculator;

public class Calculator {
    public int add() {
        return 0;  // 인자가 없는 경우 0 반환
    }
    // Split numbers using the default delimiters and calculate
    public int add (String input){
        String delimiter = ",|:";
        //공백 문자 처리
        if(input.isEmpty()){
            return 0;
        }
        // 커스텀 구분자 처리
        if(input.startsWith("//")){
            input = input.replace("\\n","\n");
            int delimiterIndex = input.indexOf("\n");
            delimiter = input.substring(2, delimiterIndex);
            input = input.substring(delimiterIndex+1);

        }

        String[] numbers = input.split(delimiter);

        return calculate(numbers);
    }


    private int calculate(String[] numbers){
        int sum =0;
        for(String number : numbers){
            int num = Integer.parseInt(number);
            sum +=num;
        }
        return sum;
    }
}
