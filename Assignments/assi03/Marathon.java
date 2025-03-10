class Marathon {
    public static int find(int[] times){
        int index = 0;
        int grade = times[0];
        for (int i = 0; i < times.length; i++){
            int tmp = times[i];
            if (tmp < grade){
                grade = tmp;
                index = i;
            }
        }
        return index;
    }

    public static int secondFind(int[] times){
        int secondIndex = -1;
        int firstIndex = find(times);
        int grade = Integer.MAX_VALUE;
        for (int i = 0; i < times.length; i++){
            int tmp = times[i];
            if (i == firstIndex){
                continue;
            }
            if (tmp < grade){
                grade = tmp;
                secondIndex = i;
            }
        }
        return secondIndex;
    }
    public static void main (String[] arguments) {
        String[] names = {
            "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex",
            "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda",
            "Aaron", "Kate"
        };

        int[] times = {
            341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299,
            343, 317, 265
        };

        int firstIndex = find(times);
        int secondIndex = secondFind(times);
        System.out.println("The first : " + names[firstIndex]);
        System.out.println("The second : " + names[secondIndex]);
    }
} 