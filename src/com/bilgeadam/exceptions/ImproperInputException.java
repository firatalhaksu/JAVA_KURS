package com.bilgeadam.exceptions;

// exception oluşturmak (benzer exception sınıfını extend ediyoruz)

public class ImproperInputException extends IllegalArgumentException {

    ImproperInputException(String s) {
        super("Given input " + s + " does not contain '[' or ']'");
    }
}
