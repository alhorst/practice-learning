package com.techelevator;

public class Exercise06_ElectricBill {

    /*
    Tech Electric is an energy provider with a simple pricing model:
        The first 100 units (basic service limit) are $0.20 per unit (basic service rate).
        Anything more than the basic service limit is $0.25 per unit (excess service rate).
    The following problems have you calculate a customer's total for their energy usage.
     */
    // ((100 * 0.20) + ((units over 100 - 100) * 0.25))
    // You can use these constants in your solutions.
    private final double BASIC_SERVICE_RATE = 0.20;
    private final double BASIC_SERVICE_LIMIT = 100.0;
    private final double EXCESS_SERVICE_RATE = 0.25;
    private final double RENEWABLE_ENERGY_DISCOUNT = 0.05;

    /*
    Using Tech Electric's simple pricing model, calculate a customer's bill for the units they've used.

    Examples:
    calculateElectricBill(50) ➔ 10.0
    calculateElectricBill(63.7) ➔ 12.74
    calculateElectricBill(110) ➔ 22.5
     */
    public double calculateElectricBill(double unitsUsed) {
        if (unitsUsed <= BASIC_SERVICE_LIMIT) {
            return unitsUsed * BASIC_SERVICE_RATE;
        }
        else if (unitsUsed > BASIC_SERVICE_LIMIT) {
            return ((BASIC_SERVICE_LIMIT * BASIC_SERVICE_RATE) + ((unitsUsed - BASIC_SERVICE_LIMIT) * EXCESS_SERVICE_RATE));
        } else {
            return 0;
        }
    }

    /*
    Tech Electric realized some of their customers have renewable energy like solar panels.
    To reward those customers, Tech Electric gives them a 5% renewable energy discount off their bill.

    Using Tech Electric's simple pricing model, calculate a customer's bill, applying the additional
    renewable energy discount if they have renewable energy.

    Examples:
    calculateElectricBill(50, false) ➔ 10.0
    calculateElectricBill(50, true) ➔ 9.5
    calculateElectricBill(110, true) ➔ 21.375
     */
    public double calculateElectricBill(double unitsUsed, boolean hasRenewableEnergy) {
        double overageCost = ((BASIC_SERVICE_LIMIT * BASIC_SERVICE_RATE) + ((unitsUsed - BASIC_SERVICE_LIMIT) * EXCESS_SERVICE_RATE));
        double regularCost = unitsUsed * BASIC_SERVICE_RATE;

        double overageDiscount = overageCost * RENEWABLE_ENERGY_DISCOUNT;
        double regularDiscount = regularCost * RENEWABLE_ENERGY_DISCOUNT;

        if (unitsUsed <= BASIC_SERVICE_LIMIT) {
            if (hasRenewableEnergy) {
                return regularCost - regularDiscount;
            } else {
                return unitsUsed * BASIC_SERVICE_RATE;
            }
        } else if (unitsUsed > BASIC_SERVICE_LIMIT) {
            if (hasRenewableEnergy) {
                return overageCost - overageDiscount;
            } else {
                return overageCost;
            }
        } else {
            return 0;
        }
    }

    /*
    Tech Electric now allows customers with renewable energy to return electricity back into the grid,
    and has accordingly adjusted the rules around the renewable energy discount.

    The difference between the units used by the customer and the units returned by them is the net usage.

    Using Tech Electric's simple pricing model, calculate a customer's bill based upon their net usage.
    Apply the renewable energy discount. Customers with a "credit" bill (a negative bill amount), or who
    have not contributed back to the grid (zero returned units) are not eligible for the renewable energy
    discount.

    Implement the logic to calculate a customer's bill when provided with the number of units used and
    units returned.

    Examples:
    calculateElectricBill(50, 0) ➔ 10.0
    50 * .20
    calculateElectricBill(50, 4) ➔ 8.74
    (50 - 4) = 46 * .20 = 9.2 (9.2 * .05 = .46) 9.2 - .46
    calculateElectricBill(50, 60) ➔ -2.0
    50 - 60 = -10 * .20 = -2
    calculateElectricBill(110, 6) ➔ 19.95
    110 - 6 = 104 > (100 * .20) = 20 (+ 4 * .25) = 21 then discount 21 - 1.05
    calculateElectricBill(110, 20) ➔ 17.1
    calculateElectricBill(110, 120) ➔ -2.0
    110 - 120 = -10 * .20
    (10, 0) > 2.0
    10 * .2
     */
    public double calculateElectricBill(double unitsUsed, double unitsReturned) {
        double netUsage = unitsUsed - unitsReturned;
        double electricBill = 0;
        double discount = 1 - RENEWABLE_ENERGY_DISCOUNT;

        if (netUsage <= BASIC_SERVICE_LIMIT) {
            electricBill = netUsage * BASIC_SERVICE_RATE;
        }
        else {
            electricBill = ((BASIC_SERVICE_LIMIT * BASIC_SERVICE_RATE) + ((netUsage - BASIC_SERVICE_LIMIT) * EXCESS_SERVICE_RATE));
        }
        if (netUsage > 0 && unitsReturned > 0) {
            electricBill *= discount;
        }
            return electricBill;
        }
}
