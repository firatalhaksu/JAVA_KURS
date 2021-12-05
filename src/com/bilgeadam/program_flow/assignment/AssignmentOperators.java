package com.bilgeadam.program_flow.assignment;

public class AssignmentOperators {

    public void addAndAssign(int x , int y){
        int tmp = x;
        x += y; // x = x + y
        System.out.println(tmp + " + " + y + " = " + x);
    }

    public void substractAnAssign(int x, int y) {
        int tmp = x;
        x -= y; //x = x - y
        System.out.println(tmp + " - " + y + " = " + x);
    }

    public void multipleAnAssign(int x, int y){
        int tmp = x;
        x *= y; //x = x * y
        System.out.println(tmp + " * " + y + " = " + x);
    }

    public void divideAnAssign(int x, int y){
        int tmp = x;
        x /= y; //x = x / y
        System.out.println(tmp + " / " + y + " = " + x);

        float f = tmp;
        f /= y; //x = x / y
        System.out.println(tmp + " / " + y + " = " + f);
    }

    public void modAndAssign(int x, int y){
        int tmp = x;
        x %= y; // x = x % y
        System.out.println(tmp + " % " + y + " = " + x);
    }
    public void bitwiseAndAssign(int x, int y){
        int tmp = x;
        x &= y; // x = x & y
        System.out.println(tmp + " & " + y + " = " + x);
    }

    public void bitwiseOrAssign(int x, int y){
        int tmp = x;
        x |= y; // x = x % y
        System.out.println(tmp + " | " + y + " = " + x);
    }

    public void bitwiseXorAssign(int x, int y){
        int tmp = x;
        x ^= y; // x = x ^ y
        System.out.println(tmp + " ^ " + y + " = " + x);
    }

    public void bitwiseLeftShiftAssign(int x, int y){
        int tmp = x;
        x <<= y; // x = x <<%>> y
        System.out.println(tmp + " << " + y + " = " + x);
    }

    public void bitwiseRightShiftAssign(int x, int y){
        int tmp = x;
        x >>= y; // x = x >> y
        System.out.println(tmp + " >> " + y + " = " + x);
    }


}
