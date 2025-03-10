public class ScopeReview {
    void scopeMethod(int var1) {
        String var2;
        if (var1 > 0) {
            var2 = "above 0";
        } else {
            var2 = "less than or equal to 0";
        }
        System.out.println(var2);
    }
}