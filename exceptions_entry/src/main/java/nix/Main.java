package nix;


import nix.service.impl.Retry;

import java.util.Scanner;

public class Main {
    final static Scanner scanner = new Scanner(System.in);
    private static int numberOfAttempts = 0;
    private static long timeOfWaiting = 100;


    public static int enterNumberOfAttempts(int numb){
        System.out.println("Введите количество попыток: ");
        numb = scanner.nextInt();
        if(numb>0) return numb;
        else {
            System.out.println("Число должно быть больше нуля!");
            enterNumberOfAttempts(numb);
        }
        return numb;
    }

    public static void main(String[] args) {
    Retry retry = new Retry();
        Main.numberOfAttempts = enterNumberOfAttempts(numberOfAttempts);
        //если введенное число попыток, будет БОЛЬШЕ 5, код успеет првильно сработать
        //если введённое число попыток , будет МЕНЬШЕ или РАВНО 5, код так и не выполнится правильно

        for(int i=1; i<numberOfAttempts-1; i++){
            System.out.println("Попытка номер: "+i);
            try {
                retry.run();
                if (i!=numberOfAttempts-2)
                    Thread.sleep(timeOfWaiting);
            } catch (Exception e) {
                System.out.println("Перехват исключения ... попытка перезапуска кода. Время ожидания "+timeOfWaiting);
                if(i==numberOfAttempts-2){
                    System.out.println("Сейчас иключение вылетит наверх");
                     e.printStackTrace();
                     break;
                }
            }
            timeOfWaiting*=(i+1);

        }





    }
}
