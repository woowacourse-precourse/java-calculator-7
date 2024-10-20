package calculator.parsing;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;

public interface ParsingNumberService {
    public void parsingNumber(String s, HashSet<Character> delimiters);
    public ArrayList<BigInteger> getNumbers();
}