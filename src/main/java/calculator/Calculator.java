package calculator;

import java.util.regex.Pattern;

public class Calculator {
    private static final Pattern numberReg = Pattern.compile("^[0-9]+$");


    public int calc(String factors) throws IllegalArgumentException{
        Factor factor = new Factor();

        if(factor == null){
            return 0;
        }

        int result = 0;
        for(String num : factor.parseNum(factors)){
            chkMinus(num);
            result = result + Integer.parseInt(num);
        }
        return result;
    }


    private void chkMinus(String factor){
        if(factor.contains("-")){
            throw new IllegalArgumentException("no minus");
        }
        if(!(numberReg.matcher(factor).find())){
            System.out.println("factor: " + factor);
            throw new IllegalArgumentException("not number");
        }
    }
}
