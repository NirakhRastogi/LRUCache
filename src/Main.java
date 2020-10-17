public class Main {
    public static void main(String[] args) {
        LRUCache<Integer, String> randomCache = new LRUCache<>(5, "Head", "Tail");
        randomCache.put(0, "Peter");
        randomCache.put(1, "Eline");
        randomCache.put(2, "John");
        System.out.println(randomCache.toString());
        randomCache.put(3, "Tina");
        randomCache.put(4, "Bishkek");
        System.out.println(randomCache.toString());
        System.out.println("#### (Add 5) -> Should remove peter ####");
        randomCache.put(5, "Honda");
        System.out.println(randomCache.toString());
        System.out.println("#####(Get 2) -> Should add John to recently used and return John####");
        System.out.println(randomCache.get(2));
        System.out.println(randomCache.toString());
        System.out.println("####(Update value for key 1) should change eline to elina and move to recently used ####");
        randomCache.put(1, "Elina");
        System.out.println(randomCache.toString());
    }
}
