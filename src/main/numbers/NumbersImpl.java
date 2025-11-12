package numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class NumbersImpl implements Numbers {

    /*
     * 1)
     * Singleton instance lazy
     */
    private static NumbersImpl instance = null;

    /**
     * 2)
     * Constructor.
     * ist private to prevent instantiation from outside the class.
     */
    private NumbersImpl() {
    }

    /**
     * 3)
     * Get the singleton instance of NumbersImpl.
     * 
     * @return instance
     */
    public static NumbersImpl getInstance() {
        if (instance == null) {
            instance = new NumbersImpl();
        }
        return instance;
    }

    @Override // 1
    public long sum(int[] numbers) {
        long summe = 0;
        for (int i = 0; i < numbers.length; i++) {
            summe += numbers[i];
        }
        return summe;
    }

    @Override // 2
    public long sum_positive_even_numbers(int[] numbers) {
        long summe = 0;
        if (numbers == null) {
            throw new IllegalArgumentException("illegal argument: null");
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0 && numbers[i] % 2 == 0) {
                summe += numbers[i];
            }
        }
        return summe;
    }

    @Override // 3
    public long sum_recursive(int[] numbers, int i) {
        int summe = 0;
        if (numbers == null) {
            throw new IllegalArgumentException("illegal argument: null");
        }
        if (i < numbers.length) {
            summe = numbers[i] + (int) sum_recursive(numbers, i + 1);
        }
        return summe;
    }

    /*
     * numbers (1,2,3,4,5)
     * len= 5
     * wenn x=4
     * return 4
     */
    @Override // 4
    public int findFirst(int[] numbers, int x) {
        if (numbers == null) {
            throw new IllegalArgumentException("illegal argument: null");
        }
        long len = numbers.length;

        for (int i = 0; i < len; i++) {
            if (numbers[i] == x) {
                return i;
            }
        }
        return -1;
    }

    @Override // 5
    public int findLast(int[] numbers, int x) {
        if (numbers == null) {
            throw new IllegalArgumentException("illegal argument: null");
        }
        int len = numbers.length;
        for (int i = len - 1; i >= 0; i--) {
            if (numbers[i] == x) {
                return i;
            }
        }
        return -1; // x not found
    }

    @Override // 6
    public List<Integer> findAll(int[] numbers, int x) {
        if (numbers == null) {
            throw new IllegalArgumentException("illegal argument: null");
        }
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == x) {
                indices.add(i);
            }
        }
        return indices; // empty list if x not found
    }

    @Override // 7
    public Set<Pair> findSums(int[] numbers, int sum) {
        return Set.of(); // Dummy-Implementierung
    }

    @Override // 8
    public Set<Set<Integer>> findAllSums(int[] numbers, int sum) {
        return Set.of(); // Dummy-Implementierung
    }

}