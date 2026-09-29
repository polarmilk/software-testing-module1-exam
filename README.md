# Software Testing Module 1 Exam

Project for testing the `TollCalculator` class using multiple test design methods.

## Installation

1. Clone the repository.
```bash
git clone https://github.com/polarmilk/software-testing-module1-exam.git
```
3. Open the project in IntelliJ IDEA or another Java IDE.
4. Ensure Maven dependencies are loaded.
5. Run:

## Running Tests

### Maven

From the project root:

```bash
mvn test
```

### Alternative: Run through IntelliJ IDEA

Open:

```text
src/test/java/Module1Exam/TollCalculatorTest.java
```

Right-click `TollCalculatorTest` and select **Run 'TollCalculatorTest'**.

## Test Location

The unit tests are located at:

```text
src/test/java/Module1Exam/TollCalculatorTest.java
```

The implementation is located at:

```text
src/main/java/Module1Exam/TollCalculator.java
```

## Coverage

JaCoCo coverage reports are generated when running:

```bash
mvn test
```

The report can be found at:

```text
target/site/jacoco/index.html
```

## Documentation

See the project documentation folder for:

* **Problem Specification** — requirements and business rules
* **Test Design** — test coverage items and test cases 
