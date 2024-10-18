# java-calculator-precourse



## 구현할 기능 목록

##### OutputView
- [ ] “문자열을 입력해주세요.” 메세지 콘솔 출력
- [ ] 결과 값 콘솔 출력

##### DelimiterExtractor
- [ ] 커스텀 구분자 추출 기능
    - [ ] 문자열 전체를 탐색하면서 커스텀 구분자에 해당하는 부분이 있으면 Set에 추가
    - [ ] 만약 커스텀 구분자의 형식이 올바르지 않은 경우(하나의 문자가 아닌 경우) `IllegalArgumentException` 예외 반환

##### DelimiterTokenizer
- [ ] 문자 토큰 분리 기능 (커스텀 구분자 포함)
    - [ ] 문자열 전체를 탐색하면서 커스텀 구분자를 기준으로 토큰 분리, List<Integer> 형태로 반환

##### ResultCalculator
- [ ] 숫자 합 결과 계산
    - [ ] 리스트를 전체 순회하면서 숫자의 합을 반환

##### InputView
- [ ] 문자열 입력 기능

