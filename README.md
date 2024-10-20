# java-calculator-precourse
1. 기본 구분자 계산기 구현
2. 커스텀 구분자 계산기 기능 구현
3. 케이스 구분
- 입력된 문자열이 공백일 때 '결과 : 0 '을 출력
- 공백이 아닐 경우, '//'로 시작하는 문자열과 숫자로 시작하는 문자열 두 가지 경우로 나뉨
- 1) '//'로 시작하는 문자열 (조건: 문자열 내 음수 여부)
- 2) 숫자로 시작하는 문자열 (조건: 문자열 내 음수 여부)
- 3) 그 외(지정한 구분자 혹은 // 외의 특수문자)
*에러는 IllegalArgumentException을 활용