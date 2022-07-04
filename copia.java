public class copia {
    
}
class ListsConnection {
    int[] frequencies = new int[] { 12, 3, 5, 21, 4, 85, 6, 9, 2, 1 };
    String[] words = new String[] {};

    WordsList wordsList = new WordsList();
    FrequenciesList frequenciesList = new FrequenciesList();

    void sortArrays(String[]words , int[]frequencies) {
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
        System.out.println("\nAfter Sorting...");
        for (int i : frequencies) {
            System.out.print(i + " ");
        }
        for (String i : words) {
            System.out.print(i + " ");
        }


    }

    // getters and setters for ListsConnection Class

    public int[] getFrequenciesSorted(String text) {
        return frequencies;
    }

    public String[] getWordsSorted(String text) {
        return words;
    }

}
