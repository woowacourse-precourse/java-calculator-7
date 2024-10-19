package calculator.service;

import calculator.domain.TextInfo;

public class TextService {
    public void changeText(TextInfo textInfo) {
        String newText = textInfo.text.getText().substring(textInfo.customSplitIndex + 2);
        textInfo.text.setText(newText);

    }
}
