package com.bilgeadam.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;


class MatcherTest {
    private Matcher matcher;

    @BeforeEach
    void setUp() {
        matcher = new Matcher();
    }

    private static Stream<Arguments> parenthesisArgs(){
        return Stream.of(
                Arguments.of("", true),
                Arguments.of("    ", true),
                Arguments.of("((hgfh))", true),
                Arguments.of("   \t", true),
                Arguments.of(")((x)", false),
                Arguments.of("(klejfhoıehfogwefşlshg<shgş)", true),
                Arguments.of("((y)x))", false),
                Arguments.of("u23t78rgwef(fgıgfı{[[]kfbew)kgkj", true),
                Arguments.of("u23gwef(fgıgfı{[[)]kfbew)kgkj", false)
        );
    }

    @ParameterizedTest
    @MethodSource("parenthesisArgs")
    void parenthesisMatcher(String input, boolean result) {
        Assertions.assertEquals(result, matcher.parenthesisMatcher(input));
    }

    @Test
    void nullCheck(){
        Assertions.assertTrue(matcher.parenthesisMatcher(null));
    }
}