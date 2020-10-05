package BankSystem;

/*
 * Class created to provide
 * a healthy Dependency
 * Inversion principle
 */
public interface Logger {

    /*
     * Method processes an input event message
     */
    void Log(String event);
}
