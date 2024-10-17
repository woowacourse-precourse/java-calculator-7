package calculator.Model;


public class StringProcessor {
    private final String input;

    public StringProcessor(String input) {
        this.input = input;
    }

    public int[] getAdditionNumbers() {
        if (input.isEmpty()) {
            return new int[0];
        }
//        String separator = getSeparator();
//        String parsedInput = parseString(separator);
//        return convertToIntArray(parsedInput);
        return new int[0];
    }

    public String getSeparator() {
        // 구분자 정의하기
        if (hasCustomSeparator()) {
            return getCustomSeparator();
        }
        return ",|:";
    }

    private boolean hasCustomSeparator() {
        return input.contains("//") || input.contains("\n");
    }

    private String getCustomSeparator() {
        // 커스텀 구분자 추출하기
        int separatorStartIndex = getSeparatorStartIndex();
        int separatorEndIndex = getSeparatorEndIndex();

        ValidateCustomSeparator(separatorStartIndex, separatorEndIndex);

        return (String) input.subSequence(separatorStartIndex, separatorEndIndex + 1);
    }

    private int getSeparatorStartIndex() {
        return input.indexOf("//") + 2;
    }

    private int getSeparatorEndIndex() {
        return input.indexOf("\n") - 1;
    }

    private void ValidateCustomSeparator(int startIndex, int endIndex) {
        if (startIndex != 2 || endIndex <= 1) {
            throw new IllegalArgumentException("커스텀 구분자가 올바르게 정의되지 않았습니다.");
        }
    }

//    private String parseString(String seperator) {
//        // 계산할 숫자 리스트 생성하기
//        //  - 구분자를 기준으로 입력받은 문자열 분리해서 리스트 생성하기
//
//    }
//
//    private int[] convertToIntArray(String parsedInput) {
//        // String 리스트를 Int 형으로 변경
//        //    - 빈 문자의 경우, 0으로 처리
//        //    - 음수 값이 있을 경우, IllegalArgumentException
//        //    - 숫자가 아닌 값이 있을 경우, IllegalArgumentException
//    }

}
