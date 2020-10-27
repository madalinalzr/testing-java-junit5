package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void groupedAssertions() {
        //given
        Person person = new Person(10L, "Ana", "Banana");
        //then
        assertAll("Test Props Set",
                () -> assertEquals("Aa", person.getFirstName(), "First name failed"),
                () -> assertEquals("Banan", person.getLastName(),"last name failed"));
    }
}