import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PersonsCounter {
    private Person persons;

    public PersonsCounter() {
    }

    public List<Person> createListWorkableWithHigherEducation(Collection<Person> persons) {
        List<Person> listWorkableWithHigherEducation = persons.stream()
                .filter(person -> person.getEducation() == Education.HIGHER
                        && person.getAge() >= 18 && person.getAge() <= (person.getSex() != Sex.MAN ? 60 : 65))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        listWorkableWithHigherEducation.forEach(System.out::println);
        return listWorkableWithHigherEducation;
    }

    public List<String> createListConscript(Collection<Person> persons) {
        List<String> listConscript = persons.stream()
                .filter(person -> person.getAge() >= 18 && person.getAge() < 27 && person.getSex() == Sex.MAN)
                .map(Person::getFamily)
                .collect(Collectors.toList());
        listConscript.forEach(System.out::println);
        return listConscript;
    }

    public Long counterTeens(Collection<Person> persons) {
        long countTeens = persons.stream()
                .filter(person -> person.getAge() < 18).count();
        return countTeens;
    }
}
