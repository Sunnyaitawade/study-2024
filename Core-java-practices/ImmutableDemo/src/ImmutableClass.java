/**
 * @name ImmutableClass
 * @author NSA Studios
 * @date 8/29/2024
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @name ImmutableClass
 * @author NSA Studios
 * @date 8/29/2024
 */

public final class ImmutableClass {

    private final int age;
   private final String name;
   private final List<String> hobbies;

    public ImmutableClass(int age, String name, List<String> hobbies) {
        this.age = age;
        this.name = name;
        this.hobbies = Collections.unmodifiableList(hobbies);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<String> getHobbies() {

        return new ArrayList<>(hobbies);
    }
}
