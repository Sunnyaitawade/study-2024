package singletone;/**
 * @name Singleton
 * @author NSA Studios
 * @date 8/7/2024
 */

 
import java.io.Serial;
import java.io.Serializable;

/**
 * @name Singleton
 * @author NSA Studios
 * @date 8/7/2024
 */
public class Singleton implements Serializable,Cloneable {


    @Serial
    private static final long serialVersionUID = -9100288804953104742L;

    // Volatile variable to ensure visibility of changes across threads
    //Using volatile ensures that multiple threads handle the instance variable correctly.
    private static volatile Singleton instance= null;

    // Private constructor to prevent instantiation
    //This prevents instantiation via reflection.
    private Singleton(){
        // Prevent instantiation via reflection
        if(instance != null){
            throw new IllegalStateException("Instance already created");
        }
    }

    // Public method to provide access to the instance
    public static Singleton getInstance() {
        if(instance == null){
            //This ensures that synchronization is used only when the instance is null.
           synchronized (Singleton.class) {
               if (instance == null) {
                   instance = new Singleton();
               }
           }

        }
        return instance;
    }

   //Prevent deserialization from creating a new instance
    //This ensures the same instance is returned during deserialization.
   protected Object readResolve(){
       return getInstance();
   }

    // Prevent cloning
    @Override
    protected Singleton clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException("Clone is not allowed");
    }
}
