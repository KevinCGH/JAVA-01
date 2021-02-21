package homework.h01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Dog
 *
 * @author KevinChen
 * @since 21/2/2021
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dog implements Animal {
    private String name;

    @Override
    public void eat(String food) {
        System.out.println(this.name + "吃" + food + "...");
    }
}
