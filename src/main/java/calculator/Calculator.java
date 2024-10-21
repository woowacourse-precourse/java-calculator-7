package calculator;
import java.util.Arrays;

public class Calculator {
    private String inputData;
    private String separator;
    private boolean isDefault;

    // 숫자 입력받았을 때 IllegalArgumentException까지 예외 처리
    public Calculator(String inputData){
        if(inputData.equals("") || inputData == null){
            this.inputData="0";
            return;
        } else if(inputData.startsWith("-")){
            throw new IllegalArgumentException();
        }else{
            this.inputData=inputData;
//            getSeparator();

        }
    }



}
