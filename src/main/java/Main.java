import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        TreeMap<String, Awords> words = new TreeMap<>(String::compareTo);
        Scanner din = new Scanner(System.in);
        Pattern pattern = Pattern.compile("[a-zA-Z]+([\\-][a-zA-Z]*)?[\\-]?");
        Matcher matcher;
        Aword now = null;
        int linenum = 1;
        while (din.hasNext()) {
            matcher = pattern.matcher(din.nextLine());
            while (matcher.find()) {
                String rw = matcher.group().toLowerCase();
                boolean notend = rw.substring(rw.length() - 1).equals("-");
                if (now == null) {
                    if (notend) {
                        now = new Aword(rw.substring(0, rw.length() - 1),
                                linenum, matcher.start() + 1);
                    }
                    else {
                        addin(words, new Aword(rw,
                                linenum, matcher.start() + 1));
                    }
                }
                else {
                    if (notend) {
                        now = now.mergec(rw.substring(0, rw.length() - 1));
                    }
                    else {
                        now = now.mergec(rw);
                        addin(words, now);
                        now = null;
                    }
                }
            }
            linenum++;
        }
        ansout(words);
    }

    public static void ansout(TreeMap<String, Awords> words) {
        double sum = 0;
        for (String word : words.keySet()) {
            sum += words.get(word).getLen();
        }
        Iterator<String> iter = words.keySet().iterator();
        while (iter.hasNext()) {
            String word = iter.next();
            Awords list = words.get(word);
            int len = list.getLen();
            ArrayList<Integer> rows = list.getRows();
            ArrayList<Integer> cols = list.getCols();
            System.out.printf("%s %d %.2f%%",
                    word, len, (double) len / sum * 100.0);
            for (int i = 0; i < len; i++) {
                System.out.printf("\n\t(%d, %d)", rows.get(i), cols.get(i));
            }
            if (iter.hasNext()) {
                System.out.print("\n");
            }
        }
    }

    public static void addin(TreeMap<String, Awords> words, Aword word) {
        String s = word.getValue();
        if (words.containsKey(s)) {
            words.put(s, words.get(s).addin(word.getRow(), word.getCol()));
        }
        else {
            words.put(s, new Awords(word.getRow(), word.getCol()));
        }
    }
}