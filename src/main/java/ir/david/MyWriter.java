package ir.david;

import ir.david.model.Person;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * @author Davood Akbari - 1399
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */
public class MyWriter implements ItemWriter<Person> {
    @Override
    public void write(List<? extends Person> list) throws Exception {
        for (Person person: list) {
            System.out.println(person.getName());
        }
    }
}
