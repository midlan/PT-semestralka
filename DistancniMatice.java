/**
 * Vytvoří z matice sousednosti distanční matici. 
 * @author Kate
 */
public class DistancniMatice {
    int matice[][];
    
    public DistancniMatice(int[][] maticeSousednosti){
        int[][] pripravenaMatice=pripravMatici(maticeSousednosti);
        this.matice=floydWarshall(pripravenaMatice);
    }
    
    /**
     * Pripravi matici na floyd-warshalla. Když mezi sebou města nemají uzel. 
     * Musi se dát do příslušného políčka nekonečno (Integer.MAX_VALUE).
     * @param matice matice, kterou musime upravit.
     * @return matice již upravena matice.
     * 
     */
    private static int[][] pripravMatici(int[][] matice){
        for(int i=0;i<matice.length;i++){
            for(int j=0;j<matice.length;j++){
                if(matice[j][i] == 0){
                    matice[j][i]=Integer.MAX_VALUE;
                }
            }
        }
        return null;
    }
    
    /**
     * Floyd-Warshall algorithm. Finds all shortest paths among all pairs of nodes
     * @param d matrix of distances (Integer.MAX_VALUE represents positive infinity)
     * @return matrix of predecessors
     */
    private static int[][] floydWarshall(int[][] d) {
        int[][] p = constructInitialMatixOfPredecessors(d);
        for (int k = 0; k < d.length; k++) {
            for (int i = 0; i < d.length; i++) {
                for (int j = 0; j < d.length; j++) {
                    if (d[i][k] == Integer.MAX_VALUE || d[k][j] == Integer.MAX_VALUE) {
                        continue;                  
                    }

                    if (d[i][j] > d[i][k] + d[k][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                        p[i][j] = p[k][j];
                    }
                }
            }
        }
        return p;
    }

    /**
     * Constructs matrix P0
     * @param d matrix of lengths
     * @return P0
     */
    private static int[][] constructInitialMatixOfPredecessors(int[][] d) {
        int[][] p = new int[d.length][d.length];
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d.length; j++) {
                if (d[i][j] != 0 && d[i][j] != Integer.MAX_VALUE) {
                    p[i][j] = i;
                } else {
                    p[i][j] = -1;
                }
            }
        }
        return p;
    }

}
