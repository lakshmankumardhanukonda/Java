package genrics;

public class GenricMethodsExample<T> {

    public GenricMethodsExample( final T initialAction ) {

    }
    public< J > GenricMethodsExample( final T initialAction, final J nextAction ) {

    }

    public<T,R> R performAction(T action) {
        R result = null;
        return result;
    }

    public static<T,R> R performStaticAction(T action) {
        R result = null;
        return result;
    }

    public< R > R performActionDifferentAction( final T action ) {
        final R result = null;
        return result;
    }
    public< U, R > R performAnotherAction( final U action ) {
        final R result = null;
        return result;
    }
}
