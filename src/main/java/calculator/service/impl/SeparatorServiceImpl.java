package calculator.service.impl;

import calculator.entity.Num;
import calculator.entity.Separator;
import calculator.service.SeparatorService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class SeparatorServiceImpl implements SeparatorService {

    private static final int SEPARATOR_LENGTH = 5;

    @Override
    public List<Num> separateNum(String refinedInput, String separatorString) {

        String[] numStringArray = refinedInput.split(separatorString);

        List<Num> numList = new ArrayList<>();
        for (String numString : numStringArray) {
            numList.add(new Num(numString));
        }

        return numList;
    }

    @Override
    public Set<Separator> getCustomSeparators(String input) {

        Set<Separator> separatorSet = new HashSet<>();

        for (int idx = 0; idx <= input.length() - SEPARATOR_LENGTH; idx++) {
            if (input.startsWith("//", idx) && input.startsWith("\\n", idx + 3)) {
                separatorSet.add(new Separator(String.valueOf(input.charAt(idx + 2))));
            }
        }

        return separatorSet;
    }

    @Override
    public String refineString(String input, Queue<Integer> idxQueue) {
        // 커스텀 구분자의 앞뒤를 제거한 문자열을 만들어낸다.
        // 커스텀 구분자의 문자 자체는 남는다.
        StringBuilder sb = new StringBuilder();

        int idx = 0;

        while (idx < input.length()) {
            // 큐가 비어있거나 현재 인덱스가 구분자 위치가 아닐 때
            if (idxQueue.isEmpty() || idx != idxQueue.peek()) {
                sb.append(input.charAt(idx));
                idx++;
                continue;
            }
            // 구분자 위치일 때 처리
            sb.append(input.charAt(idx + 2));
            idx += SEPARATOR_LENGTH;
            idxQueue.poll(); // 큐에서 값을 제거

        }

        return sb.toString();
    }


    public Queue<Integer> getAllCustomSepIdx(String input) {
        // 커스텀 구분자로 시작하는 인덱스들을 모아둔다.
        Queue<Integer> idxQueue = new PriorityQueue<>();

        for (int idx = 0; idx <= input.length() - SEPARATOR_LENGTH; idx++) {
            if (input.startsWith("//", idx) && input.startsWith("\\n", idx + 3)) {
                idxQueue.offer(idx + 2);
            }
        }

        return idxQueue;
    }

}
