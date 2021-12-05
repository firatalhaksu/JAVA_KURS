package com.bilgeadam.oop.abstraction;

public final class LimitedCompany extends AbstractCompany {
    private final String[] owners;


    public LimitedCompany(String [] owners, int currentEmployeeCount) {
        super(null, currentEmployeeCount);
        this.owners = owners;
    }

    @Override
    protected boolean isValidEmployee(String candidate) {
        return !candidate.isBlank();
    }

    @Override
    protected boolean isEmployeeTerminated(String employee) {
        return !employee.isBlank();
    }

    @Override
    public String getOwner() {
        String response = "";
        for (String o : owners) {
            response += o + ", ";
        }
        return response.substring(0, response.lastIndexOf(", "));
    }
}
