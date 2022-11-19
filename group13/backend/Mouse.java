package group13.backend;

public class Mouse {

    private int row;
    private int column;

    public Mouse(int row, int column){
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public void setRow (int newRow) {
        this.row = row;
    }

    public void setColumn(int newColummn) {
        this.column = newColummn;
    }
}