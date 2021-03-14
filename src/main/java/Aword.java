public class Aword {
    private String value;
    private int row;
    private int col;

    public Aword(String s, int r, int c) {
        value = s;
        row = r;
        col = c;
    }

    public static void swap(char[] str, int i, int j) {
        char t = str[i];
        str[i] = str[j];
        str[j] = t;
    }

    public Aword rev() {
        char[] str = value.toCharArray();
        int len = str.length;
        for (int i = 0; i * 2 < len; i++) {
            if (str[i] < str[len - 1 - i]) {
                break;
            }
            else if (str[i] > str[len - 1 - i]) {
                while (i * 2 < len) {
                    swap(str, i, len - 1 - i);
                    i++;
                }
                value = String.valueOf(str);
                break;
            }
        }
        return this;
    }

    public Aword mergec(Aword ano) {
        value = value.concat(ano.getValue());
        return this;
    }

    public Aword mergec(String s) {
        value = value.concat(s);
        return this;
    }

    public Aword delct() {
        value = value.substring(0, value.length() - 1);
        return this;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public String getValue() {
        return value;
    }
}
