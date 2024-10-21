package calculator;

import java.util.ArrayList;
import java.util.List;

public class TokenParser {
    private TokenParser() {
        //인스턴스 생성 안됨
    }
    
    static public NumberTokens parseTokens(String[] tokens, boolean decimalAllowed) {
        List<NumberToken> numberTokens = new ArrayList<>();
        for (String tokenStr : tokens) {
            NumberToken token = new NumberToken(tokenStr, decimalAllowed);
            numberTokens.add(token);
        }
        return new NumberTokens(numberTokens);
    }
}
