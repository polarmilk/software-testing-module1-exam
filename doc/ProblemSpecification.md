# Problem Specification

The "Eco-Friendly Vehicle Toll Discount System" offers toll discounts based on three factors:

1. **Vehicle Weight:** Measured in kilograms (`weight`).
2. **Electric Vehicle (EV) Status:** Whether the vehicle is fully electric (`isEV`).
3. **Carpool Status:** Whether the vehicle carries 3 or more passengers (`isCarpool`).

## Business Rules

- **Invalid Input:** Any `weight <= 0` must throw an `IllegalArgumentException`.
- **Tier 1 (`0 < weight <= 1200`):** 0% rebate regardless of EV or Carpool status (base rate for light compact vehicles).
- **Tier 2 (`1200 < weight <= 3500`):**
    - 15% rebate if the vehicle is an EV **AND** Carpool.
    - 10% rebate if the vehicle is an EV **OR** Carpool.
    - 0% rebate if neither applies.
- **Tier 3 (`weight > 3500`):**
    - 25% rebate if the vehicle is an EV **AND** Carpool.
    - Otherwise, 5% baseline "commercial green incentive" rebate.