package org.example;

public class MyFunction {
    public int square(int x) {
        return (x * x);
    }

    public int div(int x, int y){
        return x/y;
    }

    public int fact(int n){
        if(n>1){
            return n*fact(n-1);
        }else{
            return 1;
        }
    }
}
