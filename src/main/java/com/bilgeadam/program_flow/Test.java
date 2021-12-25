package com.bilgeadam.program_flow;

import com.bilgeadam.program_flow.aritmetic.AritmeticOperators;
import com.bilgeadam.program_flow.assignment.AssignmentOperators;
import com.bilgeadam.program_flow.bitwise.BitwiseOperators;
import com.bilgeadam.program_flow.decision_making.Decisions;
import com.bilgeadam.program_flow.logical.LogicalOperators;
import com.bilgeadam.program_flow.relational.RelationalOperators;

public class Test {

    private static void testAritmeticOperators(){
        AritmeticOperators operators = new AritmeticOperators();

        int x = 2 , y = -3;
        System.out.println(x + " + " + y + " = " + operators.sum(x,y));

        x = 0;
        y = 15_000_000;
        System.out.println(x + " + " + y + " = " + operators.sum(x,y));

        //min ve max değerlerde alınabilecek en sınır değer gösterilir.

        x = Integer.MAX_VALUE;
        y = 1;
        System.out.println(x + " + " + y + " = " + operators.sum(x,y));

        x = Integer.MIN_VALUE;
        y = -1;
        System.out.println(x + " + " + y + " = " + operators.sum(x,y));

        float a = 0.4F, b = -15_000.123F;
        System.out.println(a + " - " + b + " = " + operators.subtraction(a,b));

        //NaN : Not a number
        //E : (üzeri/üs)
        //NaN bir değerler yapılan işlemler NaN değer döndürür.

        a = Float.NaN;
        b = 0.123E-32F;
        System.out.println(a + " - " + b + " = " + operators.subtraction(a,b));

        a = Float.POSITIVE_INFINITY;
        b = Float.POSITIVE_INFINITY;
        System.out.println(a + " - " + b + " = " + operators.subtraction(a,b));

        //aşağıdaki işlem short'un bit değerini aştığı için sınır kadar sonuç döndürüyor.

        short q = 432, w = -567;
        System.out.println(q + " * " + w + " = " + operators.multipication(q,w));

        q = Short.MIN_VALUE;
        w = Short.MIN_VALUE;
        System.out.println(q + " * " + w + " = " + operators.multipication(q,w));


        int c = 15645, d = -154;
        System.out.println(c + " / " + d + " = " + operators.division(c,d));

        // sayı / 0 = sonsuz

        c = 15645; d = 0;
        System.out.println(c + " / " + d + " = " + operators.division(c,d));

        // 0 / 0 = NaN (tanımsız)

        c = 0; d = 0;
        System.out.println(c + " / " + d + " = " + operators.division(c,d));

        byte v = 4;
        System.out.println(v +  " Increment by one = " + operators.incrementByOne(v));

        //max değer 1 arttırılınca işaret bitinden dolayı -128 döndürüyor

        v = Byte.MAX_VALUE;
        System.out.println(v +  " Increment by one = " + operators.incrementByOne(v));

        long t = 45;
        System.out.println(t +  " Decrement by one = " + operators.decrementByOne(t));

        t = Long.MIN_VALUE;
        System.out.println(t +  " Decrement by one = " + operators.decrementByOne(t));
    }

    private static void testRelationalOperators(){
        RelationalOperators operators = new RelationalOperators();

        float x = 123F, y = -45.2345F;
        operators.computeRelations(x, y);

        x = Float.POSITIVE_INFINITY;
        y = Float.NaN;
        operators.computeRelations(x, y);

        x = Float.POSITIVE_INFINITY;
        y = Float.POSITIVE_INFINITY;
        operators.computeRelations(x , y);

        x = Float.NaN;
        y = Float.NaN;
        operators.computeRelations(x, y);

    }

    private static void testBitwiseOperations(){
        BitwiseOperators operators = new BitwiseOperators();

        int x = 0b10001,
            y = 0b01110;
        operators.bitwiseOperations(x, y);

    }

    private static void testLogicalOperators(){
        LogicalOperators operators = new LogicalOperators();

        operators.logicalChecks(true,false,true);
    }

    private static void testAssignmentOperators(){
        AssignmentOperators operators = new AssignmentOperators();

        int x = 4, y = 123;
        operators.addAndAssign(x,y);
        operators.substractAnAssign(x,y);
        operators.multipleAnAssign(x,y);
        operators.divideAnAssign(x,y);
        operators.modAndAssign(x,y);
        operators.bitwiseAndAssign(x,y);
        operators.bitwiseOrAssign(x,y);
        operators.bitwiseXorAssign(x,y);
        operators.bitwiseLeftShiftAssign(x,y);
        operators.bitwiseRightShiftAssign(x,y);
    }

    private static void testDecisionMaking(){
        Decisions decisions = new Decisions();

        float x = 546648F;
        decisions.printEvenNumbers(x);
        decisions.printEvenNumbers(541873F);
        decisions.printEvenNumbers(null);
        decisions.printEvenNumbers(Float.POSITIVE_INFINITY);

        decisions.printOddOrEvenNumbers(Double.NaN);
        decisions.printOddOrEvenNumbers(23D);
        decisions.printOddOrEvenNumbers(362E23D);

        decisions.printNumbersFor(new int[] {-123,54,874,4,210,41});

        decisions.printNumbersWhile(new int []{54,874,4,210,41});

        decisions.printStrings("First", "Second", "Third", "Fourth");

    }


    public static void main(String[] args) {
        //testAritmeticOperators();

        //testRelationalOperators();

        //testBitwiseOperations();

        //testLogicalOperators();,

        //testAssignmentOperators();

        testDecisionMaking();
    }

}
