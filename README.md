# java-calculator-precourse
<hr>

# 기능 구현 목록
## 초기 문자열 입력
- [X] 사용자에게 입력 받는다
- [X] 올바른 입력인지 확인한다
  - [X] 문자열이 비어있거나 null 이면 true 반환하여 판별

## 문자열 처리
- [X] 더하기 메서드를 구현하고 메서드 내부에서 모든 로직 처리
  - [X] 커스텀 구분자가 존재한다
    - [X] 커스텀 구분자를 추출
    - [X] 기존 구분자에 추출한 구분자를 추가
    - [X] 커스텀 구분자외에 순수 숫자파트 추출
  
  - [X] 입력값에서 구분자를 제외한 숫자파트를 추출

## 결과 출력
- [X] 추출한 문자열 숫자를 정수형 숫자로 변환 
- [X] 해당 숫자가 요구사항에 적합한 지 판별 
- [X] 결과 출력

## 예외 처리
- [ ] 기본 구분자도 아니고 커스텀 구분자로 추가하지 않은 문자일 경우
- [ ] 커스텀 구분자 기호가 맨 앞에 오지 않을 경우
- [ ] 양수 이외의 값일 경우