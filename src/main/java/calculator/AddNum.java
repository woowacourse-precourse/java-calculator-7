package calculator;

public class AddNum {
    int add(String[] numList) {
        int answer = 0;
        for (String num : numList) {
            try {
                int addNum = Integer.parseInt(num);
                if (addNum < 0) {
                    throw new IllegalArgumentException();
                }
                answer += addNum;
            } catch (Exception e) {
                throw new IllegalArgumentException();
            }
        }
        return answer;
    }
}
