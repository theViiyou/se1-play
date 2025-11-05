package numbers;

import java.util.List;
import java.util.Set;

class NumbersImpl implements Numbers {

    private static final NumbersImpl INSTANCE = null;

    /**
     * Constructor.
     */
    private NumbersImpl() {
    }

    /**
     * Get the singleton instance of NumbersImpl.
     * 
     * @return instance
     */
    public static NumbersImpl getInstance() {
        if(INSTANCE == null) {
            return new NumbersImpl();
        }
        return INSTANCE;
    }

    @Override
    public long sum(int[] numbers) {
        int summe = 0;
        for (int i = 0; i < numbers.length; i++) {
            summe += numbers[i];
        }
        return summe;
    }

    @Override
    public long sum_positive_even_numbers(int[] numbers) {
        int summe = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0 && numbers[i] % 2 == 0) {
                summe += numbers[i];
            }
        }
        return summe;
    }

    @Override
    public long sum_recursive(int[] numbers, int i) {
        int summe = 0;
        if (i < numbers.length) {
            summe = numbers[i] + (int) sum_recursive(numbers, i + 1);
        }
        return summe;
    }

    @Override
    public int findFirst(int[] numbers, int x) {
        return -1; // Dummy-Implementierung
    }

    @Override
    public int findLast(int[] numbers, int x) {
        return -1; // Dummy-Implementierung
    }

    @Override
    public List<Integer> findAll(int[] numbers, int x) {
        return List.of(); // Dummy-Implementierung
    }

    @Override
    public Set<Pair> findSums(int[] numbers, int sum) {
        return Set.of(); // Dummy-Implementierung
    }

    @Override
    public Set<Set<Integer>> findAllSums(int[] numbers, int sum) {
        return Set.of(); // Dummy-Implementierung
    }

}