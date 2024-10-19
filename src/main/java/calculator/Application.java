package calculator;

import calculator.domain.TextInfo;
import calculator.io.Input;
import calculator.io.Output;
import calculator.service.NumberService;
import calculator.service.SplitService;
import calculator.service.TextService;

public class Application {
    public static void main(String[] args) {

        Input input = new Input();
        String userInput = input.inputText();

        TextInfo textInfo = new TextInfo(userInput);

        SplitService splitService = new SplitService();
        TextService textService = new TextService();

        if (splitService.checkCustomSplit(textInfo)) {
            splitService.addSplit(textInfo);
            textService.changeText(textInfo);
        }
        NumberService numberService = new NumberService();

        String finalSplitString = splitService.mergeSplits(textInfo.split);
        splitService.splitText(textInfo, finalSplitString);

        numberService.setNumbers(textInfo);
        numberService.addNumbers(textInfo);

        Output output = new Output();
        output.outputResult(textInfo);
    }

}
