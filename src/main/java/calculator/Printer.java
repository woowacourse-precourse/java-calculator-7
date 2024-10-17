package calculator;

/**
 * 결과를 출력하는 클래스
 */
public class Printer {
    /**
     * 들어오는 int param 을 "결과: " prefix 와 함께 출력한다. 출력은 한줄, end of line 은 '\n' 이다.
     *
     * @param result 결과
     */
    public static void printResult(int result) {
        System.out.println("결과 : " + result);
    }
}
