package calculator.service;

import calculator.model.Global;

public class Separator {

    private final Global global = Global.getInstance();

    public void separateString() {
        String input = global.getInput();
        String splitter = global.getSplitStr();
        global.setStrNums(input.split(splitter));
    }
}
