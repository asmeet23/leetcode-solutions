class Solution {
    public int[] arrayRankTransform(int[] arr) {

        //creating a copy array and sorting it
        int[] copyArr = arr.clone();
        Arrays.sort(copyArr);
        //making a hashmap
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        //setting initial rank as 1
        int rank = 1;
        // for each num in copy array which was sorted, if it was not in the hashmap, we put it and inc the rank by 1
        for(int num : copyArr){
            if(!rankMap.containsKey(num)){
                rankMap.put(num,rank++);
            }
        }
        // making a result array
        int[] result = new int[arr.length];
        //storing ranks in it
        for(int i=0;i<arr.length;i++){
            result[i] = rankMap.get(arr[i]);
        }

        return result;
    }
}