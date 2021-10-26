
/* @description: Classe que trata da construção de links entre as cidades
 */
// -----> REFATORAÇÃO: Ajuste no comentário, com a inclusão do @description
public class Link implements Comparable<Link> {
  public Cidade cidade1;
  public Cidade cidade2;
  public int tamanho;
  public boolean usado = false;


  /* @description: Construct cria um Link entre a primeiracidade e a segunda cidade com um tamanho "tamanho"
   *               As cidades são comparadas alfabeticamente e criadas no link em ordem alfabética
   *               o link é criado entre as cidades
   * @param: Cidade c1 é a primeira cidade.
   * @param: Cidade c2 é a segunda cidade.
   * @param: int tam é o tamanho entre duas cidades
   */
  // ----> REFATORAÇÃO: Comentário
  // ----> REFATORAÇÃO: Identando a linha 33 "usado = true;" pois estava recuado a direita indevidamente.
  public Link(Cidade c1, Cidade c2, int tam) {
    if (c1.comparaNome(c2) < 0) {
      cidade1 = c1;
      cidade2 = c2;
    } else {
      cidade1 = c2;
      cidade2 = c1;
    }
    tamanho = tam;
    c1.addLink(this);
    c2.addLink(this);
    usado = true;
  }

  /* @description: Construct cria um Link vazio.
   */
  // ----> REFATORAÇÃO: Comentário
  // ----> BUG. Necessário a criação desse constutor para testar o retorno false do método IsUsado().
  public Link(){
  }

  /* @description: retorna o tamanho de um link entre duas cidades.
   * @return: tamanho
   */
  // ----> REFATORAÇÃO: Comentário
  public int getTamanho() {
    return tamanho;
  }

  /* @description: retorna true se o link entre duas cidades existir
   * @return: usado
   */
  // ----> REFATORAÇÃO: Comentário
  public boolean isUsado() {
    return usado;
  }

  /* @description: retorna o valor do atributo "usado"
   * @return: Bollean usado
   */
  // ----> REFATORAÇÃO: Comentário
  // ----> REFATORAÇÃO: A correção do bug tbm serve como uma refatoração do código, para limpar o link.
  // ----> BUG -> Ao setar "Usado" como false, é necessário remover o link correspondente entre as cidades. Isso não está ocorrendo no momento.
  public void setUsado(boolean u) {
    if (cidade1 != null && cidade2 != null) {
      if(!u){
        this.cidade1.removeLink(this);
        this.cidade2.removeLink(this);
        this.cidade1 = null;
        this.cidade2 = null;
        this.tamanho = 0;
        usado = u;
      } else {
        System.out.println("Nenhuma ação foi realizada! Este link possui cidades associadas, nessas condiçoes o link sempre estará com flag 'Usado' = True!");
      }
    } else {
      System.out.println("Nenhuma ação foi realizada! Este link não possui cidades associadas, nessas condiçoes o link sempre estará com flag 'Usado' = false!");
    }
  }

  /* @description: Link entre cidades
   * @param: vazio
   * @return: retorna uma string com a descrição de um Link entre cidades
   *          exemplo "Cidade1 --> Cidade2"
   *          O nome das cidades tem de vir em ordem alfabética, exemplo, Olinda vem antes de Recife
   */
  // ----> REFATORAÇÃO (comentário padrão e informação que é exibida no console, com a inclusão do "-->")
  // ----> REFATORAÇÃO (Código Identado)
  public String toString() {
    return cidade1.toString() + " --> " + cidade2.toString();
  }

  /* @description: Compara dois links para saber se são o mesmo caminho
   * @param: l - link
   * @return: retorna 0 se os links tiverem as mesmas cidade1 e cidade2
   *          retorna negativo se this.cidade1 < l.cidade1 ou se cidade1 é igual nos dois links e this.cidade2 < l.cidade2
   *          retorna positivo caso contrário
   */
  // -----> REFATORAÇÃO: comentário padrão
  // -----> BUG: Não está comparando as duas cidades. A comparação estava sendo feita apenas com a cidade1.
  public int compareTo(Link l) {
    int valorNeg = -1;
    int valorPos = 1;
    int difCidade1 = this.cidade1.comparaNome(l.cidade1);
    int difCidade2 = this.cidade2.comparaNome(l.cidade2);
    if (difCidade1 == 0 && difCidade2 == 0) {
      return 0;
    } else if (difCidade1 < 0 || (difCidade1 == 0 && difCidade2 < 0)) {
      return valorNeg;
    } else {
      return valorPos;
    }
  }
}
