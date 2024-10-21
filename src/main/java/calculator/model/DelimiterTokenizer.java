package calculator.model;

import java.util.Arrays;

/**
 * 구분자 tokenizer model
 */
public class DelimiterTokenizer {

    private String customDelimiter;
    private String totalDelimiter;

    public DelimiterTokenizer() {
        this.customDelimiter = null;
        this.totalDelimiter = ",|:";
    }

    //== 비즈니스 로직 ==//

    /**
     * split을 위한 구분자 리스트 생성
     */
    public String combineDelimiters(String customDelimiter) {
        if (customDelimiter == null) {
            return totalDelimiter;
        }

        if (customDelimiter.equals("|")) {
            this.customDelimiter = "\\|";  //문자열 이스케이프 처리
        } else {
            this.customDelimiter = customDelimiter;
        }

        this.totalDelimiter = this.customDelimiter + "|" + this.totalDelimiter;

        return totalDelimiter;
    }

    /**
     * 문자열에서 숫자 추출
     *
     * @return 문자열에서 추출한 숫자 리스트
     */
    public long[] tokenizeString(String inputString) {

        String[] numbersInString = inputString.split(this.totalDelimiter);

        return Arrays.stream(numbersInString)
                .filter(s -> !s.isEmpty())
                .mapToLong(Long::parseLong)
                .toArray();
    }

}
