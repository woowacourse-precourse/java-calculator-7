package calculator;

import java.util.StringTokenizer;

public class Function {

    // 싱글턴 객체 생성
    private static Function instance = new Function();
    private Function() {}
    public static Function getInstance() {
        return instance;
    }

    //기능 1 : 문자열을 쉼표(,) 또는 콜론(:)이라는 구분자를 기준으로 분리하여 합을 반환하기
    public int isSplit(String str) {

        int sum = 0;
        StringTokenizer st = new StringTokenizer(str, ",:");

        while (st.hasMoreTokens()) {
            sum += Integer.parseInt(st.nextToken());
        }

        return sum;
    }
}
