package h1;

public class Cell {
    private int indexRow;
    private int indexCol;
    private int numLivingNeighbors;

    private boolean alive;
    private boolean isAliveNextGen;

    public Cell(int indexRow, int indexCol, boolean alive) {
        this.indexRow = indexRow;
        this.indexCol = indexCol;
        this.alive = alive;
    }

    public Cell(int indexRow, int indexCol) {
        this.indexRow = indexRow;
        this.indexCol = indexCol;
    }

    public void countLivingNeighbors(Cell[][] gridArray) {
        int temp = 0;
        for (int s = indexRow - 1; s <= indexRow + 1; s++) {
            for (int t = indexCol - 1; t <= indexCol + 1; t++) {
                if (s >= 0 && t >= 0 && s < gridArray.length && t < gridArray[0].length) {
                    if (!(s == indexRow && t == indexCol)) {
                        if (gridArray[s][t].isAlive()) {
                            temp++;
                        }
                    }
                }
            }
        }
        this.numLivingNeighbors = temp;
        this.decideNextStatus();
    }

    private void decideNextStatus() {
        this.isAliveNextGen = false;

        if (isAlive()) {
            if (this.numLivingNeighbors == 3 || this.numLivingNeighbors == 2) {
                this.isAliveNextGen = true;
            }
        } else if (this.numLivingNeighbors == 3) {
            this.isAliveNextGen = true;
        }
    }


    public int getIndexRow() {
        return indexRow;
    }

    public void setIndexRow(int indexRow) {
        this.indexRow = indexRow;
    }

    public int getIndexCol() {
        return indexCol;
    }

    public void setIndexCol(int indexCol) {
        this.indexCol = indexCol;
    }

    public boolean isAliveNextGen() {
        return isAliveNextGen;
    }

    public void setAliveNextGen(boolean aliveNextGen) {
        isAliveNextGen = aliveNextGen;
    }

    public int getNumLivingNeighbors() {
        return numLivingNeighbors;
    }

    public void setNumLivingNeighbors(int numLivingNeighbors) {
        this.numLivingNeighbors = numLivingNeighbors;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }


}
