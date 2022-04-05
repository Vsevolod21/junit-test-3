import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PersonsCounterTest {
    PersonsCounter personsCounter;
    Collection<Person> persons;

    @BeforeAll
    static void start() {
        System.out.println("Старт тестирования");
    }

    @BeforeEach
    void setUp() {
        personsCounter = new PersonsCounter();
        persons = new ArrayList<>();
        persons.add(new Person("Petya", "Morozov", 17, Sex.MAN, Education.ELEMENTARY));
        persons.add(new Person("Vasya", "Pavlov", 26, Sex.MAN, Education.SECONDARY));
        persons.add(new Person("Kolya", "Pupkin", 68, Sex.MAN, Education.FURTHER));
        persons.add(new Person("Masha", "Morozova", 58, Sex.WOMAN, Education.HIGHER));
        persons.add(new Person("Anya", "Smirnova", 35, Sex.WOMAN, Education.HIGHER));
        persons.add(new Person("Olya", "Moon", 15, Sex.WOMAN, Education.FURTHER));
    }

    @AfterEach
    void tearDown() {
        personsCounter = null;
        persons = null;
    }

    @Test
    void createListWorkableWithHigherEducation() {
        final Collection<Person> expected = new ArrayList<>();
        expected.add(new Person("Masha", "Morozova", 58, Sex.WOMAN, Education.HIGHER));
        expected.add(new Person("Anya", "Smirnova", 35, Sex.WOMAN, Education.HIGHER));

        final List<Person> result = personsCounter.createListWorkableWithHigherEducation(persons);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void createListConscript() {
        final List<String> expected = Arrays.asList("Pavlov");
        final List<String> result = personsCounter.createListConscript(persons);

        Assertions.assertEquals(expected, result);
        Assertions.assertNotNull(result);
    }

    @Test
    void counterTeens() {
        final int expected = 2;
        final long result = personsCounter.counterTeens(persons);

        Assertions.assertEquals(expected, result);
    }
}