package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class InputText {

    private final String text;
    private final List<String> separatorList = new ArrayList<>(List.of(",",":"));

    public InputText (String input){
        text = divideTextAndSeparateList(input.trim());
    }

    public String divideTextAndSeparateList(String input){
        if (input.startsWith("//")){
            int lastIndex = input.lastIndexOf("\\n");
            if (lastIndex != -1) {
                String separator = input.substring(2, lastIndex);
                separatorList.add(separator);
                return input.substring(lastIndex + 2);
            }
        }
        return input;
    }

    public String getText() {
        return text;
    }

    public List<String> getSeparatorList() {
        return separatorList;
    }

}
