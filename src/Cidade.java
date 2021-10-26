import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Cidade {
  //tabela com todas as cidades por nome
  public static HashMap<String, Cidade> cidades = new HashMap<String, Cidade>();

  //nome da cidade
  public String nome;

  //link da cidade adjacente
  public final HashSet<Link> links = new HashSet<Link>();

  //menor distancia
  public int distancia;

  //menor caminho percorrido
  public Link linkPai;

  /* @description: Contrutor para criar um objeto Cidade com um nome passado por parametro.
   *               adicionado a tabela (HashMap) de cidades
   * @param: String nm é a nome da cidade.
   */
  // ----> REFATORAÇÃO: Comentário
  public Cidade(String nm) {
    nome = nm;
    cidades.put(nome, this);
  }

  /* @description: Método para encontrar uma cidade pelo nome
   *               retorna a cidade se ela existir na tabela
   *               caso contrário retorna uma nova cidade com o nome informado
   * @param: String nm é a nome da cidade.
   * @return: Cidade p
   */
  // ----> BUG: Não está aplicando a regra "caso contrário retorna uma nova cidade com o nome informado". Alterado o retorno dentro do if de "null" para "p"
  public static Cidade encontrar(String nm) {
    Cidade p = cidades.get(nm);
    if (p == null) {
      p = new Cidade(nm);
      return p;
    }
    return p;
  }

  /* @description: adiciona um link entre cidades na lista de links
   * @param: Link lnk
   */
  // ----> REFATORAÇÃO: Comentário
  public void addLink(Link lnk) {
    links.add(lnk);
  }

  /* @description: Remove um link entre cidades na lista de links
   * @param: Link lnk
   */
  // ----> REFATORAÇÃO: Comentário
  // ----> REFATORAÇÃO: Necessário a inclusão desse método para implementarmos corretamente o método Link.setUsado()
  public void removeLink(Link lnk) {
    links.remove(lnk);
  }

  /* @description: compare cidades pelos seus nomes
   *               retorna negativo se c1 for alfabeticamente anterior,
   *               0 se os nomes forem os menos,
   *               e positivo se c2 for alfabeticamente maior
   * @param: Cidade p
   */
  // ----> REFATORAÇÃO: Comentário
  // ----> BUG: Correção de BUG p.nome para this.nome
  public int comparaNome(Cidade p) {
    return this.nome.compareTo(p.nome);
  }


  /* @description: Retorna o nome da cidade
   */
  // ----> REFATORAÇÃO: Comentário
  public String toString() {
    return nome;
  }

  /* compara cidades pela sua distancia até a rede de trens (ponto 0)
   * returna negativo se c1 for mais próxima, 0 se a distancia for a mesma, e positivo se c2 for mais próxima
   */
  /* @description: Compara cidades pela sua distancia até a rede de trens (ponto 0)
   *               returna negativo se c1 for mais próxima, 0 se a distancia for a mesma, e positivo se c2 for mais próxima
   * @param: Cidade c1
   * @param: Cidade c2
   * @return: c1.distancia - c2.distancia
   */
  // ----> REFATORAÇÃO: Comentário
  // ----> REFATORAÇÃO: Deixar o método estatico pois o objeto em si não precisa ser utilizado.
  public static int comparaDistancia(Cidade c1, Cidade c2) {
    return c1.distancia - c2.distancia;
  }
}
