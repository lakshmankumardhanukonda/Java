package genrics;

public class GenericClassImplementingGenericInterface<T> implements GenericInterfaceOneType<T> {
    @Override
    public void performAction(T action) {

    }

    @Override
    public <T, R> R performAnotherAction(T action) {
        return null;
    }
}
