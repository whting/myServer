import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class IdeaDemo {

    public static void ideaForx() {
        String[] args = {};
        List ls = new ArrayList();

        // foreach
        for (String arg :
                args) {

        }

        // fori
        for (int i = 0; i < 10; i++) {

        }
    }

    public static void ideaItxx() {
        String[] args = {};
        List ls = new ArrayList();

        // iter
        for (String arg : args) {

        }

        // itar
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];

        }

        // itls
        for (int i = 0; i < ls.size(); i++) {
            Object o = ls.get(i);

        }

        // itit
        Iterator iterator = ls.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();

        }

        // itvo
        Vector vector = new Vector();
        for (int i = 0; i < vector.size(); i++) {
            Object elementAt = vector.elementAt(i);

        }
    }

    public static void main(String[] args) {
        ideaItxx();
    }

}
