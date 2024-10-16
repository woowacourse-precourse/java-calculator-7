package calculator.service.impl;

import calculator.entity.IndexQueue;
import calculator.entity.Num;
import calculator.entity.NumList;
import calculator.entity.Separator;
import calculator.entity.SeparatorSet;
import calculator.service.SeparatorService;

public class SeparatorServiceImpl implements SeparatorService {

    private static final int SEPARATOR_LENGTH = 5;
    private static final int SEPARATOR_POS = 2;

    @Override
    public NumList separateNum(String refinedInput, String regex) {

        String[] numStringArray = refinedInput.split(regex);

        NumList numList = new NumList();
        for (String numString : numStringArray) {
            numList.addNum(new Num(numString));
        }

        return numList;
    }

    @Override
    public SeparatorSet getCustomSeparators(String input) {

        SeparatorSet separatorSet = new SeparatorSet();
        for (int idx = 0; idx <= input.length() - SEPARATOR_LENGTH; idx++) {
            if (input.startsWith("//", idx) && input.startsWith("\\n", idx + 3)) {
                char sepChar = input.charAt(idx + 2);
                String sepString = String.valueOf(sepChar);

                separatorSet.addSeparator(new Separator(sepString));
            }
        }

        return separatorSet;
    }

    @Override
    public String refineString(String input, IndexQueue idxQueue) {
        // 커스텀 구분자의 앞뒤를 제거한 문자열을 만들어낸다.
        // 커스텀 구분자의 문자 자체는 남는다.
        StringBuilder sb = new StringBuilder();

        int idx = 0;

        while (idx < input.length()) {
            if (idxQueue.isIndexProcess(idx)) {
                char sep = input.charAt(idx + SEPARATOR_POS);
                sb.append(sep);
                idx += SEPARATOR_LENGTH;
                idxQueue.poll();
                continue;
            }

            sb.append(input.charAt(idx));
            idx++;
        }

        return sb.toString();
    }


    public IndexQueue getAllCustomSepIdx(String input) {
        // 커스텀 구분자로 시작하는 인덱스들을 모아둔다.
        IndexQueue idxQueue = new IndexQueue();

        for (int idx = 0; idx <= input.length() - SEPARATOR_LENGTH; idx++) {
            if (input.startsWith("//", idx) && input.startsWith("\\n", idx + 3)) {
                idxQueue.offer(idx);
            }
        }

        return idxQueue;
    }

}
