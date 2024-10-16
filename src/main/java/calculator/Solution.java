package calculator;

public class Solution {

    public void solve() {
        Input input = new Input();

        Extraction extraction = new Extraction(input.nextLine());
        Calculation calculation = new Calculation();

        int res = calculation.calculate(extraction.extract());

        System.out.println("결과 : " + res);
    }
}
