package calculator.io;

import calculator.domain.TextInfo;

public class Output {

    public void outputResult(TextInfo textInfo) {
        System.out.printf("결과 : %d", textInfo.result);
    }


}
