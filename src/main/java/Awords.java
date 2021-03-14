import java.util.ArrayList;

public class Awords {
    private ArrayList<Integer> rows;
    private ArrayList<Integer> cols;
    private int len;

    public Awords(int r, int c) {
        rows = new ArrayList<Integer>();
        cols = new ArrayList<Integer>();
        len = 0;
        addin(r, c);
    }

    public Awords addin(int r, int c) {
        rows.add(r);
        cols.add(c);
        len++;
        return this;
    }

    public ArrayList<Integer> getCols() {
        return cols;
    }

    public ArrayList<Integer> getRows() {
        return rows;
    }

    public int getLen() {
        return len;
    }
}
