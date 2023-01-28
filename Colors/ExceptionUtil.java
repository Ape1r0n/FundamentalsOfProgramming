package Colors;

/**
 * Pre-defined class, no grading inside this class!!!
 * <p>
 * Please do not modify!
 */
public class ExceptionUtil {

    /**
     * Use this to end a method or constructor abruptly (by throwing an exception)
     *
     * @param message the message that the exception contains, choose something that
     *                everyone can understand to help them finding the root of the
     *                problem
     */
    public static void unsupportedOperation(String message) {
        throw new UnsupportedOperationException(message);
    }
}