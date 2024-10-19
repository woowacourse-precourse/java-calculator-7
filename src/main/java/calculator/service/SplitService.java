package calculator.service;

import calculator.domain.TextInfo;

public class SplitService {
    public boolean checkCustomSplit(TextInfo textInfo) {
        return textInfo.text.getText().startsWith("//") && textInfo.customSplitIndex != -1;
    }

    public void addSplit(TextInfo textInfo) {
        String customSplit = textInfo.text.getText().substring(2, textInfo.customSplitIndex);
        textInfo.split.add(customSplit);
    }

}
