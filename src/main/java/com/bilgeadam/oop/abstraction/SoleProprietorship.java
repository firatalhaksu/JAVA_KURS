package com.bilgeadam.oop.abstraction;

public final class SoleProprietorship extends AbstractCompany {
    private static final byte MAX_EMPLOYEE_COUNT = 50;
    private boolean isActive;

    public SoleProprietorship(String owner, int currentEmployeeCount) {
        super(owner, currentEmployeeCount);
    }

    @Override
    protected boolean isValidEmployee(String candidate) {
        return !candidate.isBlank() &&  super.getEmployeeCounter() < MAX_EMPLOYEE_COUNT;
    }

    @Override
    protected boolean isEmployeeTerminated(String employee) {
        return false;
    }

    protected void closeCompany(){
        isActive = false;
    }

    protected void reopenCompany(){
        isActive = true;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }
}