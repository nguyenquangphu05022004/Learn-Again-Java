package customannotation;

public class JsonSerializationException extends RuntimeException{
    private static final long serialVersionID = 1L;
    public JsonSerializationException(String message) {
        super(message);
    }
}
