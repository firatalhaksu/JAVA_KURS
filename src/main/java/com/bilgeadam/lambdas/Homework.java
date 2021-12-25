package com.bilgeadam.lambdas;

@FunctionalInterface                            //lambda olarak kullanılacak interface'ler için tanımlama.ZORUNLU DEĞİL.
public interface Homework {
    void doHomework(String lesson, int duration);
}
