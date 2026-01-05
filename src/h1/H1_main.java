package h1;

public class H1_main {
    public static void main(String[] args) {

    }

    public static void printGrid(Grid g) {
        for (int i = 0; i < g.gridArray.length; i++) {
            for (int j = 0; j < g.gridArray[i].length; j++) {
                System.out.print(g.gridArray[i][j].isAlive() ? "1" : "0");
            }
            System.out.println();
        }
    }
}
