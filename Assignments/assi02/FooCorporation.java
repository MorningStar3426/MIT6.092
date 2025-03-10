public class FooCorporation {
    public static void checkBasePay(double basePay){
        if(basePay < 8.00){
            throw new IllegalArgumentException("Base pay must be at least $8.00");
        }
    }

    public static void checkHours(double hours){
        if(hours > 60){
            throw new IllegalArgumentException("Hours must not exceed 60");
        }
    }

    public static double calculate(double basePay, double hours){
        double salary;
        checkBasePay(basePay);
        checkHours(hours);
        if(hours > 40){
            salary = 40 * basePay + (hours - 40) * basePay * 1.5;
        }else{
            salary = hours * basePay;
        }
        return salary;
    }

    public static void main(String[] args) {
        double salary;
        salary = calculate(7.50, 35);
        System.out.println("Salary = " + salary);
        salary = calculate(8.20, 47);
        System.out.println("Salary = " + salary);
        salary = calculate(10.00, 73);
        System.out.println("Salary = " + salary);
    }
}
