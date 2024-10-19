# java-calculator-precourse

## 입력받아 특정 규칙에 따라 덧셈을 해주는 프로그램

### 규칙은 크게 2가지가 있다.
1. Custom split
- //()\n 괄호 안에 custom split을 기준으로 숫자를 나눠 더해준다.
2. Normal split
- , or : 를 split 의 기준으로 삼아 나눈 후 더한다.

## Class

### Application : 메인이 되는 class 로 입력할 클래스를 호출하고 결과를 출력한다.
### Calculator : 사용자로부터 수식을 입력받고 Splitter 로 부터 나온 결과를 더한다.
### Splitter : 입력받은 문자열을 규칙에 맞게 나눠서 number 의 리스트를 반환한다.