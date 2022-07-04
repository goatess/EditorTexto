import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
    }
}

class WordLists {
    String text = "";
    String[] words = new String[] {};
    String[] wordsWithDupes = new String[] {};
    int[] frequencies = new int[] {};
    int frequency = 0;

    boolean count_ByWord(String word , String text) {
        enlistWords(text);
        boolean found = false;
        int frequency = 0;
        for (int index = 0; index < wordsWithDupes.length; index++) {
            if (word.equals(wordsWithDupes[index])) {
                frequency++;
                }
        }
        this.frequency = frequency;
        if (frequency>0) {
            found = true;
        }
        return found;
    }

    public void enlistWords(String text) {
        String textNoDuplicate = eliminateDuplicates(text, " ");
        String[] words = textNoDuplicate.split(" ");
        this.words = words;
        countAndEnlist();
    }

    String eliminateDuplicates(String text, String splitterRegex) {
        text = text.replaceAll("[\\.\\,\\(\\)]", "");
        List<String> values = new ArrayList<String>();
        String[] wordsWithDupes = text.split(splitterRegex);
        StringBuilder noDuplicate = new StringBuilder();
        for (int index = 0; index < wordsWithDupes.length; ++index) {

            if (!values.contains(wordsWithDupes[index])) {
                values.add(wordsWithDupes[index]);
                noDuplicate.append(" ");
                noDuplicate.append(wordsWithDupes[index]);
            }
        }
        this.wordsWithDupes = wordsWithDupes;
        return noDuplicate.substring(1);
    }

    public void countAndEnlist() {
        int[] frequencies = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int frequency = 0;
            for (int j = 0; j < wordsWithDupes.length; j++) {
                if (words[i].equals(wordsWithDupes[j])) {
                    frequency++;
                }
            }
            frequencies[i] = frequency;
            this.frequency = frequency;
        }
        this.frequencies = frequencies;
    }

    // getters and setters for WordsList Class
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getWords() {
        return words;
    }

    public void setWords(String[] words) {
        this.words = words;
    }

    public void setAllWords(String[] allWords) {
        this.wordsWithDupes = allWords;
    }

    public String getWord_ByPosition(int position) {
        return words[position];
    }

    public boolean isFound_ByWord(String word, String text) {
        return count_ByWord(word, text);
    }

    public int[] getFrequencies() {
        return frequencies;
    }

    public int getFrequency() {
        return frequency;
    }
}

class SortedLists {
    String[] words = new String[] {};
    int[] frequencies = new int[] {};

    WordLists wordsList = new WordLists();

    void sortArrays(String[] words, int[] frequencies) {
        // frequencies = frequenciesList.enlistFrequencies(text);
        for (int i = 0; i < frequencies.length; i++) {
            for (int j = 0; j < frequencies.length; j++) {
                if (frequencies[i] > frequencies[j]) {
                    int temp = frequencies[i];
                    frequencies[i] = frequencies[j];
                    frequencies[j] = temp;
                    String wordTemp = words[i];
                    words[i] = words[j];
                    words[j] = wordTemp;
                }
            }
        }
        this.frequencies = frequencies;
        this.words = words;
    }

    // getters and setters for ListsConnection Class
    public int[] getFrequencies() {
        return frequencies;
    }

    public String[] getWords() {
        return words;
    }
}
