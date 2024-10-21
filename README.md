# java-calculator-precourse

> 기본구분자, 커스텀구분자
> > 기본구분자는 , : 로 구분 <br/>
> > 커스텀구분자는 //;\n 으로 사용 (;로 구분)


> 문제풀이에 대한 문제제기
> > 1. 구분자(,:와 //;\n)로 어떻게 구분함? <br/>
> > - StringTokenizer(), split() >> 둘 다 안 써보기도 했고, 어떤걸 사용해도 괜찮아보여 StringTokenizer()사용 <br/>
> > <br/>
> > 2. 커스텀 구분자를 사용하는 문제
> > - \n 을 사용하기 위해선 이스케이프 코드를 활용. ( \n >> \\n 으로 변경) <br/>
> > <br/>
> > 3. 예외처리
> > - 어디를 예외처리할 지 확인 >> 입력문자열 부분
> > - IllegalArgumentException() 확인 >> RuntimeException 계열 Unchecked 예외, throw