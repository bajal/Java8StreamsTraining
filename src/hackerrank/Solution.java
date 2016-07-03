package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Bajal on 7/3/16.
 */
import java.io.*;
import java.util.*;

interface performOperation{
    int check(int a);
}

class Math {

    public static int checker(performOperation p, int num) {
        return p.check(num);
    }

    public performOperation checkEvenOdd() {
        return (n -> n%2==0?0:1);
    }

    public performOperation checkPrime() {
        return s->isPrime(s);
    }

    public performOperation checkPalindrome() {
        return (s -> isPalindrome(s));
    }

    public int isPrime(int num){
        if(num ==2) return 0;
        if (num % 2 == 0)
            return 1;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return 1;
        return 0;
    }

    public int isPalindrome(int s){
        String s1 = Integer.toString(s);
        if  (s1.equalsIgnoreCase( new StringBuilder(s1).reverse().toString() ) )
            return 0;
        else return 1;
    }
}

public class Solution {

    public static void main(String[] args)throws IOException {
        Math ob = new Math();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        performOperation op;
        int ret =0;
        String ans=null;

        while(T-->0){
            String s=br.readLine().trim();
            StringTokenizer st=new StringTokenizer(s);
            int ch=Integer.parseInt(st.nextToken());
            int num=Integer.parseInt(st.nextToken());
            if(ch==1){
                op = ob.checkEvenOdd();
                ret = ob.checker(op,num);
                ans = (ret == 0)?"EVEN":"ODD";
            }
            else if(ch==2){
                op = ob.checkPrime();
                ret = ob.checker(op,num);
                ans = (ret == 0)?"PRIME":"COMPOSITE";
            }
            else if(ch==3){
                op = ob.checkPalindrome();
                ret = ob.checker(op,num);
                ans = (ret == 0)?"PALINDROME":"NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }

}

