package calculator;

import java.util.ArrayList;
import java.util.List;

public class Tokenization {
    String str;
    List<Integer> numberlist;
    List<String> characterfordivide;
    boolean isOkay = true;

    public Tokenization(String str) {
        this.str = str;
        numberlist = new ArrayList<Integer>();
        characterfordivide = new ArrayList<String>();
        characterfordivide.add(",");
        characterfordivide.add(":");
    }

    public List<Integer> tokenize() {
        for(int i = 0; i < str.length(); i++) {
            if(i == 0) {
                if(str.charAt(i) == '\"') {
                    continue;
                }
            }
        }

        return numberlist;
    }
}
