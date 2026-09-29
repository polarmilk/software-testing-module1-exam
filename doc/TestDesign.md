# Test Design
This file contains the design for the test coverage items and test cases.  

## 1. Equivalence Partitions 
| TCI | Parameter | Equivalence Partition | Description |
|---|---|---|---|
| EP1 | Weight | w <= 0 | Invalid weight (kg) |
| EP2 | Weight | 0 < w <= 1200 | Weight 0–1200 kg |
| EP3 | Weight | 1200 < w <= 3500 | Weight 1201–3500 kg |
| EP4 | Weight | w > 3500 | Weight above 3500 kg |
| EP5 | isEV | TRUE | Electric vehicle |
| EP6 | isEV | FALSE | Non-electric vehicle |
| EP7 | isCarpool | TRUE | Carpool vehicle |
| EP8 | isCarpool | FALSE | Non-carpool vehicle |

### 1.1. EP Test Cases
| Test Case | Weight | isEV  | isCarpool | Expected Result   | Test Coverage |
| --------- | ------ | ----- | --------- | ----------------- | ------------- |
| TC1       | -10    | FALSE | FALSE     | Invalid Exception | EP1, EP6, EP8 |
| TC2       | 500    | TRUE  | FALSE     | 0                 | EP2, EP5, EP8 |
| TC3       | 2500   | FALSE | TRUE      | 10                | EP3, EP6, EP7 |
| TC4       | 5000   | TRUE  | TRUE      | 25                | EP4, EP5, EP7 |

## 2. Boundary Value Analysis
Two-point BVA is used here. The decision boundaries are 0, 1200, and 3500. Values adjacent to these
decision boundaries were chosen where behavior shifts. 

| TCI  | Parameter | Boundary Value Analysis | Description                        |
|---|---|---:|------------------------------------|
| BVA1 | Weight | 0 | Maximum invalid weight             |
| BVA2 | Weight | 1 | Tier 1 minimum; just above invalid |
| BVA3 | Weight | 1200 | Tier 1 maximum; just below Tier 2  |
| BVA4 | Weight | 1201 | Tier 2 minimum; just above Tier 1  |
| BVA5 | Weight | 3500 | Tier 2 maximum; just below Tier 3  |
| BVA6 | Weight | 3501 | Tier 3 minimum; just above Tier 2  |

### 2.1. BVA Test Cases
| Test Case | Weight | isEV  | isCarpool | Expected Result   | Test Coverage |
|-----------| ------ | ----- | --------- | ----------------- | ------------- |
| TC5       | 0      | FALSE | FALSE     | Invalid Exception | BVA1           |
| TC6       | 1      | FALSE | FALSE     | 0                 | BVA2           |
| TC7       | 1200   | FALSE | FALSE     | 0                 | BVA3           |
| TC8       | 1201   | FALSE | FALSE     | 0                 | BVA4           |
| TC9       | 3500   | FALSE | FALSE     | 0                 | BVA5           |
| TC10      | 3501   | FALSE | FALSE     | 5                 | BVA6           |

## 3. Decision Table
Four causes each with a binary outcome produces 2^4 = 16 combinations. However, this problem 
contains combinations that are infeasible, where w <= 1200 is TRUE and w <= 3500 is FALSE. After removing
the infeasible combinations, 12 feasible combinations/rules remain. 

|  | Rule 1 | Rule 2 | Rule 3 | Rule 4 | Rule 5 | Rule 6 | Rule 7 | Rule 8 | Rule 9 | Rule 10 | Rule 11 | Rule 12 |
|---|---|---|---|---|---|---|---|---|---|---|---|---|
| **Causes** |  |  |  |  |  |  |  |  |  |  |  |  |
| w <= 1200 | T | F | F | T | F | F | T | F | F | T | F | F |
| w <= 3500 | T | T | F | T | T | F | T | T | F | T | T | F |
| isEV | T | T | T | T | T | T | F | F | F | F | F | F |
| isCarpool | T | T | T | F | F | F | T | T | T | F | F | F |
| **Effects** |  |  |  |  |  |  |  |  |  |  |  |  |
| Discount | 0% | 15% | 25% | 0% | 10% | 5% | 0% | 10% | 5% | 0% | 0% | 5% |

### 3.1. DT Test Cases

| Test Case | weight | isEV  | isCarpool | Result | Test Coverage |
| --------- | ------ | ----- | --------- | ------ | ------------- |
| TC11      | 500    | TRUE  | TRUE      | 0      | Rule 1        |
| TC12      | 2500   | TRUE  | TRUE      | 15     | Rule 2        |
| TC13      | 5000   | TRUE  | TRUE      | 25     | Rule 3        |
| TC14      | 500    | TRUE  | FALSE     | 0      | Rule 4        |
| TC15      | 2500   | TRUE  | FALSE     | 10     | Rule 5        |
| TC16      | 5000   | TRUE  | FALSE     | 5      | Rule 6        |
| TC17      | 500    | FALSE | TRUE      | 0      | Rule 7        |
| TC18      | 2500   | FALSE | TRUE      | 10     | Rule 8        |
| TC19      | 5000   | FALSE | TRUE      | 5      | Rule 9        |
| TC20      | 500    | FALSE | FALSE     | 0      | Rule 10       |
| TC21      | 2500   | FALSE | FALSE     | 0      | Rule 11       |
| TC22      | 5000   | FALSE | FALSE     | 5      | Rule 12       |

## Test Suite
After combining the test cases from each testing method and removing duplicate cases, the finalized test suite contains 19 unique cases. 
The following duplicate test cases were removed based on exact matching inputs: 
TC13 (duplicate of TC4), TC14 (duplicate of TC2), and TC18 (duplicate of TC3).

| Test Case | Weight | isEV  | isCarpool | Expected Result |
| --------- | ------ | ----- | --------- | --------------- |
| TC1       | -10    | FALSE | FALSE     | Invalid Exception |
| TC2       | 500    | TRUE  | FALSE     | 0 |
| TC3       | 2500   | FALSE | TRUE      | 10 |
| TC4       | 5000   | TRUE  | TRUE      | 25 |
| TC5       | 0      | FALSE | FALSE     | Invalid Exception |
| TC6       | 1      | FALSE | FALSE     | 0 |
| TC7       | 1200   | FALSE | FALSE     | 0 |
| TC8       | 1201   | FALSE | FALSE     | 0 |
| TC9       | 3500   | FALSE | FALSE     | 0 |
| TC10      | 3501   | FALSE | FALSE     | 5 |
| TC11      | 500    | TRUE  | TRUE      | 0 |
| TC12      | 2500   | TRUE  | TRUE      | 15 |
| TC13      | 2500   | TRUE  | FALSE     | 10 |
| TC14      | 5000   | TRUE  | FALSE     | 5 |
| TC15      | 500    | FALSE | TRUE      | 0 |
| TC16      | 5000   | FALSE | TRUE      | 5 |
| TC17      | 500    | FALSE | FALSE     | 0 |
| TC18      | 2500   | FALSE | FALSE     | 0 |
| TC19      | 5000   | FALSE | FALSE     | 5 |

## 4. Fault Injection

| Fault | Testing Technique | Injected Fault |
|---|---|---|
| Fault 1 | Equivalence Partition | Incorrect 40% discount instead of 10% |
| Fault 2 | Boundary Value Analysis | `>= 3500` instead of `> 3500` |
| Fault 3 | Decision Table | `||` instead of `&&` for Tier 3 |
| Fault 4 | Code Coverage | Added code for specific weight `4444` |
| Fault 5 | Branch Coverage | Added unreachable `weight < 1200` branch inside Tier 2 |
