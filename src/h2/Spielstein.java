package h2;

public class Spielstein {
    private int currentRow;
    private int currentCol;
    private Spielbrett brett;

    public Spielstein(Spielbrett brett, int indexRow, int indexCol) {
        this.brett = brett;
        this.currentRow = indexRow;
        this.currentCol = indexCol;
    }

    private boolean movesOut() {

        Feld aktuellesFeld = brett.getBrett()[currentRow][currentCol];
        char dir = aktuellesFeld.getDirection();
        int dim = brett.getDim();

        switch (dir) {
            case 'U':
                return currentRow - 1 < 0;
            case 'D':
                return currentRow + 1 >= dim;
            case 'L':
                return currentCol - 1 < 0;
            case 'R':
                return currentCol + 1 >= dim;
            default:
                return false;
        }
    }


    public void go(int n) {
        for (int i = 0; i < n; i++) {
            Feld aktuellesFeld = brett.getBrett()[currentRow][currentCol];

            if (aktuellesFeld.isBoese()) {
                continue;
            }

            char dir = aktuellesFeld.getDirection();

            if (movesOut()) {
                continue;
            }

            switch (dir) {
                case 'U':
                    currentRow -= 1;
                    break;
                case 'D':
                    currentRow += 1;
                    break;
                case 'L':
                    currentCol -= 1;
                    break;
                case 'R':
                    currentCol += 1;
                    break;
            }
        }
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public void setCurrentCol(int currentCol) {
        this.currentCol = currentCol;
    }

    public Spielbrett getBrett() {
        return brett;
    }

    public void setBrett(Spielbrett brett) {
        this.brett = brett;
    }

}
