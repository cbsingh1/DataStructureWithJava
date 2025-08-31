package com.cbsingh.leetcode;

import java.util.*;

public class Leetcode347_TopKFrequentElements {
    public static void main(String[] args) {
        test(new int[]{1, 1, 1, 3, 2, 2, 4}, 2); //answer = [1,2]
        test(new int[]{1, 1, 1, 3, 2, 2, 4}, 3); //answer = [1,2,3] or [1,2,4]
        test(new int[]{1}, 1); //answer = [1]
    }

    public int[] topKFrequentWithHeap(int[] nums, int k) {
        var frequencyMap = new HashMap<Integer, Integer>();
        for (int num : nums)
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);

        var pq = new PriorityQueue<Integer>(Comparator.comparingInt(frequencyMap::get));
        for (int num : frequencyMap.keySet()) {
            pq.add(num);
            if (pq.size() > k)
                pq.poll();
        }
        return pq.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] topKFrequentWithArrIndex(int[] nums, int k) {
        var frequencyMap = new HashMap<Integer, Integer>();
        for (int num : nums)
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);

        //Create an array of size nums.length + 1, where each index represents the frequency of the element.
        //Array of size nums.length + 1 is created to handle the case where all elements are the same,
        // then frequency of that element = nums.length. As array index starts with 0, so we are adding 1 to handle that case
        List<Integer>[] freqArr = new ArrayList[nums.length + 1];
        for (var entry : frequencyMap.entrySet()) {
            int freq = entry.getValue();
            if(freqArr[freq]==null)
                freqArr[freq] = new ArrayList<>();

            freqArr[freq].add(entry.getKey());
        }

        int[] res = new int[k];
        int idx = 0;
        for (int i = freqArr.length - 1; i >= 0; i--) {
            if (freqArr[i] != null){
                for (int num : freqArr[i]) {
                    res[idx++] = num;
                    if (idx == k) {
                        return res;
                    }
                }
            }
        }

        return new int[0];
    }

    int[] uniqueArr;
    Map<Integer, Integer> freqMap;

    public int[] topKFrequentWithQuickSelect(int[] nums, int k) {
        //Map with the frequency of each element
        freqMap = new HashMap<>();
        for(int num: nums)
            freqMap.put(num, freqMap.getOrDefault(num,0) + 1);

        // Array of unique elements
        int n = freqMap.size();
        uniqueArr = new int[n];
        int index=0;
        for(int key: freqMap.keySet())
            uniqueArr[index++] = key;

        // kth top frequent element is (n - k)th less frequent.
        quickSelect(0, n-1, n-k);

        // Return top k frequent elements
        return Arrays.copyOfRange(uniqueArr, n - k, n);
    }

    void quickSelect(int left, int right, int kSmallest) {
        // base case: the list contains only one element
        if(left == right) return;

        //Select a random pivot_index
        Random randomNum = new Random();
        int pivotIndex = left + randomNum.nextInt(right - left);

        pivotIndex = partition(left, right, pivotIndex);

        // If the pivot is in its final sorted position
        if (kSmallest == pivotIndex) {
            return;
        } else if (kSmallest < pivotIndex) {
            // go left
            quickSelect(left, pivotIndex - 1, kSmallest);
        } else {
            // go right
            quickSelect(pivotIndex + 1, right, kSmallest);
        }
    }

    public int partition(int left, int right, int pivotIndex) {
        int pivotFrequency = freqMap.get(uniqueArr[pivotIndex]);
        //Move pivot to end
        swap(pivotIndex, right);
        int storeIndex = left;

        //2. Move all less frequent elements to the left
        for (int i = left; i <= right; i++) {
            if (freqMap.get(uniqueArr[i]) < pivotFrequency) {
                swap(storeIndex, i);
                storeIndex++;
            }
        }

        //3. Move pivot to its final position
        swap(storeIndex, right);

        return storeIndex;
    }

    public void swap(int index1, int index2) {
        int temp = uniqueArr[index1];
        uniqueArr[index1] = uniqueArr[index2];
        uniqueArr[index2] = temp;
    }
    
    static void test(int[] nums, int k) {
        var cut = new Leetcode347_TopKFrequentElements();

        System.out.println("Nums: " + Arrays.toString(nums) + " k: " + k);
        System.out.println("Result with heap solution: " + Arrays.toString(cut.topKFrequentWithHeap(nums, k)));
        System.out.println("Result with freq array index solution: " + Arrays.toString(cut.topKFrequentWithArrIndex(nums, k)));
        System.out.println("Result with quick select solution: " + Arrays.toString(cut.topKFrequentWithQuickSelect(nums, k)));
        System.out.println("---------------");
    }
}