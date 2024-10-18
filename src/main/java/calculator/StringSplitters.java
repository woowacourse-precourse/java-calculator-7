package calculator;

import java.util.HashSet;
import java.util.List;

public class StringSplitters {
    private final HashSet<Character> splitters;

    public StringSplitters() {
        this.splitters = new HashSet<>();
        initDefaultSplitters();
    }

    private void initDefaultSplitters() {
        splitters.add(',');
        splitters.add(':');
    }

    public void addSplitter(char splitter) {
        splitters.add(splitter);
    }

    public void addSplittersAll(List<Character> splitterList) {
        splitters.addAll(splitterList);
    }

    public String getDelim() {
        StringBuilder delim = new StringBuilder();
        splitters.forEach(delim::append);

        return delim.toString();
    }

    public void addSplittersByToken(StringToken token, String givenInput){
        token.regexMatch(givenInput).forEach(matchResult -> {
            String tokenValue = matchResult.group(1);

            if(tokenValue.length() == 1){
                addSplitter(tokenValue.charAt(0));
            }else{
                throw new IllegalArgumentException("커스텀 구분자는 하나의 문자로 구성되어야 합니다. 주어진 값: "+tokenValue);
            }
        });
    }
}