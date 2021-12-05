package com.bilgeadam.program_flow.logical;

public class LogicalOperators {

    public void logicalChecks(Boolean x, Boolean y, Boolean z){

        System.out.println(x + " and " + y + " = " + (x && y));
        System.out.println(x + " or " + y + " = " + (x || y));
        System.out.println("Not " + x + " or " + y + " = " + !(x && y));
        System.out.println(x + " and " + y + " or " + z + " = " + (x && y || z));

    }
}
