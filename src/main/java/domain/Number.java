package domain;

public class Number {
    int[] numbers;
    public Number() {}
    public Number(int[] numbers){
        validateNumber(numbers);
        this.numbers = numbers;
    }

    public int[] getNumbers() {
        return numbers;
    }

    private void validateNumber(int[] numbers) {
        for(int number : numbers){
            if(number <=0){
                throw new IllegalArgumentException("모든 숫자는 양수여야 합니다.");
            }
        }
    }
}
