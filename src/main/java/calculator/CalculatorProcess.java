package calculator;

import processor.DelimiterProcess;
import processor.NumberProcess;
import processor.ManageProcess;

import java.util.Arrays;


public class CalculatorProcess {
    private int answer;

    public void mainProcess(){
        DelimiterProcess delim = new DelimiterProcess();
        NumberProcess number = new NumberProcess();
        ManageProcess manage = new ManageProcess();

        manage.startCalculate();
        delim.calculate();
        number.calculate();
        sumCalculate();
        manage.printAnswer();

    }

    public void sumCalculate(){
        NumberProcess number = new NumberProcess();
        String[] sumArr = number.getNumberArray();
        for(String s : sumArr){
            try{
                int a = Integer.parseInt(s.trim());
                if(a>0){
                    answer += a;
                }else{
                    throw new IllegalArgumentException();
                }
            }catch(NumberFormatException e){
                throw new IllegalArgumentException("invalid number:" + Arrays.toString(sumArr));
            }
        }
    }

    public int getAnswer(){
        return answer;
    }
}
