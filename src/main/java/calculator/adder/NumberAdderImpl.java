package calculator.adder;

import java.util.List;

public class NumberAdderImpl implements NumberAdder {

    @Override
    public NumberAdderResponse addNumberToken(NumberAdderRequest numberAdderRequest) {
        //  validate
        List<Token> tokens = numberAdderRequest.getTokens().stream()
                .map(Token::new)
                .toList();

        // add
        int result = tokens.stream()
                .mapToInt(Token::getValue)
                .sum();

        // parse response
        return new NumberAdderResponse(result);
    }
}
