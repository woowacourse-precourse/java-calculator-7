package calculator.service.impl;

import calculator.entity.Index;
import calculator.entity.IndexQueue;
import calculator.entity.Input;
import calculator.entity.NumList;
import calculator.entity.RefinedInput;
import calculator.entity.RegexStr;
import calculator.entity.Separator;
import calculator.entity.SeparatorSet;
import calculator.service.SeparatorService;

public class SeparatorServiceImpl implements SeparatorService {


    @Override
    public NumList separateNum(RefinedInput refinedInput, RegexStr regexStr) {
        return refinedInput.toNumList(regexStr);
    }

    @Override
    public SeparatorSet getCustomSeparators(Input input) {

        SeparatorSet separatorSet = new SeparatorSet();

        Index idx = new Index(0);
        Index maxIdx = input.maxSepStringIdx();

        while (idx.isLessThanOrEqual(maxIdx)) {
            if (input.isCustomSep(idx)) {
                Index customSeparatorIdx = idx.customSeparatorIdx();
                String sep = input.oneLetter(customSeparatorIdx);
                separatorSet.addSeparator(new Separator(sep));
            }

            idx.increase();
        }

        return separatorSet;
    }

    @Override
    public RefinedInput refineInput(Input input, IndexQueue idxQueue) {
        // 커스텀 구분자의 앞뒤를 제거한 문자열을 만들어낸다.
        // 커스텀 구분자의 문자 자체는 남는다.

        StringBuilder sb = new StringBuilder();

        Index idx = new Index(0);
        Index maxIdx = input.maxIdx();

        while (idx.isLess(maxIdx)) {
            if (idxQueue.isIndexProcess(idx)) {
                Index customSeparatorIdx = idx.customSeparatorIdx();
                String customSeparator = input.oneLetter(customSeparatorIdx);
                sb.append(customSeparator);
                idx.plus(CUSTOM_SEPARATOR_LENGTH);
                idxQueue.poll();
                continue;
            }

            String oneLetter = input.oneLetter(idx);
            sb.append(oneLetter);

            idx.increase();
        }

        return new RefinedInput(sb.toString());
    }


    public IndexQueue getAllCustomSepIdx(Input input) {
        // 커스텀 구분자로 시작하는 인덱스들을 모아둔다.
        IndexQueue idxQueue = new IndexQueue();

        Index idx = new Index(0);
        Index maxIdx = input.maxSepStringIdx();

        while (idx.isLessThanOrEqual(maxIdx)) {
            if (input.isCustomSep(idx)) {
                idxQueue.offer(idx);
            }

            idx.increase();
        }

        return idxQueue;
    }

}
