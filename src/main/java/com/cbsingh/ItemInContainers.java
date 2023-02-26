package com.cbsingh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemInContainers {

    public static void main(String[] args) {
        List<Integer> startIndices = new ArrayList<>();
        startIndices.add(1);
        startIndices.add(1);

        List<Integer> endIndices = new ArrayList<>();
        endIndices.add(1);
        endIndices.add(3);

        //System.out.println(numberOfItems("|**|*|*",startIndices, endIndices));
        System.out.println(numberOfItems("*|*|",startIndices, endIndices));
    }

    public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
        // Write your code here
        List<Integer> ansList = new ArrayList<Integer>();
        for(int i=0; i<startIndices.size(); i++) {
            int start = startIndices.get(i);
            int end = endIndices.get(i);
            int count=0;
            boolean startFound=false;
            boolean endFound = false;
            while(start<end) {
                if(!startFound && !endFound){
                    if(s.charAt(start-1)=='|') {
                        startFound=true;
                    }

                    if(s.charAt(end-1)=='|') {
                        endFound=true;
                    }
                    start++;
                    end--;

                } else if(startFound && endFound) {
                    if(s.charAt(start-1)=='*')
                        count++;
                    if(s.charAt(end-1)=='*')
                        count++;

                    start++;
                    end--;
                } else if(startFound) {
                    if(s.charAt(end-1)=='|')
                        endFound=true;

                    end--;
                }else if(endFound) {
                    if(s.charAt(start-1)=='|')
                        startFound=true;

                    start++;
                }
            }
            ansList.add(count);
        }
        return ansList;
    }
}

