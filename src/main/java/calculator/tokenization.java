package calculator;

import java.util.ArrayList;
import java.util.List;

public class tokenization {
    String str;
    List<Integer> numberlist;
    List<String> characterfordivide;
    boolean isOkay = true;

    public tokenization(String str) {
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
