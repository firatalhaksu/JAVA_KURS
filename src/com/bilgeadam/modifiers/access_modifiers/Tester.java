package com.bilgeadam.modifiers.access_modifiers;

public class Tester {

    public static void main(String[] args) {
        Encrypted encrypted = new Encrypted();
        encrypted.printer();

        System.out.println("common.name : " + encrypted.name);
        System.out.println("common.encrypted : " + encrypted.isEncrypted);

        Common common = new Common();
        common.printer();

        System.out.println("common.name : " + common.name);
        System.out.println("common.encrypted : " + common.isEncrypted);
    }
}
