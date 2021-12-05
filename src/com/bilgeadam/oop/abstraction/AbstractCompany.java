package com.bilgeadam.oop.abstraction;

import java.util.Objects;

abstract class AbstractCompany implements Company {
    private final String owner;

    private int employeeCounter;
    private double financialBalance;

    public AbstractCompany(String owner, int currentEmployeeCount) {
        this.owner = owner;
        this.employeeCounter = currentEmployeeCount;
    }

    protected final boolean hireEmployee(String employeeName){
        if (Objects.nonNull(employeeName) && isValidEmployee(employeeName)) {
            employeeCounter++;
            return true;
        }
        else
            return false;
    }

    protected final boolean terminateEmployee(String employeeName){
        if (Objects.nonNull(employeeName) &&
                ((isActive() && employeeCounter > 1) ||
                (!isActive() && employeeCounter > 0))  &&
                isEmployeeTerminated(employeeName)) {
            employeeCounter--;
            return true;
        }
        else
            return false;
    }

    /**
     *
     * @param candidate candidate employee name
     * @return true if candidate can be hired, false otherwise
     */
    protected abstract boolean isValidEmployee(String candidate);

    /**
     *
     * @param employee name
     * @return true if employee's contract is terminated, false otherwise
     */
    protected abstract boolean isEmployeeTerminated(String employee);

    protected void addIncome(float income){
        if (Float.isFinite(income) && income > 0)
            financialBalance += income;
        else
            System.out.println("Improper input" + income);
    }

    protected void addExpense(float expense){
        if (Float.isFinite(expense) && expense > 0)
            financialBalance -= expense;
        else
            System.out.println("Improper input" + expense);
    }

    protected void resetBalance(){
        financialBalance = 0;
    }

    @Override
    public final float yearlyProfit() {
        return (float) financialBalance;
    }

    public String getOwner() {
        return owner;
    }

    public int getEmployeeCounter() {
        return employeeCounter;
    }

}