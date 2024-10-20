# Java String Calculator

This Java application is a simple string calculator that allows users to input strings containing numbers separated by commas or colons, and it calculates their sum. Additionally, it supports custom delimiters specified at the start of the string.

## Features

- **Default Delimiters:** By default, the calculator can process numbers separated by commas (,) or colons (:).
- **Custom Delimiters:** Users can specify a custom single-character delimiter at the beginning of the string.
- **Exception Handling:** The calculator handles various exceptions such as invalid number formats, use of negative numbers, or incorrect delimiter specifications.

## How to Use

1. **Compile and Run the Application:**
   Ensure you have Java installed on your machine and compile the `Application.java` file using:
   ```bash
   javac Application.java
   Then, run the compiled Java class:
   java Application
2. **Input the String:**
   For default delimiters, input a string like 1,2:3.
   For a custom delimiter, format the input like //;\\n1;2;3.
3. **View the Result:**
   After inputting the string, the calculator will display the sum of the numbers.

## Error Handling

If the input string is empty or null, the sum will be 0.
If the input string starts with // but is followed by an incorrect custom delimiter format, an error message will appear indicating the format is wrong.
If the string contains non-numeric characters or negative numbers, an appropriate error message will display, indicating the issue.

## Closing the Scanner

The Scanner class is used for taking input from the user, and it is properly closed after reading the input to avoid resource leaks.

## Example
Here is an example of using the calculator with a custom delimiter:

**Input:**

//;\\n1;2;3

**Output:**

결과 : 6

This calculator simplifies processing and summing numbers from a formatted string input, handling errors gracefully and allowing for flexible delimiter specifications.
This README provides a detailed overview of how to use and what to expect from your Java calculator application.
