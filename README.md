# 프리코스 1주차 미션 - 계산기

![Generic badge](https://img.shields.io/badge/precourse-week1-green.svg)
![Generic badge](https://img.shields.io/badge/version-1.0.1-brightgreen.svg)

---
# 목차
- [시작하기](#시작하기)
- [문제](#문제)
  - [문제 출제](#문제-출제)
  - [문제 풀기](#문제-풀기)
- [기능 목록](#기능-목록)
- [패키지](#패키지)


## 시작하기  
```git
git clone -b as --single-branch https://github.com/pug9483/java-calculator-7.git
```

---

## 문제

### 문제 출제
- 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

### 문제 풀기
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
  - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
  - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

--- 
## 기능 목록

- [x] `쉼표(,)`, `콜론(:)`을 구분자로 가지는 문자열을 구분자를 기준으로 분리하여 합을 구한다.
- [ ] 커스텀 구분자는 `//` 와 `\n`사이에 위치하는 문자다. 커스텀 구분자를 사용하여 문자열을 분리하고 합을 구한다.
- [ ] `camp.nextstep.edu.missionutils`에서 제공하는 Console API를 사용하여 구현해야 한다. `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

--- 
## 패키지