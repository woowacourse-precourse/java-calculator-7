package calculator.model;

import java.util.StringTokenizer;

public class Calculator {
    public int calcResult(String str){
        int calcResult = 0;

        // 10.16 Ver 1
        // First It doesn't matter about custom delimiter
        // Just Only , and :
        StringTokenizer st = new StringTokenizer(str,",:");
        while (st.hasMoreTokens()){
            calcResult += Integer.parseInt(st.nextToken());
        }

        return calcResult;
    }
}
