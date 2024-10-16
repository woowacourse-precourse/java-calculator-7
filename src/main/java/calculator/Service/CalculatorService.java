package calculator.Service;

import calculator.View.OutputView;

public class CalculatorService {
    private static String Separator = ",|:";
    public static void add(String input){
        if(input==null || input.isEmpty()){
            OutputView.Result(0);
            return;
        }
        if(input.startsWith("//")) Custom_Separator(input);
        String[] numbers=input.split(Separator);
        int sum=sum(numbers);
        OutputView.Result(sum);

    }

    private static String Custom_Separator(String input){
        int separatorIndex = input.indexOf("\n");
        Separator=input.substring(2,separatorIndex);
        return input.substring(separatorIndex+1);
    }

    private static int sum(String[] input){
        int sum=0;
        for(int i=0; i<input.length; i++){
            sum+=Integer.parseInt(input[i]);
        }
        return sum;
    }

}
