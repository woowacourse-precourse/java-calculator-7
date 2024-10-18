package calculator;

public class Application {

    public static int add_arrays(int[] nums){

        int result = 0;
        for (int num : nums) {
            result += num;
        }

        return result;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // add_arrays test
        int[] test_nums = {1,2,3,4,5};

        System.out.println(add_arrays(test_nums));

    }
}
