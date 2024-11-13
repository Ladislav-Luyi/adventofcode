
import java.util.ArrayList;
import java.util.List;

//https://stackoverflow.com/questions/44949030/print-all-possible-permutations-of-r-elements-in-a-given-integer-array-of-size-n
public class AllCombination {

    public static List<List<String>> choose(List<String> a, int k) {
        List<List<String>> allPermutations = new ArrayList<>();
        enumerate(a, a.size(), k, allPermutations);
        return allPermutations;
    }

    // a is the original array
    // n is the array size
    // k is the number of elements in each permutation
    // allPermutations is all different permutations
    private static void enumerate(List<String> a,
                                  int n,
                                  int k,
                                  List<List<String>> allPermutations) {
        if (k == 0) {
            List<String> singlePermutation = new ArrayList<>();
            for (int i = n; i < a.size(); i++) {
                singlePermutation.add(a.get(i));
            }
            allPermutations.add(singlePermutation);
            return;
        }
        for (int i = 0; i < n; i++) {
            swap(a, i, n - 1);
            enumerate(a, n - 1, k - 1, allPermutations);
            swap(a, i, n - 1);
        }
    }

    // helper function that swaps a.get(i) and a.get(j)
    public static void swap(List<String> a, int i, int j) {
        String temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }

}
