package nix.service.impl;

import nix.service.Block;

public class Retry implements Block {
    private static int count = 3;

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Retry.count = count;
    }

    @Override
    public void run() throws Exception {
        if(count>0){
            count--;
        System.out.println("Код работает некорректно!");
        throw new Exception();
        } else{
            System.out.println("Код сработал без ошибок.");
        }

    }
}
