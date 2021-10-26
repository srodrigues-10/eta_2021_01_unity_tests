import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CidadeTest {

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
    void encontrar_true() {
        Cidade cid = Cidade.encontrar("Olinda");
        assertEquals("Olinda", cid.nome);
    }

    @Test
    void encontrar_false() {
        Cidade cid = Cidade.encontrar("Caruaru");
        assertEquals("Caruaru", cid.nome);
    }

    @Test
    void addLink() {
        Link lk = new Link(cid4, cid5, 5);
        cid4.addLink(lk);
        assertTrue(lk.isUsado(), "Não existe link associado!");
    }

    @Test
    void removeLink() {
        Link lk = new Link(cid4, cid5, 5);
        cid4.removeLink(lk);
        cid5.removeLink(lk);
        assertTrue(cid4.links.isEmpty(), "Link associado a cidade 4 não está vazio!");
        assertTrue(cid5.links.isEmpty(), "Link associado a cidade 5 não está vazio!");
    }

    @Test
    void comparaNomeIgual() {
        // Valores iguais
        int compCidade1 = cid1.comparaNome(cid1);
        assertEquals(0, compCidade1, "Nome das cidades não são iguais!");

        // Valor da cidade 1 é menor alfabeticamente da cidade 2.
        int compCidade2 = cid1.comparaNome(cid2);
        assertTrue(compCidade2 < 0, "Cidade 1 não é menor alfabeticamente que a cidade 2!");

        // Valor da cidade 2 é maior alfabeticamente da cidade 1.
        int compCidade3 = cid2.comparaNome(cid1);
        assertTrue(compCidade3 > 0, "Cidade 2 não é maior alfabeticamente que a cidade 1!");
    }

    @Test
    void testToString() {
        assertEquals("Recife", cid2.toString());
    }

    @Test
    void comparaDistancia() {
        cid1.distancia = 5;
        cid2.distancia = 3;
        cid3.distancia = 10;
        cid4.distancia = 10;

        assertEquals(0, Cidade.comparaDistancia(cid3, cid4));
        assertTrue(Cidade.comparaDistancia(cid1, cid2) > 0, "Cidade2 não é mais próximo do ponto 0(Trem) com relaçao ao Cidade1.");
        assertTrue(Cidade.comparaDistancia(cid2, cid1) < 0, "Cidade1 não é mais próximo do ponto 0(Trem) com relaçao ao Cidade2.");
    }
}