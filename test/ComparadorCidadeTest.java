import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComparadorCidadeTest {

    // Massas de Dados
    private static Cidade cid1;
    private static Cidade cid2;
    private static Cidade cid3;
    private static Cidade cid4;
    private static Cidade cid5;
    private static Cidade cid6;

    @BeforeEach
    void InstanciaMassa(){
        cid1 = new Cidade("Olinda");
        cid2 = new Cidade("Recife");
        cid3 = new Cidade("João Pessoa");
        cid4 = new Cidade("Paulista");
        cid5 = new Cidade("Jaboatão");
        cid6 = new Cidade("Abreu e Lima");
    }

    @Test
    void compare() {
        cid1.distancia = 5;
        cid2.distancia = 3;
        cid3.distancia = 10;
        cid4.distancia = 10;

        ComparadorCidade compCidade = new ComparadorCidade();

        assertEquals(0, compCidade.compare(cid3, cid4));
        assertTrue(compCidade.compare(cid1, cid2) > 0, "Cidade2 não é mais próximo do ponto 0(Trem) com relaçao ao Cidade1.");
        assertTrue(compCidade.compare(cid2, cid1) < 0, "Cidade1 não é mais próximo do ponto 0(Trem) com relaçao ao Cidade2.");
    }
}