import singletone.Singleton;

/**
 * @author NSA Studios
 * @name  SingletoneClass Main method
 * @date 8/7/2024
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        System.out.println("Instance 1: " + instance1.hashCode());
        System.out.println("Instance 2: " + instance2.hashCode());
    }
}