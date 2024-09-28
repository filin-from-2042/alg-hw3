package org.example;

import java.util.*;
import java.util.stream.Collectors;


public class HomeWork {

    /**
     * <h1>Задание 1.</h1>
     * Метод возвращает подстроку максимальной длины в которой не повторяются символы
     * Если найдено несколько подстрок одинаковой длины - вернуть первую.
     *
     * Пример 1 вход= abcddcba, выход = abcd
     * Так как найдены две подстроки с неповторяющимися значениями:
     * 1) abcd
     * 2) dcba
     * Они динаковой длины, по этому возвращаем 1 строку
     *
     * Пример 2 вход= abcddcbaX, выход = dcbaX
     * Так как эта подстрока самая большая
     *
     * @param str входная не пустая строка
     * @return максимальная подстрока из уникальных значений
     * Сигнатуру метода не меняем
     */
    public String findMaxSubstring(String str) {
        if (str == null) {
            throw new IllegalArgumentException("str is null");
        }
        char[] chars = str.toCharArray();

        String maxSubstring = "";
        Set<Character> set = new LinkedHashSet<>();
        int index = 0;
        for (char c : chars) {
            if (!set.add(c) || index == chars.length - 1) {
                if (set.size() > maxSubstring.length()) {
                    maxSubstring = getString(set);
                }
                set = new LinkedHashSet<>();
                set.add(c);
            }
            index++;
        }

        return maxSubstring;
    }

    private String getString(Set<Character> set) {
        return set.stream().map(String::valueOf).collect(Collectors.joining());
    }

    /**
     * Задача со зведочкой (опционально)
     * <br/>
     * Можно решать так же для английского алфавита, проверять что присутствуют буквы от A до Z хотя бы по одному разу.
     * <br/>
     * A pangram is a sentence that contains every single letter of the alphabet at least once. For example, the sentence "The quick brown fox jumps over the lazy dog" is a pangram, because it uses the letters A-Z at least once (case is irrelevant).
     * <p>
     * Given a string, detect whether or not it is a pangram. Return True if it is, False if not. Ignore numbers and punctuation.
     *
     * @see <a href="https://www.codewars.com/kata/545cedaa9943f7fe7b000048">https://www.codewars.com/kata/545cedaa9943f7fe7b000048</a>
     */
    public boolean check(String sentence) {
        if (sentence == null) {
            throw new IllegalArgumentException("sentence is null");
        }

        Set<String> set = new HashSet<>();
        char[] chars = sentence.replaceAll("\\s+", "").toCharArray();

        for (char c : chars) {
            set.add(String.valueOf(c).toLowerCase(Locale.ROOT));
        }

        return set.size() == 26;
    }

}
