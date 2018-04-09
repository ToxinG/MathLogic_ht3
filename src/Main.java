import java.io.*;

public class Main {

    private static BufferedReader reader;
    private static Writer writer;
    private static File inputFile = new File("input.txt");
    private static File outputFile = new File("output.txt");
    private static File baseFile = new File("base.txt");

    public static void main(String[] args) throws IOException {

        int a = 0;
        String stringA = "0";
        StringBuilder sb = new StringBuilder(stringA);
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
            a = Integer.valueOf(reader.readLine());
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < a; i++)
            sb.append("\'");

        stringA = sb.toString();

        try {
            writer = new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8");
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(baseFile), "UTF-8"));
            writer.write("|-(a+0')*(a+0')=(a*a)+(0''*a)+0'\n".replaceAll("a", stringA));
            String s;
            while ((s = reader.readLine()) != null)
                writer.write(s + "\n");

            writer.write("@a((a+0')*(a+0')=(a*a)+(0''*a)+0')->");
            writer.write("((a+0')*(a+0')=(a*a)+(0''*a)+0')\n".replaceAll("a", stringA));
            writer.write("((a+0')*(a+0')=(a*a)+(0''*a)+0')".replaceAll("a", stringA));
            writer.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
