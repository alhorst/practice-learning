package exceptions;

public class CapitalTException extends Exception {

    public CapitalTException() {
        super("There is a capital T at the beginning of this file.");
    }
}
