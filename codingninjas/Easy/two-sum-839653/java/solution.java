    public static ArrayList<Pair<Integer, Integer>> twoSum(ArrayList<Integer> arr, int target, int n) {
 
        ArrayList<Pair<Integer, Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
 
        for (int i = 0; i < n; i++) {
 
            int current = arr.get(i);
            int complement = target - current;
 
            if (map.containsKey(complement) && map.get(complement) > 0) {
                result.add(new Pair<>(complement, current));
                map.put(complement, map.get(complement) - 1);
            } else {
                map.put(current, map.getOrDefault(current, 0) + 1);
            }
        }
 
        if (result.size() == 0) {
            result.add(new Pair<>(-1, -1));
        }
 
        return result;
    }
}