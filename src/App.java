public class App {
    public static void main(String[] args) throws Exception {
        SearchWord searchWord = new SearchWord();
        searchWord.WordsCounter();
    }
}

class SearchWord{
    //new counter parameters
    private String text = "";
    private String [] words = null;
    //old functions parameters
    private String search_word = "";
    private boolean isFound = false;
    private int word_counter = 0;
    private int text_length = text.length();
    
    // New Counter
    void WordsCounter(){
        words = text.split(" ");
        
    }

    // Old functions
    boolean search(){
        isFound = text.contains(search_word);
        word_counter();
        return isFound;
    }
    
    int word_counter(){
        for (int index = 0; index < text.length(); index++) {
            if (text.substring(index).startsWith(search_word)) {
                word_counter ++;
            }
        }
        return word_counter;      
    }
    
    // Getters and setters
    public String getSearch_word() {
        return search_word;
    }
    public String getText() {
        return text;
    }
    public boolean isFound() {
        return isFound;
    }
    public void setFound(boolean isFound) {
        this.isFound = isFound;
    }
    public void setSearch_word(String search_word) {
        this.search_word = search_word;
    }
    public void setText(String text_new) {
        this.text = text_new;
    }
    public int getWord_counter() {
        return word_counter;
    }
    public void setWord_counter(int word_counter) {
        this.word_counter = word_counter;
    }
    public int getText_length() {
        return text_length;
    }
    public String[] getWordsArray() {
        return words;
    }
    public String getWordInArray(int i) {
        return words[i];
    }
}
