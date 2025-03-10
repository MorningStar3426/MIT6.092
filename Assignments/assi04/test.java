public class test {
    public static void main(String[] args) {
        Baby.numBabiesMade = 100;
        System.out.println(Baby.numBabiesMade);
        Baby b1 = new Baby();
        Baby b2 = new Baby();
        System.out.println(Baby.numBabiesMade);
    }
}
