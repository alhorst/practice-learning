package com.techelevator;

public class Exercise06_ElectricBill {

    /*
    Tech Electric is an energy provider with a simple pricing model:
        The first 100 units are $0.20 per unit. 
        Anything more than 100 units is $0.25 per unit.
    The following problems have you calculate a customer's total for their energy usage.
     */

    // You can use these constants in your solutions.
    private final double BASE_RATE = 0.20;
    private final double EXCESS_RATE = 0.25;
    private final double EXCESS_UNITS_LIMIT = 100.0;
    private final double DISCOUNT_FACTOR = 0.95;

    /*
    Implement the logic to calculate what a customer owes for the units they've used.

    Examples:
    calculateElectricBill(50) ➔ 10.0
    calculateElectricBill(63.7) ➔ 12.74
    calculateElectricBill(110) ➔ 22.5
     */
    public double calculateElectricBill(double unitsUsed) {
        return 0;
    }

    /*
    Tech Electric realized some of their customers have renewable energy like solar panels.
    To reward those customers, they'll give them 5% off their bill.
    Using the same rates, implement the logic to calculate what a customer owes for the units 
    they've used and if they have renewable energy.

    Examples:
    calculateElectricBill(50, false) ➔ 10.0
    calculateElectricBill(50, true) ➔ 9.5
    calculateElectricBill(110, true) ➔ 21.375
     */
    public double calculateElectricBill(double unitsUsed, boolean hasRenewableEnergy) {
        return 0;
    }

    /*
    Customers with renewable energy can put electricity back into the grid. Each customer's net usage (units used - units returned)
    is calculated so that Tech Electric can determine what discounts to apply and whether the customer should receive money back.

    - The first 100 units are $0.20 per unit.
    - Anything more than 100 units is calculated at a cost of $0.25 per unit.
    - Any customer who puts electricity back into the grid receives a 5% discount.
    - If a customer returns more energy than they've used, they receive a credit of $0.20 per unit for each returned unit.
      Their credit does not include the 5% discount.

    Implement the logic to calculate a customer's bill when provided with a number of units used and units returned.

    Examples:
    calculateElectricBill(50, 0) ➔ 10.0
    calculateElectricBill(50, 4) ➔ 8.74
    calculateElectricBill(50, 60) ➔ -2.0
    calculateElectricBill(110, 6) ➔ 19.95
    calculateElectricBill(110, 20) ➔ 17.1
    calculateElectricBill(110, 120) ➔ -2.0
     */
    public double calculateElectricBill(double unitsUsed, double unitsReturned) {
        return 0;
    }
}
