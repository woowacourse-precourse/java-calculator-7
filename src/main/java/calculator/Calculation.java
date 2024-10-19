package calculator;

public class Calculation {
    public static int stringCalculation(InputData input){
        switch(input.getInputType()) {
            case InputType.EMPTY:
                return 0;
            case InputType.GENERAL:
                calculationGeneralString(input.getUserInput());
                break;
            case InputType.CUSTOM:
                calculationCustomString(input.getUserInput());
                break;
        }
        return -1;
    }

    public static int calculationGeneralString(String input){
        int sum = 0;
        for(char c : input.toCharArray()){
            if(Character.isDigit(c)){
                sum += Integer.parseInt(Character.toString(c));
            }
        }
        return sum;
    }

    public static void sliceCustomString(String input){


    }

}
