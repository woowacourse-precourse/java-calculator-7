package calculator.domain;

import java.util.Vector;


public class TextInfo {
    public Text text = new Text();
    public Vector<String> split = new Vector<>();
    public Vector<Integer> convertedNumbers = new Vector<>();
    public int result = 0;
    public int customSplitIndex;

    public String[] numericStringsArray;

    public TextInfo(String inputString) {
        text.setText(inputString);
        split.add(",");
        split.add(":");
        customSplitIndex = text.getText().indexOf("\\n");
    }

}
