package com.bilgeadam.methods;

public class Numbers {

    //fibonacci switch ile yazımı

    public int findFibonaccies(int index){
         return switch (index){
             case 0 -> 0;
             case 1 -> 1;
             default -> {
                 int [] result = calculateFibonacci(index);
                 yield result[0] + result[1];
             }
         };
    }

    private int [] calculateFibonacci (int number) {
        if (number == 2)
            return new int[]{1 , 0};
        else {
            int [] result = calculateFibonacci(number - 1);
            int tmp = result[0];
            result [0] += result[1];
            result[1] = tmp;
            return result;
        }

    }

    // if-else bu tarz yazımı

    // ? 'den öncesi (koşul kısmı)
    // ? 'den sonrası (çıktı kısmı)
    // : 'den öncesi (koşul sağlanıyorsa)
    // : 'de sonrası (koşul sağlanmıyorsa - else durumu)


    //faktöriyel

    public int factorial (int number){
            return number == 1 ? 1 : number * factorial(number - 1);
    }

}
