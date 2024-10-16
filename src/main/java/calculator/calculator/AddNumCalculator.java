package calculator.calculator;

import calculator.helper.InputHelper;
import calculator.util.StringUtility;
import calculator.view.InputView;
import calculator.view.OutputView;

import javax.management.RuntimeErrorException;

public class AddNumCalculator implements CalculatorInterface {
    private String splitter = "";
    private boolean isCustomSplitter = false;


    @Override
    public void calculator() {
        try{
            String input = InputView.inputAddStr();
            setSplitterFromInput(input);
            int result = calAdd(input);
            OutputView.outputResult(result);
        }catch (RuntimeException runtimeException){
            OutputView.invalidInputError();
            throw new IllegalArgumentException();
        }

    }

    private void setSplitterFromInput(String input) {
        String splitter = InputHelper.BASE_SPLITTER;
        String customSplitter = StringUtility.getCustomSplitter(input);
        boolean isCustomSplitterExists = !customSplitter.isEmpty();
        if(isCustomSplitterExists) splitter = customSplitter;
        this.isCustomSplitter = isCustomSplitterExists;
        setSplitter(splitter);
    }

    private int calAdd(String input) {
        int result = 0;
        String numPartStr = StringUtility.getNumPart(input, isCustomSplitter);
        String[] numArr = numPartStr.split(this.splitter);
        for(String num : numArr){
            if(num.isEmpty()) continue;
            result += Integer.parseInt(num);
        }
        return result;
    }

    @Override
    public void setSplitter(String newSplitter) {
        this.splitter = newSplitter;
    }

    @Override
    public String getSplitter() {
        return splitter;
    }
}
