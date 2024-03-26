package controller;

public class Transacoes {


    public static void executeTransacoes(int threadId, int calcSegundos, double transSegundos) {

        System.out.println("A Thread " + threadId + " está processando os calculos com " + calcSegundos + "s.");
        try {
            Thread.sleep((long) (calcSegundos * 1000 * Math.random() + 200));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread " + threadId + " está processando as transações com o banco de dados com " +
                transSegundos + "s.");
        try {
            Thread.sleep((long) (transSegundos * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}