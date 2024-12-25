package dictionary;
public class dictionaryMain extends WordCollection{
public static void main(String[] args) {
    WordCollection wordCollection = new WordCollection();


    wordCollection.addWord("Apple");
    wordCollection.addWord("Ant");
    wordCollection.addWord("Banana");
    wordCollection.addWord("Ball");
    wordCollection.addWord("Cat");
    wordCollection.addWord("Dog");
    wordCollection.addWord("Elephant");
    wordCollection.addWord("Antelope");


    System.out.println("All words in the collection:");
    wordCollection.printAllWords();


    System.out.println("\nWords starting with 'A':");
    wordCollection.printWordsByLetter('A');

    System.out.println("\nWords starting with 'B':");
    wordCollection.printWordsByLetter('B');

    System.out.println("\nWords starting with 'C':");
    wordCollection.printWordsByLetter('C');

    System.out.println("\nWords starting with 'Z':");
    wordCollection.printWordsByLetter('Z');
}
}
