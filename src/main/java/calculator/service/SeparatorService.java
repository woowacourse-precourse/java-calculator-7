package calculator.service;

import calculator.entity.IndexQueue;
import calculator.entity.Input;
import calculator.entity.NumList;
import calculator.entity.RefinedInput;
import calculator.entity.RegexStr;
import calculator.entity.SeparatorSet;

public interface SeparatorService {

    /**
     * 커스텀 구분자에 값을 탐색해 Set 자료구조로 반환
     *
     * @param input 입력값
     * @return 커스텀 구현체만 있는 {@code SeparatorSet} 객체
     */

    SeparatorSet getCustomSeparators(Input input);

    /**
     * 커스텀 구분자로 인식되는 문자열의 첫번째 인덱스를 큐에 삽입하여 반환
     *
     * @param input 원본 입력값
     * @return 인덱스 값이 들어간 큐 {@code IndexQueue}
     */

    IndexQueue getAllCustomSepIdx(Input input);

    /**
     * 제공된 인덱스 큐를 기반으로 커스텀 구분자의 구분값을 정제하여 구분자와 양수로 정제
     *
     * @param input    원본 입력값
     * @param idxQueue 커스텀 구분자의 시작 인덱스를 포함하는 큐
     * @return 구분자와 양수로만 정제된 {@code RefinedInput} 객체
     */

    RefinedInput refineInput(Input input, IndexQueue idxQueue);

    /**
     * 정규표현식을 사용해 양수들을 분리하여 리스트로 반환
     *
     * @param refinedInput 양수와 구분자만 있는 정제된 입력값
     * @param regexStr     구분자에 대해 처리하는 정규표현식
     * @return 양수 리스트 {@code NumList} 객체 반환
     */

    NumList separateNum(RefinedInput refinedInput, RegexStr regexStr);

}
