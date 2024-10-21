package calculator;

public class NumberPick {
    public static int[] pickNumbers(String[] numbers) {
        int[] pickedNumbers = new int[numbers.length];
        int count = 0;

        for (String numberStr : numbers) {
            String trimmedNumber = numberStr.trim(); // 공백 제거
            if (!trimmedNumber.isEmpty()) {
                try {
                    int number = Integer.parseInt(trimmedNumber); // 문자열을 정수로 변환
                    if (number < 0) { // 음수 체크
                        throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + number);
                    }
                    pickedNumbers[count++] = number;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("잘못된 숫자가 입력되었습니다: " + trimmedNumber);
                }
            }
        }

        // 실제 숫자 개수만큼 새로운 배열로 반환
        int[] result = new int[count];
        System.arraycopy(pickedNumbers, 0, result, 0, count);
        return result;
    }
}
