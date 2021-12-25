package com.bilgeadam.modifiers;

import com.bilgeadam.modifiers.access_modifiers.Common;

public class TesterOutside {


    public static void main (String [] args) {
        Common common = new Common();

        common.printer();
        common.printer();
        common.printer();
        System.out.println("common.name : " + common.name);
    }
}
