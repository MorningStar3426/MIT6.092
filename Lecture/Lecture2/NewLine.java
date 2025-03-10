public class NewLine {
    public static void newLine(){
        System.out.println("");
    }

    public static void threeLine(){
        newLine();newLine();newLine();
    }

    public static void main(String[] args) {
        System.out.println("Line 1");
        threeLine();
        System.out.println("Line 2");
    }
}
