package genrics;

public interface GenericInterfaceOneType<T> {
    void performAction( final T action );

    <T,R> R performAnotherAction(final T action);
}
