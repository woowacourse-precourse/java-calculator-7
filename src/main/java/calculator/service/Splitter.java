package calculator.service;

import calculator.model.Global;

public class Splitter {

    private static final String CUSTOM_SPLIT_START = "//";
    private static final String CUSTOM_SPLIT_END = "\\n";
    private static final String BASIC_SPLITTER = ",|;";
    private final Global global;

    public Splitter() {
        global = Global.getInstance();
        global.setSplitStr(BASIC_SPLITTER);
    }

    // 커스텀 구분자 판정
    public void findSplitter() {
        String input = global.getInput();
        if (input.startsWith(CUSTOM_SPLIT_START)) {
            String splitter = input.substring(CUSTOM_SPLIT_START.length(),
                    input.indexOf(CUSTOM_SPLIT_END));
            global.setSplitStr(splitter);
            removeCustomSplitterFromInput();
        }
    }

    // 대상 문자열 내 커스텀 구분자 판정 파트 제거
    private void removeCustomSplitterFromInput() {
        String input = global.getInput();
        global.setInput(input.substring(input.indexOf(CUSTOM_SPLIT_END) + CUSTOM_SPLIT_END.length()));
    }
}
