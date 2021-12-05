package com.bilgeadam.methods;

public class Methods {

    //method oluşturma

    int sum;

    public void methodWithNoParams () {
        System.out.println("Method.methodWithNoParams");
    }

    public void methodWithParams (String name) {
        System.out.println("Method.methodWith.Params called by " + name);
    }

    //yukarıdaki ve aşağıdaki method isimleri aynı;
    //ancak aldıkları parametre sayıları farklı olduğundan; verilen parametre sayısına göre doğru olanı çağırır.
    //parametre sayısı ve tipleri method'ların signature'nı oluşturur.

    public void methodWithParams(int counter, String name){
        int x = 2;
        char a = 'a';
        System.out.println("Method.methodWithMultipleParams called by " + name);
        System.out.println("counter = " + counter);
        System.out.println("x : " + x);
        System.out.println("char : " + a);

    }

    public void methodCaller (){                                       //method çağıran method
        methodWithParams("deneme");
        methodWithParams(123,"DENEME");
        methodWithNoParams();
    }

    public byte calculator(byte x){
        System.out.println("Method.calculator");
        return (byte) (x+1);
    }

    public int calculator(int x){
        System.out.println("Methods.calculator");
        System.out.println("Parameter x = " + x);
        sum = x + 1;
        System.out.println("Field sum = " + sum);

        return sum + 2;
    }

    //oluturulan method'ları çağırma

    public static void main(String[] args) {
        Methods methods = new Methods();

        methods.methodWithNoParams();
        System.out.println("-------------------");

        methods.methodWithParams("MUHAMMET KILIÇ");
        System.out.println("-------------------");

        methods.methodWithParams(5,"MUHAMMET KILIÇ");
        System.out.println("-------------------");

        methods.methodCaller();
        System.out.println("-------------------");

        byte x;
        x = methods.calculator((byte)3);
        System.out.println("x = " + x);
        System.out.println("-------------------");

        int z = 0;
        z = methods.calculator(9);
        System.out.println("z = " + z);

    }
}
