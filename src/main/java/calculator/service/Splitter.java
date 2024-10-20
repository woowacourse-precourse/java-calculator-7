package calculator.service;

import calculator.model.Global;
import java.util.List;

public class Splitter {

    private static final String CUSTOM_SPLIT_START = "//";
    private static final String CUSTOM_SPLIT_END = "\\n";
    private static final String BASIC_SPLITTER = ",|;";
    private static final List<String> META_CHARACTER = List.of(
            "^", "$", "[", "]", "{",
            "}", "(", ")", ".", "*",
            "+", "?", "|", "/", "\\"
    );

    private final Global global;

    public Splitter() {
        global = Global.getInstance();
        global.setSplitStr(BASIC_SPLITTER);
    }

    // 커스텀 구분자 판정
    public void findSplitter() {
        String input = global.getInput();
        if (input.startsWith(CUSTOM_SPLIT_START)) {
            String splitter = changeMetaChar(input);
            global.setSplitStr(splitter);
            removeCustomSplitterFromInput();
        }
    }

    private String changeMetaChar(String input) {
        StringBuilder splitter = new StringBuilder(global.getSplitStr() + "|");
        String[] customSplitter = input.substring(CUSTOM_SPLIT_START.length(), input.indexOf(CUSTOM_SPLIT_END))
                .split("");
        for (String i : customSplitter) {
            if (META_CHARACTER.stream().anyMatch(str -> str.equals(i))) {
                splitter.append("\\");
            }
            splitter.append(i);
        }
        return splitter.toString();
    }

    // 대상 문자열 내 커스텀 구분자 판정 파트 제거
    private void removeCustomSplitterFromInput() {
        String input = global.getInput();
        global.setInput(input.substring(input.indexOf(CUSTOM_SPLIT_END) + CUSTOM_SPLIT_END.length()));
    }
}
