package calculator;

import java.util.ArrayList;
import java.util.List;

public class Delimiter {
    private ArrayList<String> delimiters = new ArrayList<>(List.of(",", ":"));

    public String setDelimiters(String str){
        if (str.startsWith("//")) {
            int delimiterIndex = str.indexOf("\\n");
            if (delimiterIndex != -1) {
                String customDelimiter = str.substring(2, delimiterIndex);
                for (char c : customDelimiter.toCharArray()) {
                    if (Character.isDigit(c)) {
                        throw new IllegalArgumentException();
                    }
                }
                str = str.substring(delimiterIndex + 2);
                if (str.isEmpty()) {
                    System.out.print("결과 : 0");
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
        return str;
    }

    public String makeSplitDelimiters(){
        String splitDelimiters = String.join("|", delimiters);
        return splitDelimiters;
    }

    public ArrayList<String> getDelimiters() {
        return delimiters;
    }
}
