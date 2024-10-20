package calculator;

import java.util.ArrayList;

public class Calculator {
    int ans = 0;
    public int calculateSum(ArrayList<Integer> numArr){
        // 마지막 숫자 처리
        // 결과 계산
        for (int num : numArr) {
            ans += num;
        }
        return ans;
    }
}
