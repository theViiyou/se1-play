package numbers;

import java.util.ArrayList;
import java.util.HashSet;
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
        if (numbers == null) {
            throw new IllegalArgumentException("illegal argument: null");
        }
        for (int i = 0; i < numbers.length; i++) {
            summe += numbers[i];
        }
        return summe;

        /*
         * Alternative mit Streams:
         * return Arrays.stream(numbers)
         * .asLongStream()
         * .sum();
         */
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

        /*
         * Alternative mit Streams:
         * return Arrays.stream(numbers)
         * .filter(n -> n > 0 && n % 2 == 0)
         * .asLongStream()
         * .sum();
         */
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

        // return i<0 || i>=numbers.length ? 0L : numbers[i] + sum_recursive(numbers,
        // i+1);

        /*
         * Alternative mit Streams:
         * return IntStream.range(i, numbers.length)
         * .map(n -> numbers[n])
         * .asLongStream()
         * .sum();
         */
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
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == x) {
                return i;
            }
        }
        return -1; // x not found

        /*
         * Alternative mit Streams:
         * return IntStream.range(0, numbers.length)
         * .filter(i -> numbers[i] == x)
         * .findFirst()
         * .orElse(-1);
         */
    }

    @Override // 5 (-2, 4, 9, 4, -3, 4, 9, 5) 4
    public int findLast(int[] numbers, int x) {
        if (numbers == null) {
            throw new IllegalArgumentException("illegal argument: null");
        }
        int result = -1;
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] == x) {
                return result = i;
            }
        }
        return result; // x not found

        /*
         * Alternative mit Streams:
         * return IntStream.iterate(numbers.length - 1, i -> i >= 0, i -> i - 1)
         * .filter(i -> numbers[i] == x)
         * .findFirst()
         * .orElse(-1);
         */
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

        /*
         * Alternative mit Streams:
         * return IntStream.range(0, numbers.length)
         * .filter(i -> numbers[i] == x)
         * .boxed()
         * .collect(Collectors.toList());
         */
    }

    @Override // 7
    public Set<Pair> findSums(int[] numbers, int sum) {
        if (numbers == null) {
            throw new IllegalArgumentException("illegal argument: null");
        }
        Set<Pair> result = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == sum) {
                    result.add(new Pair(Math.min(numbers[i], numbers[j]), 
                            Math.max(numbers[i], numbers[j])));
                }
            }
        }
        return result; // Dummy-Implementierung
    }

    // Numbers_8
    @Override
    public Set<Set<Integer>> findAllSums(int[] numbers, int sum) {
        if (numbers == null) {
            throw new IllegalArgumentException("illegal argument: null");
        }

        Set<Set<Integer>> result = new HashSet<>();
        backtrack(numbers, 0, sum, new HashSet<>(), result);
        return result;
        // return powerSetBruteForce(numbers, sum);
    }

    private void backtrack(int[] numbers, int index, int remaining,
            Set<Integer> current, Set<Set<Integer>> result) {

        if (remaining == 0) {
            result.add(new HashSet<>(current));
            return;
        }

        if (index >= numbers.length || remaining < 0) {
            return;
        }

        // Zahl nehmen
        current.add(numbers[index]);
        backtrack(numbers, index + 1, remaining - numbers[index], current, result);

        // Zahl nicht nehmen
        current.remove(numbers[index]);
        backtrack(numbers, index + 1, remaining, current, result);
    }
}