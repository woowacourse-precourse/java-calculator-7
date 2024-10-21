# java-calculator-precourse

### 입력한 문자열에서 숫자를 추출하여 더하는 계산기

### Overall what program does:
	parse input and return sum of numbers

	input : a string

	delimiter : ',' or ':' or cutsom_delimiter

	custom_delimiter_input : a string starts with "//[custom_delimiter]\n"

	valid input: a string of [digit]*, [delimiter]*, or [cursom_delimiter_input]
		e.g. "" => 0, "1,2,3", "1,2:3", "//;\n1;2;3" 
	invalid input:
		e.g. "a", "a:b", ...

	output : valid input ? sum value : throw IllegalArgumentException

**unclear about description**

	0. 문자열이 여러 개면? -> invalid input으로 판단
	1. 문자열 앞부분-> 앞부분 != 맨 앞. 맨 앞이 아니어도 되는지 명확하지 않음 ->  맨 앞이라고 판단
	2. nested, 즉 "////[]\n\n"가 주어질 경우 -> valid input으로 판단

#### 0. identify delimiter
	- identify delimiter from given input

	if input starts with "//", find the last appeareance of "\n" (if exists) and return delimiter bc nested "//\n" are valid
								if "\n" does not exist, throw exception
								if "//\n"(no char provided for delimiter) throw exception
	if input doesn't starts with "//", return ",:"
	
	input : given input
	output : delimiter

#### 1. identify valid input

	if delimiter is default,
		checks if program input is only consists of delimiter and (digits)
	if delimiter is custom
		checks if program input is consists of 1 prefix, custom delimiter, 1 postfix, (digits)
	if digit is not found -> valid
		**edge case : "" -> 0**

	intput : program input, delimiter
	output : valid input? Ture : False

#### 2. parse input 
	-store all numbers from input and return a list of numbers
	
	input : a valid input string (delimiter + digits)
	output : a list of numbers

#### 3. calculator -> sum all given numbers and return the sum value

	input : a list of numbers
	output : sum value
