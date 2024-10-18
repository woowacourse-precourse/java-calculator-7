package calculator.Service;

import calculator.View.InputView;
import calculator.View.OutputView;

public class CalculatorService {
    private static String Separator = ",|:";
    private static final int CUSTOM_SEPARATOR_START_INDEX=2;
    private static final int CUSTOM_SEPARATOR_END_INDEX = 3;
    private static final int CUSTOM_INPUT_INDEX=5;


    public static String Input_String_to_add(){
        return InputView.ask_sum_string();
    }

    public static void add(String input){
        if(input==null || input.isEmpty()){
            OutputView.Result(0);
            return;
        }
        if(input.startsWith("//")&&input.contains("\\n")) input=Custom_Separator(input);
        String[] numbers = input.split(Separator);
        System.out.println(numbers);
        validateNumbers(numbers);
        int sum=sum(numbers);
        OutputView.Result(sum);

    }
    private static String Custom_Separator(String input){
        Separator=input.substring(CUSTOM_SEPARATOR_START_INDEX, CUSTOM_SEPARATOR_END_INDEX);
        return input.substring(CUSTOM_INPUT_INDEX);
    }

    private static void validateNumbers(String[] numbers){
        for(String number:numbers){
            if(!isNumberic(number)){
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
            }
            if(Integer.parseInt(number)<0){
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
        }
    }

    private static boolean isNumberic(String number){
        try{
            Integer.parseInt(number);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }
    private static int sum(String[] input){
        int sum=0;
        for(int i=0; i<input.length; i++){
            sum+=Integer.parseInt(input[i]);
        }
        return sum;
    }

}
