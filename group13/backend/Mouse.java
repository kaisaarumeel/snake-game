package group13.backend;

public class Mouse {

    private Integer row;
    private Integer col;
    public Mouse(Integer row, Integer column) {
        this.col = column;
        this.row = row;
    }

    private Integer getRows() {
        return row;
    }

    private void setRows(Integer row) {
        this.row = row;
    }

    private Integer getColumn() {
        return col;
    }

    private void setCols(Integer col) {
        this.col = col;
    }
}
