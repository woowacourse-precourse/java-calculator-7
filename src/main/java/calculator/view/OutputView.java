package calculator.view;

import calculator.model.dto.ResultDto;

public class OutputView {
    public OutputView() {
    }

    public static void outputResult(ResultDto resultDto) {
        int result = resultDto.getResult();
        String resultMessage = ViewMessage.RESULT.getMessage()+result;
        System.out.println(resultMessage);
    }
}