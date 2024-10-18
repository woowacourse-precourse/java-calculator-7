package calculator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class StringSummationCalculator implements Calculator<BigInteger> {
    private final HashSet<Character> splitters;

    public StringSummationCalculator(){
        this.splitters = new HashSet<>();
        initDefaultSplitters();
    }

    private void initDefaultSplitters(){
        splitters.add(';');
        splitters.add(':');
    }

    public BigInteger calculate(String givenInput){
        BigInteger result;

        ArrayList<String> values = parse(givenInput);

        result = sum(values);
        return result;
    }


    private BigInteger sum(ArrayList<String> args){
        BigInteger result = BigInteger.ZERO;

        try{
            for (String value : args){
                int num = Integer.parseInt(value);
                result = result.add(BigInteger.valueOf(num));
            }

        }catch(NumberFormatException e){
            throw new IllegalArgumentException("올바른 정수 값이 입력되지 않았거나, 등록된 구분자가 아닙니다.");
        }

        return result;
    }

    private ArrayList<String> parse(String givenInput){
        StringSplitters stringSplitters = new StringSplitters();
        StringToken stringToken = new StringToken("//","\\\\n");
        stringSplitters.addSplittersByToken(stringToken,givenInput);

        String removedString = stringToken.removeTokenDeclaration(givenInput);
        StringTokenizer tokenizer = new StringTokenizer(removedString, stringSplitters.getDelim());
        ArrayList<String> parsedArgs = new ArrayList<>();

        while(tokenizer.hasMoreTokens()){
            String token = tokenizer.nextToken();
            parsedArgs.add(token);
        }

        return parsedArgs;
    }
}
