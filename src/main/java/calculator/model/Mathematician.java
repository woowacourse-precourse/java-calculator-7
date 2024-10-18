package calculator.model;

public class Mathematician {
    public int sum(int[] correctNums) {
        int total = 0;
        for (int correctNum : correctNums) {
            total += correctNum;
        }
        return total;
    }
}
