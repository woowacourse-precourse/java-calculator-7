package calculator.service;

import calculator.model.Separator;

public class SumService {
    Separator separator;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private SumService() {
        separator = Separator.getInstance();
    }

    private static class SingletonHelper {
        private static final SumService INSTANCE = new SumService();
    }

    static public SumService getInstance() {
        return SingletonHelper.INSTANCE;
    }


    public int calculate(String targetText) throws IllegalArgumentException {
        if (!targetText.isEmpty() && targetText.length() % 2 == 0) {
            throw new IllegalArgumentException("문자열의 구조가 잘못되었습니다.");
        }

        int sumNumber = 0;

        for (int index = 0; index < targetText.length(); index++) {
            char targetTextCharacter = targetText.charAt(index);
            checkTextCharacter(targetTextCharacter, index);

            if (index % 2 == 0) {
                sumNumber += targetTextCharacter - '0';
            }

        }

        return sumNumber;
    }

    private void checkTextCharacter(char targetTextCharacter, int index) {

        if (index % 2 == 0) {
            int targetNumber = targetTextCharacter - '0';
            if (targetNumber < MIN_NUMBER || targetNumber > MAX_NUMBER) {
                throw new IllegalArgumentException("문자열의 숫자 부분을 잘못 작성하셨습니다.");
            }
        }

        if (index % 2 == 1) {
            if (!isSeparatorAtOddIndex(targetTextCharacter)) {
                throw new IllegalArgumentException("문자열의 구분자 부분을 잘못 작성하셨습니다.");
            }
        }
    }

    private boolean isSeparatorAtOddIndex(char targetTextCharacter) {
        for (char targetSeparator : separator.getSeparator()) {
            if (targetTextCharacter == targetSeparator) {
                return true;
            }
        }

        return false;
    }
}
