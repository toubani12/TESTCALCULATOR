package badhacker;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testAdd() {
        assertEquals(5, calculator.add(2, 3), "2 + 3 should equal 5");
    }

    @Test
    void testSub() {
        assertEquals(-1, calculator.sub(2, 3), "2 - 3 should equal -1");
    }

    @Test
    void testMulti() {
        assertEquals(6, calculator.multi(2, 3), "2 * 3 should equal 6");
    }

    @Test
    void testDiv() {
        assertEquals(2, calculator.div(6, 3), "6 / 3 should equal 2");
    }

    @Test
    void testDivByZero() {
        ArithmeticException ex = assertThrows(
                ArithmeticException.class,
                () -> calculator.div(90, 0),
                "Diviser par zéro doit lancer ArithmeticException"
        );
        assertEquals("Division par zéro n'est pas autorisée", ex.getMessage());
    }

    @Test
    void testInvalidTypeHandling() {
        // On vérifie que même 0/0 lève une exception plutôt que de renvoyer NaN
        assertThrows(
                ArithmeticException.class,
                () -> calculator.div(0, 0),
                "0 / 0 doit lancer ArithmeticException"
        );
    }

    @Test
    void testUnexpectedResult() {
        // Cas volontairement incorrect pour illustrer un échec
        assertNotEquals(10, calculator.add(2, 3), "2 + 3 ne doit pas être égal à 10");
    }
}
