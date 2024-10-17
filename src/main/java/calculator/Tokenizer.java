package calculator;

import java.util.*;

public class Tokenizer {
    Numberlist numberlist;
    Divider divider;
    IsError isError;
    List<Integer> numbers;

    public Tokenizer() {
        numberlist = new Numberlist();
        divider = new Divider();
        isError = new IsError();
        numbers = new ArrayList<>();
    }

    public List<Integer> tokenize(String input) {
        numbers.clear();
        
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(Character.isDigit(c)) {
                numberlist.pushtemp(c);
            }
            else {
                numberlist.push();
                divider.judge(c);
            }
        }
        numberlist.push();

        isError.checkError(divider.getProblemMatcher());

        return numbers;
    }
}
