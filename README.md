# java-calculator-precourse

Activity
1) 사용자에게 입력을 받는다 
2) 커스텀 구분자가 있는지 확인한다.
3) 구분자를 통해 숫자를 구분하고 숫자들의 합을 출력한다.

Step
1-1) 입력이 ""일 경우 0 출력

2-1) 커스텀 구분자가 있을 경우 저장
2-2) 커스텀 구분자가 더 있을 경우 계속 추가 (기존 구분자 ",",":")
2-3) 없을 경우에는 넘어감

3-1) 구분자들을 통해 숫자들의 합 출력

예외처리
1. 구분자 사이에 숫자가 아닌 문자가 들어와있을 경우
2. 구분자 사이에 숫장가 양수가 아닌 0 또는 음수 일 경우