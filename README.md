# 구현할 기능 목록

- [ ] 문자열을 입력 받는 기능
    - [ ] 사용자가 콘솔에서 문자열을 입력할 수 있도록 구현


- [ ] 입력값을 검증하는 기능 (Validator)
    - [ ] 쉼표(,) 또는 콜론(:)을 구분자로 사용하여 문자열이 올바르게 입력되었는지 검증
    - [ ] 커스텀 구분자("//[구분자]\n[문자열]" 형식)을 지원하며, 올바른 형식인지 검증


- [ ] 숫자를 추출하고 계산하는 기능 (Calculator)
    - [ ] 쉼표 또는 콜론을 구분자로 분리된 숫자들을 추출
    - [ ] 커스텀 구분자를 지원하여 문자열에서 숫자들을 추출
    - [ ] 추출된 숫자들을 더하여 결과 값을 반환
    - [ ] 입력된 문자열이 빈 문자열("")일 경우 0을 반환


- [ ] 반환된 값을 출력하는 기능
    - [ ] 계산된 결과를 "결과 : {계산 결과}" 형식으로 출력


- [ ] 예외 처리 기능 (예외 발생시 IllegalArgumentException을 발생 및 적절한 오류 메시지 출력)
    - [ ] 입력값에 음수가 있을 경우
    - [ ] 입력값이 null일 경우
    - [ ] 입력값이 숫자로 끝나지 않는 경우
    - [ ] 커스텀 구분자를 지정하지 않았는데 쉼표, 콜론 외의 잘못된 문자가 포함된 경우
    - [ ] 커스텀 구분자가 숫자이거나 여러 개의 문자가 있을 경우