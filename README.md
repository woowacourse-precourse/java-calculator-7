# java-calculator-precourse
## 목표

- Format에 맞춰 String을 입력하면 숫자를 더해서 출력하는 계산기를 구현한다.
## Input Format

### 1. 기본 입력
   , 또는 : 을 구분자로 숫자를 나누어 입력한다.

| input | output                   | 비고             |
|-------|--------------------------|----------------|
| 1,2:3 | 결과 : 6                   |                |
| 1,2:x | IllegalArgumentException | 숫자가 아닌 입력      |
| 1,,1  | IllegalArgumentException | 구분자 연속 입력      |
| ,1,1  | IllegalArgumentException | 구분자 전후로 입력이 부족 |
| 1.1   | IllegalArgumentException | 등록되지 않은 구분자    |
| 1 1   | IllegalArgumentException | 등록되지 않은 구분자    |

### 2. 커스텀 구분자 입력
"//{ 구분자 }\n" + {기본 입력} 의 형태로 입력한다.
{구분자}의 문자들과 기본 구분자 (, :)을 이용해 숫자를 나누어 입력한다.
이 때, {구분자} 안에 중복되는 경우를 허용한다.

| input        | output                   | 비고                     |
|--------------|--------------------------|------------------------|
| //;\n1;2:3,4 | 결과 : 10                  |                        |
| ///\n1/2:3   | 결과 : 6                   |                        |
| //\n1,2:3    | 결과 : 6                   | 빈 커스텀 구분자 가능           |
| //;;;\n1;2:3 | 결과 : 6                   | 커스텀 구분자 중복 가능          |
| //1/2:3      | IllegalArgumentException | \n 가 제대로 선언되지 않음       |
| /'\n1/2:3    | IllegalArgumentException | // 가 제대로 선언되지 않음       |
| //:\n 1:2:3  | IllegalArgumentException | 구분자 전후로 입력이 부족         |
| 3,//:\n2:2   | IllegalArgumentException | 커스텀 구분자 선언이 맨 앞에 있지 않음 |
    


## 기능 구현 순서
1. 기본 구분자를 바탕으로 input을 나누어 String[] operands에 넣는다.
2. operands의 항목들을 int로 바꾸고 더하여 출력한다.
3. 커스텀 구분자도 parsing하여 구분자로 사용한다.
