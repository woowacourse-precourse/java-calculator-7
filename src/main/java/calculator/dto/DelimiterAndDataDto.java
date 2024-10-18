package calculator.dto;

public record DelimiterAndDataDto(
        String delimiter,
        String rawData
) {
    // TODO: validation 처리 해주기
    public static DelimiterAndDataDto of(final String delimiter, final String rawData) {
        if(delimiter.isBlank() || rawData.isBlank()){
            throw new IllegalArgumentException("데이터와 구분자가 없습니다.");
        }
        return new DelimiterAndDataDto(delimiter, rawData);
    }
}
