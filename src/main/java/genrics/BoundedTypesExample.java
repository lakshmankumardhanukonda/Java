package genrics;

import java.io.Externalizable;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Collection;

public class BoundedTypesExample {

    public< T extends InputStream> void read(final T stream ) {
        // Some implementation here
    }

    public< T extends Serializable> void store(final T object ) {
        // Some implementation here
    }

    public< T, J extends T > void action( final T initial, final J next ) {
        // Some implementation here
    }

    public< T extends InputStream & Serializable > void storeToRead( final T stream ) {
        // Some implementation here
    }
    public< T extends Serializable & Externalizable & Cloneable > void persist(final T object ) {
        // Some implementation here
    }

    public void store( final Collection< ? extends Serializable > objects ) {
        // Some implementation here
    }

    public void anotherStore( final Collection< ? > objects ) {
        // Some implementation here
    }

    public void interate( final Collection< ? super Integer > objects ) {
        // Some implementation here
    }

    public< T > void performAction( final T action, final Class< T > clazz ) {
        // Some implementation here
    }


}
