package calculator.converter;

public class NumberConverterImpl implements NumberConverter {

    @Override
    public int[] convert(String[] stringArr) {
        int[] numberArr = new int[stringArr.length];

        for (int i = 0; i < stringArr.length; i++) {
            try {
                if (stringArr[i].isEmpty()) {
                    numberArr[i] = 0;
                    continue;
                }
                int number = Integer.parseInt(stringArr[i]);
                if (number <= 0) {
                    throw new IllegalArgumentException("양수만 입력할 수 있습니다: " + stringArr[i]);
                }
                numberArr[i] = number;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 숫자 형식입니다: " + stringArr[i]);
            }
        }
        return numberArr;
    }
}
