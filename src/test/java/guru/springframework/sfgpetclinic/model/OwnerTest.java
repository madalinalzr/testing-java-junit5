package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @Test
    void dependentAssertion(){
        Owner owner = new Owner(1L, "Tom", "Jerry");
        owner.setCity("Galatz");
        owner.setTelephone("1231231234");

        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("test", owner.getFirstName()),
                        () -> assertEquals("test", owner.getLastName())),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("test", owner.getCity()),
                        () -> assertEquals("test", owner.getTelephone()));
    }
}