package calculator.service;

public class SumCalculator {

    // 오로지 값을 더함
    public int sum(String[] nums){
//        System.out.println(Arrays.toString(nums));
//        System.out.println(nums[0].getClass().getName()); // java.lang.String
        int result = 0;

        for (String num : nums) {
            try {
                result += Integer.parseInt(num);
            } catch (NumberFormatException ex) {
//                ex.printStackTrace();
//                outputView.outputErrorMessage(e.getMessage());
                throw new IllegalArgumentException(ex.getMessage(), ex); // 에러 => 종료
            }

        }

        return result;
    }
}
