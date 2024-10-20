package calculator.util;

import calculator.dto.response.CalculateResponse;

public class OutputHandler {
    public static void consoleOutput(CalculateResponse result){
        System.out.println("결과 : " + result.result());
    }

}
