package calculator;

public class AddNum {
    int add(String[] numList) {
        int answer = 0;
        for (String num : numList) {
            int addNum = Integer.parseInt(num);
            if (addNum < 0) {
                throw new IllegalArgumentException();
            }
            answer += addNum;
        }
        return answer;
    }
}
