package streams;

import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsDemo {

    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

    List<Integer> duplicateNumbers = Arrays.asList(1, 2, 3, 4, 2, 5, 6, 3, 7, 8, 1);

    List<Integer> randomNumbers = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

    List<String> strings = Arrays.asList("apple", "banana", "orange", "grape");

    String target = "banana";

    int length = 5;

    char searchChar = 'a';

    public void sumOfElements() {
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum of Integers :: "+sum);
    }

    public void findMax() {
        OptionalInt max = numbers.stream().mapToInt(Integer::intValue).max();
        System.out.println("Max of Integers :: "+max.getAsInt());
    }

    public void filterEvenNumbers() {
        List<Integer> evenNumbers = numbers.stream().filter(ele -> ele % 2 == 0).collect(Collectors.toList());
        System.out.println("List of Even Numbers :: "+evenNumbers);
    }

    public void countNoOfStringsContainsACharacter() {
        long count = strings.stream().filter(str -> str.contains(String.valueOf(searchChar))).count();
        System.out.println("No of Strings Containing the search char :: "+count);
    }

    public void convertToUpperCase() {
        List<String> uppercaseStrings = strings.stream().map(str -> str.toUpperCase()).collect(Collectors.toList());
        System.out.println("Uppercase strings :: "+uppercaseStrings);
    }

    public void averageOfNumbers() {
        OptionalDouble average = numbers.stream().mapToDouble(Integer::doubleValue).average();
        System.out.println("Average of Numbers :: "+(average.isPresent() ? average.getAsDouble() : "N/A"));
    }

    public void sortStringsUsingAlphabeticalOrder() {
        List<String> sortedStrings = strings.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted Strings :: "+sortedStrings);
    }

    public void concatenateStrings() {
        String concatenatedString = strings.stream().collect(Collectors.joining(","));
        System.out.println("Concatenated string :: "+concatenatedString);
    }

    public void longestString() {
        Optional<String> longestString = strings.stream().max((a, b) -> a.length()-b.length() );
        System.out.println("Longest string :: "+longestString.get());
    }

    public void secondLargestNumber() {
        Optional<Integer> secondLargest = numbers.stream().sorted((num1 , num2) -> num2 - num1).skip(1).findFirst();
        System.out.println("Second Largest :: "+secondLargest.get());
    }

    public void removeDuplicates() {
        List<Integer> distinctNumbers = duplicateNumbers.stream().distinct().collect(Collectors.toList());
        System.out.println("Distinct numbers :: " + distinctNumbers);
    }

    public void shortestString() {
        Optional<String> shortestString = strings.stream().sorted((str1, str2) -> str1.length() - str2.length()).findFirst();
        String shortest = strings.stream().min(Comparator.comparingInt(String::length)).orElse(null);
        System.out.println("Shortest string :: "+shortestString.get());
    }

    public void convertToSquares() {
        List<Integer> squares = numbers.stream().map(num -> num*num).collect(Collectors.toList());
        System.out.println("Squares of numbers :: "+squares);
    }

    public void startWithPrefix() {
        List<String> startsWith = strings.stream().filter(str -> str.startsWith(searchChar+"")).collect(Collectors.toList());
        System.out.println("Starts with prefix :: "+startsWith);
    }

    public void productOfAllNumbers() {
        int product = numbers.stream().reduce(1 , (a,b) -> a*b).intValue();
        System.out.println("Product of all Numbers :: "+product);
    }

    public void primeNumbers() {
        List<Integer> primeNumbers = randomNumbers.stream().filter(StreamsDemo::isPrime).collect(Collectors.toList());
        System.out.println("Prime numbers :: "+primeNumbers );
    }

    public void containsStringInList() {
        boolean isMatch = strings.stream().anyMatch(str -> str.equals(target));
        System.out.println("Contains string :: "+isMatch);
    }

    public void lengthGreaterThanOrEqualTo() {
        List<String> filteredStrings = strings.stream().filter(str -> str.length() >= length).collect(Collectors.toList());
        System.out.println("Length Greater Than or Equal To strings :: "+filteredStrings);
    }

    public void divisibleBy3And5() {
        List<Integer> filteredNumbers = randomNumbers.stream().filter(num -> num % 3 == 0).filter(num -> num % 5 == 0).collect(Collectors.toList());
        System.out.println("Numbers divisible by 3 and 5 :: "+filteredNumbers);
    }

    public  void maxLengthString() {
        Optional<String> maxLengthString = strings.stream().max(Comparator.comparingInt(String::length));
        System.out.println("Max length string :: "+maxLengthString.get());
    }

    public void distinctOddNumbers() {
        List<Integer> distinctOddNumbers = randomNumbers.stream().filter(num -> num % 2 != 0).distinct().collect(Collectors.toList());
        System.out.println("Distinct odd numbers :: "+distinctOddNumbers);
    }

    public void sumOfAllOddNumbers() {
        int sumOfOddNumbers = randomNumbers.stream().filter(num -> num % 2 != 0).mapToInt(Integer::intValue).sum();
        System.out.println("Sum of Odd Numbers :: "+sumOfOddNumbers);
    }

    public void intersectionOfTwoLists() {
        List<String> list1 = Arrays.asList("apple", "banana", "kiwi", "orange", "pear");
        List<String> list2 = Arrays.asList("banana", "orange", "grape", "watermelon");
        List<String> intersection = list1.stream()
                .filter(list2::contains)
                .collect(Collectors.toList());
        System.out.println("Intersection of lists: " + intersection);
    }

    public void stringContainingOnlyVowels() {
        List<String> strings = Arrays.asList("apple", "banana", "kiwi", "orange", "pear", "oai");
        List<String> vowelStrings = strings.stream()
                .filter(s -> s.matches("[aeiouAEIOU]+"))
                .collect(Collectors.toList());
        System.out.println("Strings containing only vowels: " + vowelStrings);
    }

    public void indexOfFirstOccurrence() {
        List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 9, 2, 4, 6, 8, 10);
        int targetNumber = 7;
        OptionalInt index = IntStream.range(0,numbers.size()).filter(i -> numbers.get(i) == targetNumber).findFirst();
        System.out.println("Index of " + targetNumber + ": " + index.getAsInt());
    }

    public void unionOfTwoLists() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8);
        List<Integer> union = Stream.concat(list1.stream(), list2.stream())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Union of lists: " + union);
    }

    public void stringsContainingDuplicateCharacters() {
        List<String> strings = Arrays.asList("apple", "banana", "kiwi", "orange", "pear", "strawberry", "watermelon");
        List<String> duplicateStrings = strings.stream()
                .filter(s -> s.length() != s.chars().distinct().count())
                .collect(Collectors.toList());
        System.out.println("Strings containing duplicate characters: " + duplicateStrings);
    }

    public void allElementsHasSameLength() {
        List<String> strings = Arrays.asList("apple", "banana", "kiwi", "orange", "pear");
        boolean sameLength = strings.stream()
                .map(String::length)
                .distinct()
                .count() == 1;
        System.out.println("All elements have the same length: " + sameLength);
    }

    public void differenceBetweenMaxAndMin() {
        List<Integer> numbers = Arrays.asList(10, 5, 7, 18, 3, 15);
        OptionalInt max = numbers.stream().mapToInt(Integer::intValue).max();
        OptionalInt min = numbers.stream().mapToInt(Integer::intValue).min();
        int difference = max.getAsInt() - min.getAsInt();
        System.out.println("Difference between maximum and minimum numbers: " + difference);
    }

    public void removeAllWhiteSpaces() {
        List<String> strings = Arrays.asList("apple", "ba nana", "kiwi", "oran ge", "pear");
        List<String> noWhitespace = strings.stream().map(s -> s.replaceAll("\\s", "")).collect(Collectors.toList());
        System.out.println("List with whitespace removed: " + noWhitespace);
    }

    public void containsSubstring(){
        List<String> strings = Arrays.asList("apple", "banana", "kiwi", "orange", "pear");
        String substring = "an";
        List<String> containingSubstring = strings.stream().filter(s -> s.contains(substring)).collect(Collectors.toList());
        System.out.println("Strings containing \"" + substring + "\": " + containingSubstring);
    }

    public void modeOfListOfIntegers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 3, 4, 4, 4, 5, 5);
        Map<Integer, Long> frequencyMap = numbers.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        long maxFrequency = frequencyMap.values().stream().mapToLong(Long::longValue).max().orElse(0);
        List<Integer> modes = frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxFrequency)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("Mode(s): " + modes);
    }

    public void frequencyOfEachElement() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 3, 4, 4, 4, 5, 5);
        Map<Integer, Long> frequencyMap = numbers.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        System.out.println("Frequency of each element: " + frequencyMap);
    }

    public void maxNoOfVowels() {
        List<String> strings = Arrays.asList("apple", "banana", "kiwi", "orange", "pear");
        Map<String, Long> frequencyMap = strings.stream()
                .collect(Collectors.toMap(s -> s, s -> s.chars().filter(c -> "AEIOUaeiou".indexOf(c) != -1).count()));
        long maxVowelCount = frequencyMap.values().stream().mapToLong(Long::longValue).max().orElse(0);
        List<String> maxVowelStrings = frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxVowelCount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("String(s) with maximum number of vowels: " + maxVowelStrings);
    }

    public void medianOfListOfIntegers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        OptionalDouble median = numbers.stream().mapToInt(Integer::intValue).sorted()
                .skip((numbers.size() - 1) / 2)
                .limit(numbers.size() % 2 == 0 ? 2 : 1)
                .average();
        System.out.println("Median of the list: " + (median.isPresent() ? median.getAsDouble() : "N/A"));
    }

    public void containingSpecificCharacterAtLeastTwice() {
        List<String> strings = Arrays.asList("apple", "banana", "kiwi", "orange", "pear");
        char targetChar = 'a';
        List<String> containingCharTwice = strings.stream()
                .filter(s -> s.chars().filter(c -> c == targetChar).count() >= 2)
                .collect(Collectors.toList());
        System.out.println("Strings containing \"" + targetChar + "\" at least twice: " + containingCharTwice);
    }

    public void kthSmallestElement() {
        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5);
        int k = 3; // Find the 3rd smallest element
        Optional<Integer> kthSmallest =  numbers.stream().sorted((num1,num2) -> num1 - num2).skip(k-1).findFirst();
        System.out.println("The " + k + "th smallest element: " + (kthSmallest.isPresent() ? kthSmallest.get() : "N/A"));
    }

    public void maximumNoOfConsonants() {
        List<String> strings = Arrays.asList("apple", "banana", "kiwi", "orange", "pear");
        Map<String, Long> frequencyMap = strings.stream()
                .collect(Collectors.toMap(s -> s, s -> s.chars().filter(c -> "BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz".indexOf(c) != -1).count()));
        long maxConsonantCount = frequencyMap.values().stream().mapToLong(Long::longValue).max().orElse(0);
        List<String> maxConsonantStrings = frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxConsonantCount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("String(s) with maximum number of consonants: " + maxConsonantStrings);
    }

    public void isListOfStringsPalindrome() {
        List<String> strings = Arrays.asList("apple", "banana", "kiwi", "banana", "apple");
        boolean isPalindrome = strings.stream()
                .skip(strings.size() / 2)
                .allMatch(s -> s.equals(strings.get(strings.size() - 1 - strings.indexOf(s))));
        System.out.println("Is the list a palindrome? " + isPalindrome);
    }

    public void stringsContainingOnlyDigits() {
        List<String> strings = Arrays.asList("123", "abc", "456", "789", "def");
        Predicate<String> containsOnlyDigits = s -> s.matches("\\d+");
        List<String> digitStrings = strings.stream().filter(containsOnlyDigits).collect(Collectors.toList());
        System.out.println("Strings containing only digits: " + digitStrings);
    }

    public void removeAllNonNumericValues() {
        List<String> strings = Arrays.asList("a1b2c3", "1a2b3c", "123abc");
        Pattern pattern = Pattern.compile("[^0-9]");
        List<String> numericStrings = strings.stream()
                .map(s -> pattern.matcher(s).replaceAll(""))
                .collect(Collectors.toList());
        System.out.println("List with non-numeric characters removed: " + numericStrings);
    }

    public void kthLargestElement() {
        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5);
        int k = 3; // Find the 3rd largest element
        Collections.sort(numbers, Collections.reverseOrder());
        Integer kthLargest = numbers.stream().distinct().skip(k - 1).findFirst().orElse(null);
        System.out.println("The " + k + "th largest element: " + kthLargest);
    }

    public void lowestFrequency() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 3, 4, 4, 4, 5, 5);
        Map<Integer, Long> frequencyMap = numbers.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        long minFrequency = frequencyMap.values().stream().mapToLong(Long::longValue).min().orElse(0);
        List<Integer> elementsWithMinFrequency = frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() == minFrequency)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("Element(s) with lowest frequency: " + elementsWithMinFrequency);
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
