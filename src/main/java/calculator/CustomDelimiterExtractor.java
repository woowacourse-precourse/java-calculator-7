package calculator;

public class CustomDelimiterExtractor implements DelimiterExtractor {

    @Override
    public DelimiterResult extractDelimiter(String input) {
        if (input.startsWith("//")) {
            StringBuilder delimiter = new StringBuilder();
            boolean foundNewLine = false;
            int startIndex = -1;

            for (int i = 2; i < input.length(); i++) {
                char currentChar = input.charAt(i);

                // \n을 발견한 경우 구분자 추출 완료
                if (currentChar == '\\' && i + 1 < input.length() && input.charAt(i + 1) == 'n') {
                    foundNewLine = true;
                    startIndex = i + 2;
                    break;
                }

                // 정규식 특수 문자를 이스케이프 처리하여 저장
                delimiter.append("\\Q").append(currentChar).append("\\E").append("|");

            }
            // 기본 구분자 ,와 :를 추가 (정규식에서 기본 구분자이므로 이스케이프 없이 추가)
            String finalDelimiter = delimiter.toString() + ",|:";

            if (!foundNewLine || delimiter.isEmpty()) {
                throw new IllegalArgumentException("잘못된 형식입니다. '//'와 '\\n' 사이에 커스텀 구분자가 위치해야 합니다.");
            }

            return new DelimiterResult(finalDelimiter, startIndex);
        }
        return new DelimiterResult(",|:", 0);  // 기본 구분자
    }
}
