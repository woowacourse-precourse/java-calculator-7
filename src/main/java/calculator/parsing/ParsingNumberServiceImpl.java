package calculator.parsing;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;

public class ParsingNumberServiceImpl implements ParsingNumberService {
    private  ArrayList<BigInteger> numbers = new ArrayList<BigInteger>();
    @Override
    public ArrayList<BigInteger> getNumbers() {
        return numbers;
    }

    @Override
    public void parsingNumber(String s, HashSet<Character> delimiters) {
        StringBuilder number = new StringBuilder();
        int delimiterSize=delimiters.size();

        for (int i=0;i<s.length();i++) {
            char ch=s.charAt(i);
            if (delimiterSize>2 && i<=4){
                continue;
            }
            else if (ch<=57 && ch>=48){
                number.append(ch);
            }
            else  if (delimiters.contains(ch)){
                if (!number.isEmpty()) {

                    if (i == s.length() - 1) {
                        throw new IllegalArgumentException("유효하지 않은 문자열입니다.");
                    }

                    numbers.add(new BigInteger(number.toString()));
                    number.setLength(0);

                } else {
                    throw new IllegalArgumentException("유효하지 않은 문자열입니다.");
                }
            }

            else throw new IllegalArgumentException("유효하지 않은 문자열입니다.");
        }
        if (!number.isEmpty()){
            numbers.add(new BigInteger((number.toString())));
        }
        else numbers.add(new BigInteger("0"));


        return;
    }
}
