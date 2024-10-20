package calculator.service;

import java.util.HashMap;
import java.util.Map;

public class CalculateStringNumberService {

    public Integer calculateStringNumber(String text) {
        Map<String, String> patternAndText = customDelimiter(text);

        String pattern = patternAndText.get("regex");
        String processedText = patternAndText.get("text");

        String[] delimitedTextList = processedText.split(pattern);

        // Exception : 입력된 값이 없는경우
        if (delimitedTextList.length == 0) {
            System.out.println("[Error] 입력된 값이 없습니다.");
            throw new IllegalArgumentException();
        }

        int totalSum = 0;
        for (String delimitedText : delimitedTextList) {
            try {
                int extractNum = Integer.parseInt(delimitedText);
                // Exception : 음수가 입력이 되어있는 경우
                if (extractNum < 0) {
                    System.out.println("[Error] 양수를 입력해주세요.");
                    throw new IllegalArgumentException();
                }
                totalSum += extractNum;

            } catch (NumberFormatException e) {
                // Exception : 구분자 사이에 입력된 값이 없는 경우
                if (delimitedText.isEmpty()) {
                    System.out.println("[Error] 빈 값이 입력되었습니다.");
                    throw new IllegalArgumentException();
                }

                // Exception : 구분자 사이에 입력된 값의 숫자 형식이 잘못 된 경우
                System.out.println("[Error] 입력된 숫자 형식이 잘못 되었습니다.");
                throw new IllegalArgumentException();
            }
        }

        return totalSum;
    }

    private Map<String, String> customDelimiter(String inputText) {
        // 반환을 위한 Hash Map
        Map<String, String> response = new HashMap<>();
        String defaultPattern = ",|:";

        if (inputText.startsWith("//") && inputText.contains("\\n")) {
            inputText = inputText.replace("//", "");
            int endPatternIndex = inputText.indexOf("\\n");
            String customDelimiter = inputText.substring(0, endPatternIndex);

            // 커스텀 구분자가 숫자로 들어왔을 경우.
            for (int i = 0; i < customDelimiter.length(); i++) {
                // Exception : 숫자가 포함된 구분자를 사용하려는 경우
                if (Character.isDigit(customDelimiter.charAt(i))) {
                    System.out.println("[Error] 숫자가 포함된 구분자는 사용할 수 없습니다.");
                    throw new IllegalArgumentException();
                }
            }

            String pattern = defaultPattern + "|" + inputText.substring(0, endPatternIndex);
            inputText = inputText.substring(endPatternIndex + 2);

            response.put("regex", pattern);
            response.put("text", inputText);
            // Exception : custom 구분자의 형식이 잘못 된 경우.
        } else if ((inputText.startsWith("//") && !inputText.contains("\\n")) ||
                (!inputText.startsWith("//") && inputText.contains("\\n"))) {
            System.out.println("[Error] 커스텀 구분자를 사용하기 위해서 '//;\\n'과 같은 형식으로 입력해주세요.");
            throw new IllegalArgumentException();
        } else {
            response.put("regex", defaultPattern);
            response.put("text", inputText);
        }

        return response;
    }

}
