# java-calculator-precourse

### 기능 명세

1. 계산기 구현하기

- [x] 사용자 입력 받기
    - [x] 빈문자열 입력시 결과 0으로 처리하기
- [x] 커스텀 구분자 설정 여부 확인
- [x] 구분자를 기준으로 숫자 분리
- [x] 분리된 숫자의 합 계산
- [x] 계산 결과 출력

2. 사용자의 잘못된 입력 예외처리하기

- [x] 음수 입력
- [x] 커스텀 구분자, 쉼표, 콜론, 숫자 외의 문자 입력
- [x] 잘못된 커스텀 구분자 입력 (ex. 문자가 아닌 숫자 입력)
- [x] 계산 범위 초과시

### 요구사항에 기재되지 않은 내용 중 스스로 판단한 기능

1. 사용할 수 없는 커스텀 구분자

- [x] 숫자는 실제 수계산에 방해가 될 수 있기에 커스텀 구분자로 등록하지 못하도록 제한한다.