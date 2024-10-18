package calculator.feature;

public class Adder {

    int[] nums;

    public Adder(int[] nums) {
        this.nums = nums;
    }

    public int getSum() {

        int answer = 0;
        for (int num : nums) {
            answer += num;
        }
        return answer;
    }
}
