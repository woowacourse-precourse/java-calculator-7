package calculator.service;

import calculator.domain.TextInfo;
import calculator.utils.Validation;
import java.util.Vector;
import java.util.regex.Pattern;

public class SplitService {
    Validation validation = new Validation();

    public boolean checkCustomSplit(TextInfo textInfo) {
        return textInfo.text.getText().startsWith("//") && textInfo.customSplitIndex != -1;
    }

    public void addSplit(TextInfo textInfo) {
        String customSplit = textInfo.text.getText().substring(2, textInfo.customSplitIndex);
        validation.isNullCustomSplit(customSplit);
        textInfo.split.add(customSplit);
    }

    public String mergeSplits(Vector<String> split) {
        StringBuilder regex = new StringBuilder();
        for (int i = 0; i < split.size(); i++) {
            regex.append(Pattern.quote(split.get(i)));
            if (i < split.size() - 1) {
                regex.append("|");
            }
        }
        return regex.toString();
    }

    public void splitText(TextInfo textInfo, String splits) {
        textInfo.numericStringsArray = textInfo.text.getText().split(splits);
    }

}
