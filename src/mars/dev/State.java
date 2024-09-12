package mars.dev;

public interface State {

    void next(Operation op);
    void prev(Operation op);
    String getStatus();

}
