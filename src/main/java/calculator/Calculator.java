package calculator;

public class Calculator {
    private String inputData;

    //
    public Calculator(String inputData){
        if(inputData.equals("") || inputData == null){
            this.inputData="0";
        } else{
            this.inputData=inputData;
        }
    }



}
