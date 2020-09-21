package ir.david;

import ir.david.model.Person;
import org.springframework.batch.item.ItemProcessor;

import java.util.List;

/**
 * @author Davood Akbari - 1399
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */
public class MyProcessor implements ItemProcessor<List<Person>, List<Person>> {


    @Override
    public List<Person> process(List<Person> people) throws Exception {
        for (Person person : people) {
            person.setName(person.getName() + "-----------------");
        }

        return people;
    }
}
