package equalsandhashcode;/**
 * @name EqualsAndHashCodeMain
 * @author NSA Studios
 * @date 7/29/2024
 */

/**
 * @name EqualsAndHashCodeMain
 * @author NSA Studios
 * @date 7/29/2024
 */
public class EqualsAndHashCodeMain {

    public static void main(String[] args) {
        //by Default equals and hashcode contract
        Student sunny = new Student(1,"Sunny");
        Student sunnyDummy = new Student(1,"Sunny");
        Student Shridevi =   sunnyDummy;


        if(sunny.equals(sunnyDummy) ) {
            System.out.println("Both Are equals sunny and dummySunny");
        }

            if(sunny.hashCode() == sunnyDummy.hashCode() ){
                System.out.println("Both Are same hashcode for sunny and dummySunny");
            }
        if(Shridevi.equals(sunnyDummy) ) {
            System.out.println("Both Are equas same Shridevi & DummySunny");
        }
        if(Shridevi.hashCode() == sunnyDummy.hashCode() ){
            System.out.println("Both Are hashcode same   Shridevi & DummySunny");
        }
    }
}
