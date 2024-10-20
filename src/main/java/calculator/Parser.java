package calculator;

import java.math.BigInteger;
import java.util.ArrayList;

public class Parser {
    public static ArrayList<BigInteger> inputParse(String input, Separator separator){

        ArrayList<BigInteger> tokens = new ArrayList<>();
        StringBuilder tmp = new StringBuilder();
        for(char c : input.toCharArray()){
            if(separator.isSeparator(c)){
                tokens.add(new BigInteger(tmp.toString()));
                tmp.setLength(0);
            } else{
                tmp.append(c);
            }
        }

        if(!tmp.isEmpty()){
            tokens.add(new BigInteger(tmp.toString()));
        }

        return tokens;
    }
}
