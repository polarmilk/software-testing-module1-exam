package Module1Exam;

public class TollCalculator {

    public double calculateDiscount(double weight, boolean isEV, boolean isCarpool) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be positive.");
        }

        double discountPercent = 0.0;

        if (weight > 1200 && weight <= 3500) {
            // Fault 5: Branch Coverage
            // Will not execute weight < 1200 is TRUE branch because
            // it is always FALSE from line 12
            // if (weight < 1200) { discountPercent = 0.40 };

            if (isEV && isCarpool) {
                discountPercent = 0.15;
            } else if (isEV || isCarpool) {
                // Fault 1: Equivalence Partition
                // Will fail because discount rate is incorrect for this conditional input
                //discountPercent = 0.40;
                discountPercent = 0.10;
            }

            // Fault 2: Boundary Value Analysis
            // Will fail because of incorrect relational operator
            //else if (weight >= 3500)
        } else if (weight > 3500) {
            // Fault 4: Code Coverage
            // Will not be detected if test cases do not include a specific weight 4444
            // if (weight == 4444) { discountPercent = 0.50 };

            // Fault 3: Decision Table
            // Will fail because of incorrect conditional statement
            //if (isEV || isCarpool)
            if (isEV && isCarpool) {
                discountPercent = 0.25;
            } else {
                discountPercent = 0.05;
            }
        }

        return discountPercent;
    }
}
