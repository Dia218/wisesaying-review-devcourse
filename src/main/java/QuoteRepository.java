import java.util.List;

public interface QuoteRepository {
    abstract int addQuote(String author, String content) ;
    
    public void removeQuote(Quote quote);
    
    public void updateQuote(Quote quote, String author, String content);
    
    public List<String> selectQuote();
    
    public void saveQuotes();
}
