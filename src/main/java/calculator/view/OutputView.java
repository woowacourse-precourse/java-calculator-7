package calculator.view;

import calculator.view.enumerate.Phrase;

public class OutputView {

    public void print(Phrase phrase, int result) {
        System.out.printf(phrase.getSentence(), result);
    }

    public void print(Phrase phrase) {
        System.out.printf(phrase.getSentence());
    }
}
