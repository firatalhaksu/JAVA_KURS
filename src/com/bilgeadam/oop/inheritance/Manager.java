package com.bilgeadam.oop.inheritance;

public class Manager extends Person {
    private Long bonus;
    private int years;

    public Manager(long ID, String firstName, String lastName) {
        super(ID, firstName, lastName);
    }

    protected void setSalary(long salary, long bonus){
        this.bonus = bonus;
        super.salary = salary;
        this.years = 233;
        super.years = 123;
    }

    protected long getBonus() {
        return bonus;
    }
}
