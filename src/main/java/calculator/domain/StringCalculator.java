package calculator.domain;

public class StringCalculator {
    private final DelimiterExtraction delimiterExtraction = new DelimiterExtraction();
    private final ConvertingNum convertingNum = new ConvertingNum();
    private final SumCalculator sumCalculator = new SumCalculator();
    
    public int calculate(String input){
        if(input == null || input.isEmpty()){
            return 0;
        }
        // 문자열에서 구분자 추출
        String[] strs = delimiterExtraction.Extraction(input);

        // 문자열을 숫자로 변환
        int[] numbers = convertingNum.convertNums(strs);
        
        // 합 계산
        return sumCalculator.sum(numbers);
    }
}
