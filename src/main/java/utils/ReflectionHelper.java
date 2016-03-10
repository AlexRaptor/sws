package utils;


import java.lang.reflect.Field;

/**
 * Created by raptor on 10.03.16.
 */
public class ReflectionHelper
{
    public static Object createInstance( String className ) throws ClassNotFoundException, IllegalAccessException, InstantiationException
    {
        return Class.forName( className ).newInstance();
    }

    public static void setFieldValue(Object object, String fieldName, String value) throws NoSuchFieldException, IllegalAccessException
    {
        Field field = object.getClass().getDeclaredField( fieldName );
        field.setAccessible( true );

        if( field.getType().equals( String.class ) )
        {
            field.set( object, value );
        }
        else if( field.getType().equals( int.class ) )
        {
            field.set( object, Integer.decode( value ) );
        }

        field.setAccessible( false );
    }
}
