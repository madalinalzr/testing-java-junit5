package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

@Tag("repeatead")
public interface ModelRepeteadTest {

    @BeforeEach
    default void setUp(TestInfo testInfo) {
        System.out.println("before " + testInfo.getDisplayName() + " repetition");
    }
}
