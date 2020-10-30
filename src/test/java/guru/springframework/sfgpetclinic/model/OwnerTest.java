package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.CustomArgsProvider;
import guru.springframework.sfgpetclinic.ModelTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class OwnerTest implements ModelTest {

    @Test
    void dependentAssertions() {

        Owner owner = new Owner(1l, "Joe", "Buck");
        owner.setCity("Key West");
        owner.setTelephone("1231231234");

        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Joe", owner.getFirstName(), "First Name Did not Match"),
                        () -> assertEquals("Buck", owner.getLastName())),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Key West", owner.getCity(), "City Did Not Match"),
                        () -> assertEquals("1231231234", owner.getTelephone())
                ));

        assertThat(owner.getCity(), is("Key West"));
    }

    @DisplayName("parameterized test")
    @ParameterizedTest(name = "[{index}] {arguments} - {displayName}")
    @ValueSource(strings = {"ana", "are", "mere"})
    void testValueSource(String val){
        System.out.println(val);
    }

    @DisplayName("enum source test")
    @ParameterizedTest(name = "[{index}] {arguments} - {displayName}")
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType ownerType){
        System.out.println(ownerType);
    }

    @DisplayName("CSV input source test")
    @ParameterizedTest(name = "[{index}] {arguments} - {displayName}")
    @CsvSource({
            "FL, 1, 1",
            "OH, 2, 2",
            "MI, 1, 2"
    })
    void csvInputTest(String stateName, int val1, int val2){
        System.out.println(stateName + " = " + val1 + " + " + val2);
    }

    @DisplayName("CSV file input source test")
    @ParameterizedTest(name = "[{index}] {arguments} - {displayName}")
    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    void csvFileInputTest(String stateName, int val1, int val2){
        System.out.println(stateName + " = " + val1 + " + " + val2);
    }

    @DisplayName("method provider test")
    @ParameterizedTest(name = "[{index}] {arguments} - {displayName}")
    @MethodSource("getargs")
    void methodProviderTest(String stateName, int val1, int val2){
        System.out.println(stateName + " = " + val1 + " + " + val2);
    }

    static Stream<Arguments> getargs() {
        return Stream.of(
                Arguments.of("FL", 1, 1),
                Arguments.of("OH", 1, 1),
                Arguments.of("MI", 1, 1));

    }

    @DisplayName("class provider test")
    @ParameterizedTest(name = "[{index}] {arguments} - {displayName}")
    @ArgumentsSource(CustomArgsProvider.class)
    void classProviderTest(String stateName, int val1, int val2){
        System.out.println(stateName + " = " + val1 + " + " + val2);
    }


}