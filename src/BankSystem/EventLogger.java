package BankSystem;

/*
 * Class of processing event messages
 */
public class EventLogger implements Logger{

    /*
     * Method shows an event into console
     */
    @Override
    public void Log(String event){
        System.out.println(event);
    }
}
