package io.github.ruvesh.powerofgman;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test Class accepts sample input files with test cases and asserts the results with the output printed to the standard output stream
 * @author ruvesh
 * @since 1.0
 */
class PowerOfGmanTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setErr(standardOut);
    }

    @Test
    void shouldHavePower145WhenSourceIs14NAndDestinationIs46() {
        PowerOfGman.main(new String[]{"src/test/resources/sample_input/input1.txt"});
        assertEquals("POWER 145",
                outputStreamCaptor.toString().trim());
    }


    @Test
    void shouldHavePower155WhenSourceIs21EAndDestinationIs43() {
        PowerOfGman.main(new String[]{"src/test/resources/sample_input/input2.txt"});
        assertEquals("POWER 155",
                outputStreamCaptor.toString().trim());
    }


    @Test
    void shouldHavePower90WhenSourceIs05WAndDestinationIs61() {
        PowerOfGman.main(new String[]{"src/test/resources/sample_input/input3.txt"});
        assertEquals("POWER 90",
                outputStreamCaptor.toString().trim());
    }

    @Test
    void shouldHavePower110WhenSourceIs36NAndDestinationIs10() {
        PowerOfGman.main(new String[]{"src/test/resources/sample_input/input4.txt"});
        assertEquals("POWER 110",
                outputStreamCaptor.toString().trim());
    }

    @Test
    void shouldHavePower140WhenSourceIs14SAndDestinationIs46() {
        PowerOfGman.main(new String[]{"src/test/resources/sample_input/input5.txt"});
        assertEquals("POWER 140",
                outputStreamCaptor.toString().trim());
    }

    @Test
    void shouldHavePower180WhenSourceIs11SAndDestinationIs12() {
        PowerOfGman.main(new String[]{"src/test/resources/sample_input/input6.txt"});
        assertEquals("POWER 180",
                outputStreamCaptor.toString().trim());
    }

    @Test
    void shouldHavePower170WhenSourceIs31WAndDestinationIs51() {
        PowerOfGman.main(new String[]{"src/test/resources/sample_input/input7.txt"});
        assertEquals("POWER 170",
                outputStreamCaptor.toString().trim());
    }
}