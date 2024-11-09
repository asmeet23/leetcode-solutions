import java.util.ArrayList;
import java.util.List;

public class Solution {
    private int n, k, v;
    private List<List<Boolean>> visited;
    private StringBuilder sequence;

    public String crackSafe(int n, int k) {
        if (k == 1) return "0".repeat(n);
        this.n = n;
        this.k = k;
        this.v = 1;
        for (int i = 0; i < n - 1; ++i) {
            this.v *= k;
        }
        this.visited = new ArrayList<>();
        for (int i = 0; i < v; ++i) {
            List<Boolean> row = new ArrayList<>();
            for (int j = 0; j < k; ++j) {
                row.add(false);
            }
            this.visited.add(row);
        }
        this.sequence = new StringBuilder();
        dfs(0);
        return sequence.toString() + sequence.substring(0, n - 1);
    }

    private void dfs(int u) {
        for (int i = 0; i < k; ++i) {
            if (!visited.get(u).get(i)) {
                visited.get(u).set(i, true);
                dfs((u * k + i) % v);
                sequence.append((char) ('0' + i));
            }
        }
    }
}