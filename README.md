# java-calculator-precourse
## 기능 목록

입력
- class Input

구분자 처리
- class Delimiter
  - 기본 구분자와 커스텀 구분자를 구별하여 식별
  - 구분자를 기준으로 입력 받은 문자열을 split, 숫자만 뽑아서 저장

계산 결과 도출
- class Caculator
  - 뽑아낸 숫자 중, 음수가 있을 경우 어플리케이션 종료
  - 음수가 없을 경우 숫자 합산
  - 결과 출력
