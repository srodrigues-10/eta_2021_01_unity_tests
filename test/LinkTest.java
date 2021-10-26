import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkTest {

    // Massas de Dados
    private static Cidade cid1;
    private static Cidade cid2;
    private static Cidade cid3;
    private static Cidade cid4;
    private static Cidade cid5;
    private static Cidade cid6;
    private static Cidade cid7;
    private static Cidade cid8;
    private static Cidade cid9;
    private static Cidade cid10;
    private static Cidade cid11;
    private static Cidade cid12;
    private static Link lk1;
    private static Link lk2;
    private static Link lk3;
    private static Link lk4;
    private static Link lk5;
    private static Link lk6;
    private static Link lk7;

    @BeforeEach
    void InstanciaMassa(){
        cid1 = new Cidade("Olinda");
        cid2 = new Cidade("Recife");
        cid3 = new Cidade("João Pessoa");
        cid4 = new Cidade("Paulista");
        cid5 = new Cidade("Jaboatão");
        cid6 = new Cidade("Abreu e Lima");
        cid7 = new Cidade("Jaboatão");
        cid8 = new Cidade("Abreu e Lima");
        cid9 = new Cidade("Rio de Janeiro");
        cid10 = new Cidade("Petrolina");
        cid11 = new Cidade("Rio de Janeiro");
        cid12 = new Cidade("Serra Talhada");
        lk1 = new Link(cid1, cid2, 5);
        lk2 = new Link(cid3, cid4, 6);
        lk3 = new Link(cid5, cid6, 7);
        lk4 = new Link();
        lk5 = new Link(cid7, cid8, 8);
        lk6 = new Link(cid9, cid10, 9);
        lk7 = new Link(cid11, cid12, 10);
    }

    @Test
    void getTamanho() {
        assertEquals(5, lk1.getTamanho());
    }

    @Test
    void isUsado_true() {
        assertTrue(lk1.isUsado(), "Link não é usado!");
    }

    @Test
    void isUsado_false() {
        assertFalse(lk4.isUsado(), "Link já é usado!");
    }

    @Test
    void setUsado() {
        lk3.setUsado(true);
        assertTrue(lk3.isUsado(), "Link não é usado!");
        lk4.setUsado(false);
        assertFalse(lk4.isUsado(), "Link já é usado!");
        lk3.setUsado(false);
        assertFalse(lk3.isUsado(), "Link já é usado!");
        lk4.setUsado(true);
        assertFalse(lk4.isUsado(), "Link já é usado!");
    }

    @Test
    void testToString() {
        assertEquals("Olinda --> Recife", lk1.toString());
        assertEquals("Abreu e Lima --> Jaboatão", lk3.toString());
    }

    @Test
    void compareTo() {
        assertTrue(lk3.compareTo(lk5) == 0);
        assertTrue(lk1.compareTo(lk6) < 0);
        assertTrue(lk6.compareTo(lk7) < 0);
        assertTrue(lk1.compareTo(lk2) > 0);
    }
}