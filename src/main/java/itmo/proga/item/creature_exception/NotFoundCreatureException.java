package itmo.proga.item.creature_exception;

public class NotFoundCreatureException extends Exception {

    public NotFoundCreatureException() {
        super("Can't find creature");
    }

    @Override
    public String getLocalizedMessage() {
        return getMessage()+" check com.example.Main.Shorts";
    }

    public void printLocalizedMessage() {
        System.err.println(getLocalizedMessage());
    }

    @Override
    public void printStackTrace() {
        printLocalizedMessage();
        StackTraceElement[] elements = this.getStackTrace();
        for (StackTraceElement element : elements) {
            System.err.println(element.getFileName()
                    + ":" + element.getLineNumber()
                    + ">> "
                    + element.getMethodName() + "()");
        }
    }
}
