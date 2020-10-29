package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("model")
class PersonTest implements ModelTest {

    @Test
    void groupedAssertions() {
        //given
        Person person = new Person(10L, "Ana", "Banana");
        //then
        assertAll("Test Props Set",
                () -> assertEquals("Aa", person.getFirstName(), "First name failed"),
                () -> assertEquals("Banan", person.getLastName(),"last name failed"));
    }

    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
    @DisplayName("My Repetead Test")
    @Test
    void repeteadTest() {
        System.out.println("repeat Test");
    }
}