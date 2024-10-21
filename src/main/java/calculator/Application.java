package calculator;

import calculator.business.StringCalculator;

public class Application {

    public static void main(String[] args) {
        try {
            StringCalculator stringCalculator = new StringCalculator();
            stringCalculator.run();
        } catch (Error e) {
            // 비정상 종료 전 최소한의 안내를 제공
            System.out.println("자체적으로 처리할 수 없는 심각한 오류가 발생했습니다. 어플리케이션을 종료합니다.");
            throw e;
        }
    }

}