package calculator;

public class Calculation {
    public static int stringCalculation(InputData input){
        switch(input.getInputType()) {
            case InputType.EMPTY:
                return 0;
            case InputType.GENERAL:
                sliceGeneralString(input);
                break;
            case InputType.CUSTOM:
                sliceCustomString(input);
                break;
        }
        return -1;
    }

    public static void sliceGeneralString(InputData input){


    }

    public static void sliceCustomString(InputData input){


    }

}
