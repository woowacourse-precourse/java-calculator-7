package calculator;

public class Parser {
    private String separator;

    public int[] parseInput(String input){
        if(input.isEmpty()) return new int[]{0};

        String validatedInput = validation(input);
        String[] strArray = validatedInput.split(separator);
        return stringArrayToIntArray(strArray);
    }

    private int[] stringArrayToIntArray(String[] strArray){
        int[] numbers = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            try {
                // 문자열을 숫자로 변환
                numbers[i] = Integer.parseInt(strArray[i]);
            } catch (NumberFormatException e) {
                // 숫자가 아닌 경우 처리
                throw new IllegalArgumentException();
            }
        }
        return numbers;
    }

    private String validation(String input){
        String filteredInput = input.replaceAll("\\d", ""); // 숫자 제거
        if (!filteredInput.matches("[,:]*")) {
            int startIdx = input.indexOf("//");
            int endIdx = input.indexOf("\n");
            if(startIdx == -1 || endIdx == -1){
                throw new IllegalArgumentException();
            }
            separator = input.substring(startIdx +2, endIdx);
            return input.substring(endIdx +1);
        } else {
            separator = ",|:";
            return input;
        }
    }
}
