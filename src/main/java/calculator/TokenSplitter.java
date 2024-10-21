package calculator;

import java.util.ArrayList;
import java.util.List;

public class TokenSplitter {

    private TokenSplitter() {
        // 인스턴스 생성 불가

    }

    static public String[] split(String input, Delimiters delimiters) {
        List<String> tokens = new ArrayList<>();
        StringBuilder token = new StringBuilder();
        
        int currentIndex = 0;
        while (currentIndex < input.length()) {
            Delimiter matchedDelimiter = delimiters.matchDelimiter(input, currentIndex);
            if (matchedDelimiter != null) {
                tokens.add(token.toString());
                token.setLength(0);
                currentIndex += matchedDelimiter.length();
            }
            if (matchedDelimiter == null) {
                token.append(input.charAt(currentIndex));
                currentIndex++;
            }
        }
        tokens.add(token.toString());
        return tokens.toArray(new String[0]);
    }
    
}
