package PocketGems;

public class StacksDiamonds
{

    public static void main(String[] args){
        String[] items = new String[]{"diamond", "ruby", "armor"};
        int[] counts = new int[]{10, 10, 10};
        int[] values = new int[]{10, 15, 20};
        int[] max_size = new int[]{5, 3, 2};
        System.out.println(findMax(items, counts, values, max_size, 4));
    }

    public static int findMax(String[] items, int[] counts, int[] values, int[] max_size, int n){
        int max = 0;
        for (int i = 0; i < n; i++){
            int tempMax = 0;
            int index = 0;
            int count = 0;
            for (int j = 0; j < values.length; j++){
                if (tempMax < values[j] * Math.min(max_size[j], counts[j])){
                    index = j;
                    //count = Math.min(max_size[j], counts[j]);
                    tempMax = values[j] * Math.min(max_size[j], counts[j]);
                }
            }
            max += tempMax;
            count = Math.min(max_size[index], counts[index]);
            counts[index] -= count;//这一句其实可以假装漏掉给面试官看
            System.out.println(items[index] + " :" + count + " value :" + tempMax);
        }
        return max;
    }    
}