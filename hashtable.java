/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week12.hashing;

import java.util.LinkedList;

/**
 *
 * @author SFU
 */
public class hashtable {
    private LinkedList<String>[] ht;
    
    public hashtable()
    {
        this(10);
    }
    
    public hashtable(int s)
    {
        ht = new LinkedList[s];
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x<ht.length; x++) {
            sb.append(x);
            sb.append(": ");
            sb.append(ht[x]);
            sb.append("\n");
        }
        return sb.toString();
    }    
    public void add(String s) {
        int bucket = hash(s);
        
        if (ht[bucket] == null) {
            ht[bucket] = new LinkedList<>();
        }
        ht[bucket].add(s); 
    }
    
    // djb2 Hash Function
    public int hash(String s) {
    int hash = 5381;
    for (int i = 0; i < s.length(); i++) {
        hash = ((hash << 5) + hash) + s.charAt(i);
    }
    return (int)(Math.abs(hash) % ht.length);
    }
}
