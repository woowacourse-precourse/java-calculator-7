package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class InputText {

    private String input;
    private List<String> separatorList = new ArrayList<>(List.of(",",":"));

    public InputText (String input){
        this.input = input.trim();
    }
}
