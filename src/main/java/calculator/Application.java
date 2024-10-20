package calculator;

public class Application {
    public static void main(String[] args) {
        String input = GetInput.input_String();

        // 구분자 추출
        String delimiter = ExtractDelimiter.extract_delimiter(input);

        // 문자열 전처리
        String refine_string = SplitInput.refine(input);

        // 문자열 분리
        String[] nums = SplitInput.split(refine_string, delimiter);

        System.out.println("결과 : " + AddingNum.sum(nums));
    }
}