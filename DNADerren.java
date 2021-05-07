import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DNADerren {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String dna = br.readLine();
        br.close();
        if (dna.length() == 1) {
            System.out.println(dna);
            return;
        }
        StringBuilder sb = new StringBuilder();
        char[] c = dna.toCharArray();
        boolean[] vowels = new boolean[256];
        vowels['a'] = vowels['e'] = vowels['i'] = vowels['o'] = vowels['u'] = true;
        vowels['A'] = vowels['E'] = vowels['I'] = vowels['O'] = vowels['U'] = true;
        int i = 0;
        int previousSPlitPoint = 0;
        for (i = 0; i < c.length-1; i++) {
            if (vowels[c[i]] && vowels[c[i+1]] || !vowels[c[i]] && !vowels[c[i+1]]) {
                sb.append(dna.substring(previousSPlitPoint, i+1)).append(" ");
                previousSPlitPoint = i+1;
            }
        }
        sb.append(dna.substring(previousSPlitPoint, c.length));

        String s = new String(sb);
        System.out.println(s.trim());
    }

    public static int canGrowWindow(char[] c, int i, boolean[] vowels) {
        if (i+1 >= c.length) {
            return c.length;
        }
         boolean isVowel = vowels[c[i]];
        if (isVowel) {
            if (vowels[c[i+1]]) {
                return i+1;
            }
            int j = i+1;
                while (j < c.length-1 && !vowels[c[j]] && vowels[c[j+1]]) {
                    j+=1;
//                    if (j == c.length - 1) return j;
                }
                return j+1;

        }
        else if (!isVowel) {
            if (!vowels[c[i+1]]) {
                return i+1;
            }
            int j = i+1;
                while (j < c.length-1 && vowels[c[j]] && !vowels[c[j+1]]) {
                    j+=1;
//                    if (j == c.length - 1) return j;
                }
                return j+1;
        }
        return i+1;
    }
}
