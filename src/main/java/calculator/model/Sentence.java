package calculator.model;

import calculator.global.SentenceUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Sentence {
    String text;

    public Sentence(String text) {
        this.text = text;
    }

    public List<Integer> extractNumbers(List<String> separators) {
        Stack<String> currentTexts = new Stack<>();
        currentTexts.add(text);
        for (String separator : separators) {
            currentTexts = currentTexts.stream()
                    .flatMap(currentText -> Arrays.stream(currentText.split(separator)))
                    .collect(Collectors.toCollection(Stack::new));
        }
        SentenceUtil.validNumbers(currentTexts);
        return convertNumbersStringToInt(currentTexts);
    }

    public List<Integer> convertNumbersStringToInt(List<String> numbers) {
        return numbers.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
