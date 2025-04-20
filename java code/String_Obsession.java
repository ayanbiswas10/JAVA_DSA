import java.util.*;

public class String_Obsession{

    public static int dp(String s, List<String> v, Map<String, Integer> arr) {
        if (arr.containsKey(s)) return arr.get(s);

        int loki = 0;
        for (String x : v) {
            int pos = s.indexOf(x);

            if (pos != -1) {
                String newString = s.substring(0, pos) + s.substring(pos + x.length());
                loki = Math.max(loki, 1 + dp(newString, v, arr));
            }
        }
        arr.put(s, loki);
        return loki;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<String> substrings = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            substrings.add(scanner.next());
        }

        String mainString = scanner.next();

        Map<String, Integer> arr = new HashMap<>();

        System.out.print(dp(mainString, substrings, arr));

        scanner.close();
    }
}