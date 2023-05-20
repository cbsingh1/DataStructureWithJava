package com.cbsingh.trie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplaceWords {

    public static void main(String[] args) {
        ReplaceWords obj = new ReplaceWords();
        List<String> dictionary = List.of("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(obj.replaceWords(dictionary, sentence));
    }

    class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> children = new HashMap<>();
    }

    TrieNode root = new TrieNode();

    public String replaceWords(List<String> dictionary, String sentence) {
        String result="";
        for(String s : dictionary)
            insert(s);

        String[] splitSentenceArr = sentence.split("\\s+");

        for(String s : splitSentenceArr) {
            String prefixStr = checkPrefixExists(s);
            if(prefixStr != null)
                result += prefixStr + " ";
            else
                result += s + " ";
        }
        return result.trim();
    }

    void insert(String str) {
        TrieNode current = root;
        for(Character c : str.toCharArray()) {
            current.children.putIfAbsent(c, new TrieNode());
            current = current.children.get(c);
        }
        current.isWord = true;
    }

    String checkPrefixExists(String s) {
        TrieNode current = root;
        String result="";
        for(Character c : s.toCharArray()) {
            if (current.children.get(c)==null) return null;
            current = current.children.get(c);
            result += String.valueOf(c);
            if(current.isWord) return result;
        }
        return null;
    }
}
