package calculator.Service;

public class CalculatorService {
    private static String Separator = ",|:";
    public static int add(String input){
        if(input==null || input.isEmpty()){
            return 0;
        }
        if(input.startsWith("//")) Custom_Separator(input);
        String[] numbers=input.split(Separator);

        return 0;

    }

    private static String Custom_Separator(String input){
        int separatorIndex = input.indexOf("\n");
        Separator=input.substring(2,separatorIndex);
        return input.substring(separatorIndex+1);
    }

}
