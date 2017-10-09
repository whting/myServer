public class BitTest {
    public static void main(String[] args) {
        String processNode = "DZ";
        StringBuffer sb = new StringBuffer(processNode);
        for (int i = 0; i < sb.length(); i++) {
            System.out.println(sb.charAt(i));
        }
    }
}
