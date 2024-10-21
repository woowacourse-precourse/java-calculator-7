package calculator.model;

import calculator.validation.InputValidator;

import java.util.StringTokenizer;

public class Calculator {

    public long calculate(StringTokenizer st){
        long ans = 0L;
        while (st.hasMoreTokens()){
            String now = st.nextToken();
            try {
                long num = Long.parseLong(now);
                InputValidator.checkPositiveNumber(num);
                ans+=num;
            } catch (Exception e){
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
        return ans;
    }

}
