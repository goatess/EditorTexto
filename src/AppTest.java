import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AppTest {
    @Test
    public void search_word() {
        // arrange
        final boolean expectedBool = true;
        WordLists wordsList = new WordLists();
        // act
        boolean actualBool = wordsList.isFound_ByWord("Java8", "Java8 makes Java more powerful");
        // assert
        assertEquals(expectedBool, actualBool);
    }

    @Test
    public void word_appears_1_time() {
        // arrange
        final int expectedFrequency = 1;
        WordLists wordsList = new WordLists();
        String testText = "Java8 makes Java more powerful";

        // act
        wordsList.searchWord("Java8", testText);
        int actualFrecuency = wordsList.getFrequency();

        // assert
        assertEquals(expectedFrequency, actualFrecuency);
    }

    @Test
    public void word_appears_2_times() {
        // arrange
        final int expectedFrequency = 2;
        WordLists wordsList = new WordLists();
        String testText = "Java8 Java8 makes Java more powerful";

        // act
        wordsList.searchWord("Java8", testText);
        int actualFrecuency = wordsList.getFrequency();

        // assert
        assertEquals(expectedFrequency, actualFrecuency);
    }

    @Test
    public void string_converts_to_array() {
        // arrange
        final String[] arrayExpected = { "Java8", "makes", "Java", "more", "powerful" };
        WordLists wordsList = new WordLists();

        // act
        wordsList.enlistWords("Java8 makes Java more powerful");
        String[] actualArray = wordsList.getWords();

        // assert
        assertArrayEquals(arrayExpected, actualArray);
    }

    @Test
    public void string_converts_to_no_duplicates_array() {
        // arrange
        final String[] arrayExpected = { "Java8", "makes", "Java", "more", "powerful" };
        WordLists wordsList = new WordLists();

        // act
        wordsList.enlistWords("Java8 Java8 makes Java more powerful");
        String[] actualArray = wordsList.getWords();

        // assert
        assertArrayEquals(arrayExpected, actualArray);
    }

    @Test
    public void search_word_in_array() {
        // arrange
        final String wordExpected = "makes";
        WordLists wordsArray = new WordLists();

        // act
        wordsArray.enlistWords("Java8 Java8 makes Java Java more powerful Java8");
        String actualWord = wordsArray.getWord_ByPosition(1);

        // assert
        assertEquals(wordExpected, actualWord);
    }

    @Test
    public void get_full_word_frequencies_list() {
        // arrange
        final int[] frequenciesExpected = { 3, 1, 2, 1, 1 };
        WordLists wordList = new WordLists();

        // act
        String[] testWords = { "Java8", "makes", "Java", "more", "powerful" };
        String[] testAllWords = { "Java8", "Java8", "makes", "Java", "Java", "more", "powerful", "Java8" };

        // wordsList.enlistWords(testText);
        wordList.setAllWords(testAllWords);
        wordList.setWords(testWords);
        wordList.enlistFrequencies();
        int[] actualFrequencies = wordList.getFrequencies();

        // assert
        assertArrayEquals(frequenciesExpected, actualFrequencies);
    }

    @Test
    public void get_frequencies_from_text() {
        // arrange
        final int[] frequenciesExpected = { 3, 1, 2, 1, 1 };
        WordLists wordList = new WordLists();

        // act
        String testText = "Java8 Java8 makes Java Java more powerful Java8";

        // wordsList.enlistWords(testText);
        wordList.enlistWords(testText);
        int[] actualFrequencies = wordList.getFrequencies();

        // assert
        assertArrayEquals(frequenciesExpected, actualFrequencies);
    }

    @Test
    public void sorts_by_frequencies() {
        // arrange
        SortedLists listsConnection = new SortedLists();
        final int[] testFrequencies = { 3, 2, 5, 1, 4 };
        final int[] expectedFrequencies = { 5, 4, 3, 2, 1 };
        final String[] testWords = { "Java8", "makes", "code", "more", "powerful" };

        // act
        listsConnection.sortArrays(testWords, testFrequencies);
        int[] actualFrequencies = listsConnection.getFrequencies();

        // assert
        assertArrayEquals(expectedFrequencies, actualFrequencies);

    }

    @Test
    public void words_get_sorted_by_frequencies() {
        // arrange
        SortedLists listsConnection = new SortedLists();
        final int[] testFrequencies = { 3, 2, 5, 1, 4 };
        final String[] expectedWords = { "code", "powerful", "Java8", "makes", "more" };
        final String[] testWords = { "Java8", "makes", "code", "more", "powerful" };

        // act

        listsConnection.sortArrays(testWords, testFrequencies);
        String[] actualWords = listsConnection.getWords();

        // assert
        assertArrayEquals(expectedWords, actualWords);

    }

    @Test
    public void sorts_by_frequencies_fromText() {
        // arrange
        final int[] expectedFrequencies = { 3, 2, 1, 1, 1 };
        String testText = "Java8 Java8 makes Java Java more powerful Java8";
        SortedLists listsConnection = new SortedLists();

        // act
        listsConnection.processText(testText);
        int[] actualFrequencies = listsConnection.getFrequencies();

        // assert
        assertArrayEquals(expectedFrequencies, actualFrequencies);

    }

    @Test
    public void words_get_sorted_fromText() {
        // arrange
        final String[] expectedWords = { "Java8", "makes", "Java", "more", "powerful" };
        String testText = "Java8 Java8 Java8 makes makes makes makes Java Java Java more more powerful Java8 Java8";
        SortedLists listsConnection = new SortedLists();

        // act

        listsConnection.processText(testText);
        String[] actualWords = listsConnection.getWords();

        // assert
        assertArrayEquals(expectedWords, actualWords);
    }

    @Test
    public void most_used_word_fromText() {
        // arrange
        final String expectedWord = "Java8";
        String testText = "Java8 Java8 Java8 makes makes makes makes Java Java Java more more powerful Java8 Java8";
        SortedLists listsConnection = new SortedLists();

        // act
        listsConnection.processText(testText);
        String actualWord = listsConnection.getMostUsed();

        // assert
        assertEquals(expectedWord, actualWord);
    }

    @Test
    public void percentage_of_most_used_word_fromText() {
        // arrange
        final int expectedPercent = 33;
        String testText = "Java8 Java8 Java8 makes makes makes makes Java Java Java more more powerful Java8 Java8";
        SortedLists listsConnection = new SortedLists();

        // act
        listsConnection.processText(testText);
        int actualPercent = listsConnection.getPercentage();

        // assert
        assertEquals(expectedPercent, actualPercent);
    }
}