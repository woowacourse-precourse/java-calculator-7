package calculator;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    Numberlist numberlist;
    Divider divider;
    List<Integer> numbers;

    public Tokenizer() {
        numberlist = new Numberlist();
        divider = new Divider();
        numbers = new ArrayList<>();
    }

    public List<Integer> tokenize(String input) {
        numbers.clear();
        
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(Character.isDigit(c)) {
                numberlist.push(c);
            }
            else {
                divider.judge(c);
            }
        }

        return numbers;
    }
}
