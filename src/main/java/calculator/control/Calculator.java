package calculator.control;

import calculator.global.SentenceUtil;
import calculator.model.Sentence;
import calculator.model.Separator;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class Calculator {
    public void start() {
        OutputView.printNotice();
        String input = InputView.readInput();

        Sentence sentence = new Sentence(SentenceUtil.extractSentence(input));
        Separator separator = new Separator();
        separator.extractCustomCharacter(input);
        List<Integer> numbers = sentence.extractNumbers(separator.getCharacters());
        OutputView.printResult(addNumbers(numbers));
    }
    public int addNumbers(List<Integer> numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }
}
