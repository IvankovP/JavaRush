package level_20.Bobr.t12;

import java.util.ArrayList;
import java.util.List;

/*
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'e', 'f', 'f', 'f', 'f', 'e', 'e', 'e', 'l', 'e'},
                {'o', 'f', 'e', 'f', 'e', 'm', 'e', 'n', 'n', 'n', 'o'},
                {'h', 's', 'a', 'm', 'e', 'e', 'e', 'n', 'o', 'n', 'e'},
                {'o', 'f', 'o', 'f', 'o', 'n', 'l', 'n', 'n', 'n', 'h'},
                {'h', 'h', 'f', 'f', 'f', 'h', 'e', 'e', 'e', 'j', 'e'}
        };
        detectAllWords(crossword, "hoho", "one", "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {

        List<Word> findCoordinatsWords = new ArrayList<>();

        for (String word : words) {
            findPoints(crossword, findCoordinatsWords, word);
        }
        for (Word w : findCoordinatsWords) {
            System.out.println(w);
        }

        return findCoordinatsWords;
    }

    private static void findPoints(int[][] crosswords, List<Word> findCoordinatsWords, String word) {
        int countSimbol = 0;
        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY = 0;

        for (int i = 0; i < crosswords.length; i++) {
            for (int j = 0; j < crosswords[i].length; j++) {
                if (crosswords[i][j] == word.charAt(0)) {
                    startX = j;
                    startY = i;
                    endX = j;
                    endY = i;
                    countSimbol = 0;

                    if (word.length() > 1) {
                        findNextPoints(crosswords, findCoordinatsWords, word, ++countSimbol, startX, startY, -2, -2);
                    } else {
                        addWord(word, findCoordinatsWords, startX, startY, endX, endY);
                    }
                }
            }
        }
    }

    private static void findNextPoints(int[][] crosswords, List<Word> findCoordinatsWords, String word, int countSimbol, int startX, int startY, int nextX, int nextY) {

        char simbol = word.charAt(countSimbol);

        for (int i = startY - 1; i <= startY + 1; i++) {
            for (int j = startX - 1; j <= startX + 1; j++) {

                if (i < 0 ||
                    j < 0 ||
                    i > crosswords.length - 1 ||
                    j > crosswords[i].length - 1 ||
                    crosswords[i][j] != simbol) continue;

                countSimbol = 1;

                if (crosswords[i][j] == simbol && countSimbol == word.length() - 1) {
                    addWord(word, findCoordinatsWords, startX, startY, j, i);
                } else {
                    nextX = j - startX;
                    nextY = i - startY;
                    findEndPoints(crosswords, findCoordinatsWords, word, ++countSimbol, startX, startY, nextX, nextY);
                }
            }
        }
    }

    private static void findEndPoints(int[][] crosswords, List<Word> findCoordinatsWords, String word, int countSimbol, int startX, int startY, int nextX, int nextY) {
        int X = startX + nextX * countSimbol;
        int Y = startY + nextY * countSimbol;
        char simbol = word.charAt(countSimbol);

        if (Y < 0 ||
            X < 0 ||
            Y > crosswords.length - 1 ||
            X > crosswords[Y].length - 1 ||
            crosswords[Y][X] != simbol) return;
        else if (crosswords[Y][X] == simbol && countSimbol == word.length() - 1) {
            addWord(word, findCoordinatsWords, startX, startY, X, Y);
        } else {
            findEndPoints(crosswords, findCoordinatsWords, word, ++countSimbol, startX, startY, nextX, nextY);
        }
    }

    private static void addWord(String name, List<Word> findCoordinatsWords, int startX, int startY, int endX, int endY) {
        Word wordObj = new Word(name);
        wordObj.startX = startX;
        wordObj.startY = startY;
        wordObj.endX = endX;
        wordObj.endY = endY;
        findCoordinatsWords.add(wordObj);
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}