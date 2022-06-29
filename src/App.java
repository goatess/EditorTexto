public class App {
    public static void main(String[] args) throws Exception {
    }
}

class SearchWord{
    private String search_word = "";
    private String text = "";
    private boolean isFound = false;
    private int word_counter = 0;
    
    
    boolean search(){
        isFound = text.contains(search_word);
        word_counter();
        return isFound;
    }
    
    int word_counter(){
        for (int i = 0; i < text.length(); i++) {
            if (text.substring(i).startsWith(search_word)) {
                word_counter ++;
            }
        }
        return word_counter;
        
    }

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
public void setText(String text) {
    this.text = text;
}
public int getWord_counter() {
    return word_counter;
}
public void setWord_counter(int word_counter) {
    this.word_counter = word_counter;
}
}
