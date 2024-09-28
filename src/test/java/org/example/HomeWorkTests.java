package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HomeWorkTests {
    private final HomeWork hw = new HomeWork();
    @ParameterizedTest
    @MethodSource("getValidFindMaxSubstringArguments")
    public void should_findMaxSubstringSuccess(String string, String expectedFound){
        String found = hw.findMaxSubstring(string);

        assertEquals(expectedFound, found);
    }

    @Test
    public void when_stringIsNull_then_findMaxSubstringThrowIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> hw.findMaxSubstring(null));
    }

    private static Stream<Arguments> getValidFindMaxSubstringArguments(){
        return Stream.of(
                Arguments.of("", ""),
                Arguments.of("abcddcba", "abcd"),
                Arguments.of("abcddcbaX", "dcbaX"),
                Arguments.of("abcdabcdeabcdef", "abcdef"),
                Arguments.of("abcdefabcdeabcd", "abcdef"));
    }

    @ParameterizedTest
    @MethodSource("getValidCheckArguments")
    public void should_checkSuccess(String string, boolean checkResult){
        boolean result = hw.check(string);

        assertEquals(checkResult, result);
    }

    private static Stream<Arguments> getValidCheckArguments(){
        return Stream.of(
                Arguments.of("The quick brown fox jumps over the lazy dog", true),
                Arguments.of("The quick brown fox jumps over the lazy       dog", true),
                Arguments.of("The quick brown fox jumps over the lazy do", false),
                Arguments.of("", false)
        );
    }

    @Test
    public void when_stringIsNull_then_CheckThrowIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> hw.check(null));
    }
}
