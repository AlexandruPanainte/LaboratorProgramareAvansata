import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.concurrent.TimeUnit;

public class MainClass {
    public static void main(String args[]) {

        long startTime = System.nanoTime();

        if (args.length < 3) {
            System.out.println("Not enough arguments. Sintax is: n k C_1,...,C_m");
            return;
        }

        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        if (k > args[2].length()) {
            System.out.println("Number K too big!");
            return;
        }

        char alphabet[] = new char[args[2].length()];
        for (int i = 0; i < args[2].length(); i++) {
            alphabet[i] = args[2].charAt(i);
        }
        int caractereAlfabet = args[2].length();

        String words[] = new String[n];

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < k; j++) {
                int random = (int) (Math.random() * caractereAlfabet);
                sb.append(alphabet[random]);
            }
            words[i] = sb.toString();
        }

        System.out.println("Generated array of words:");
        for (int i = 0; i < n; i++) {
            System.out.print(words[i] + " ");
        }
        System.out.println();
        System.out.println();

        boolean adjacent[][] = new boolean[n][n];
        boolean ok;

        for (int i = 0; i < n; i++) {
            ok = false;
            for (int j = i; j < n; j++) {
                ok = false;
                for (int c1 = 0; c1 < k && !ok; c1++) {
                    for (int c2 = 0; c2 < k && !ok; c2++) {
                        if (words[i].charAt(c1) == words[j].charAt(c2)) {
                            ok = true;
                        }
                    }
                }
                adjacent[i][j] = adjacent[j][i] = ok;
            }
        }

        int[] neighbors = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adjacent[i][j]) {
                    neighbors[i]++;
                }
                System.out.print(adjacent[i][j] + " ");
            }
            System.out.println();
        }

        int least = n;
        int most = 0;

        for (int i = 0; i < n; i++) {
            if (neighbors[i] < least) {
                least = neighbors[i];
            }
            if (neighbors[i] > most) {
                most = neighbors[i];
            }
        }


        ok = true;

        for (int i = 0; i < n - 1; i++) {
            if (neighbors[i] == neighbors[i + 1]) {
                ok = false;
            }
        }

        System.out.println();

        if (ok) {
            System.out.println("All words have the same number of neighbors!");
        } else {
            System.out.println("Words with the most neighbors are: ");
            for (int i = 0; i < n; i++) {
                if (neighbors[i] == most) {
                    System.out.println(words[i]);
                }
            }

            System.out.println();
            System.out.println("Words with the least neighbors are: ");
            for (int i = 0; i < n; i++) {
                if (neighbors[i] == least) {
                    System.out.println(words[i]);
                }
            }
        }
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;

        System.out.println("Execution time in nanoseconds: " + timeElapsed);

        int stack[] = new int[n];
        int viz[] = new int[n];

        for (int i = 0; i < n; i++) {
            viz[i] = 0;
        }

        int connectedComponent = 0;

        for (int i = 0; i < n; i++) {
            if (viz[i] == 0) {
                connectedComponent++;
                int pos = 0;
                stack[++pos] = i;
                viz[i] = connectedComponent;
                while (pos > 0) {
                    int nod = stack[pos];
                    pos--;
                    for (int j = 0; j < n; j++) {
                        if (adjacent[nod][j] && viz[j] == 0) {
                            stack[++pos] = j;
                            viz[j] = connectedComponent;
                        }
                    }
                }
            }
        }

        if (connectedComponent == 1) {
            System.out.println("The graph is connected");
        }
        for (int i = 1; i <= connectedComponent; i++) {
            System.out.print("Componenta conexa numarul " + i + " :");
            for (int j = 0; j < n; j++) {
                if (viz[j] == i) {
                    System.out.print(" " + i);
                }
            }
            System.out.println();
        }
    }
}
