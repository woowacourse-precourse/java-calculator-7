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
            getSeparator();

        }
    }

    // 커스텀 구분자 처리
    private void getSeparator(){
        // "//"로 시작하면 커스텀, 그렇지 않으면 기본 구분자
        if(inputData.startsWith("//")){
            isDefault=false;
            String[] parts = inputData.split("\\\\n", 2);
            if (parts.length < 2) {
                throw new IllegalArgumentException("Invalid input format: missing number part.");
            }
            separator = parts[0].substring(2); // "//" 이후의 구분자만 추출
            inputData = parts[1]; // 구분자 뒤의 숫자들
        }  else {
            isDefault = true;
            inputData = inputData.replaceAll(":",",");
            separator = ",";
        }
    }




}
