import java.util.Comparator;

/* Compare two cidades for use in sorting or data structures
 */ 
public class ComparadorCidade implements Comparator<Cidade> {
  /* compare cidades by their distancia from the start of the rail network
   * return: negative if c1 is closer to 0, 0 if equal distancia, positive if c2 is closer to 0
   */
  /* @description: compare cidades by their distancia from the start of the rail network
   * @param: Cidade x is the first city.
   * @param: Cidade y is the second city.
   * @return: negative if c1 is closer to 0, 0 if equal distancia, positive if c2 is closer to 0
   */
  // ----> REFATORAÇÃO: Comentário
  // ----> BUG: os parametros do return. Antes(y, x), Depois (x, y)
  public int compare(Cidade x, Cidade y) {
    return x.comparaDistancia(x,y);
  }
}
