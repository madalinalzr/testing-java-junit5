package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelRepeteadTest;
import guru.springframework.sfgpetclinic.ModelTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("model")
class PersonTest implements ModelRepeteadTest {

    @Test
    void groupedAssertions() {
        //given
        Person person = new Person(10L, "Ana", "Banana");
        //then
        assertAll("Test Props Set",
                () -> assertEquals("Ana", person.getFirstName(), "First name failed"),
                () -> assertEquals("Banan", person.getLastName(),"last name failed"));
    }

    @RepeatedTest(value = 3, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
    @DisplayName("My Repetead Test")
    @Test
    void repeteadTest() {
        System.out.println("repeat Test");
    }

    @RepeatedTest(value = 5, name = "{displayName} : {currentRepetition} | {totalRepetitions}")
    @DisplayName("My Assignment Repetead Test")
    @Test
    void assignementRepeatedTest(){
        System.out.println("Another repetead test");
    }

}