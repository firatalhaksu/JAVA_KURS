package com.bilgeadam.patterns;

import com.bilgeadam.patterns.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class StringsTest {
    private Strings strings;

    @BeforeEach
    void setUp() {
        strings = new Strings();
    }

    @ParameterizedTest
    @ValueSource (strings = {"asdd", "a", "1"})
    void isWord(String input) {
        assertTrue(strings.isWord("asd"));
    }

    @ParameterizedTest
    @ValueSource (strings = {"asde 1254" , "e4r2   145", "145 852"})
    void isProperLabel(String s){
        assertTrue(strings.isProperLabel(s));
    }

    @ParameterizedTest
    @ValueSource (strings = {"asder1254" , "er2    145", "kfkhf 2 2 kjlkgkjwbgklk"})
    void isImproperLabel(String s){
        assertFalse(strings.isProperLabel(s));
    }

}

