package calculator.view;

public class OutputView {
    /**
     * 정수 배열의 요소들은 전부 더한 값을 반환
     */
    public int sumElements(int[] array)
    {
        int result = 0;

        for (int number : array)
        {
            result += number;
        }

        return result;
    }
}
