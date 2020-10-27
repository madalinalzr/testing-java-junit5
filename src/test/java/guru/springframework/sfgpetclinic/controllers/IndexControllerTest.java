package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @Test
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), "wrong");
        assertEquals("indexd", controller.index(), () -> "Another wrong message");

    }

    @Test
    void oupsHandler() {
        assertTrue("asdf".equals(controller.oupsHandler()), () -> "This is some expensive" +
                "Message to build +" +
                "for my test");
    }
}