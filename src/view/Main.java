package view;

import controller.Transacoes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(21);
        Transacoes transacoes = new Transacoes();

        for (int i = 1; i <= 21; i++) {
            final int threadId = i;
            executor.execute(() -> {
                if (threadId % 3 == 1) {
                    transacoes.executeTransacoes(threadId, 2, 1);
                    transacoes.executeTransacoes(threadId, 1, 1);
                } else if (threadId % 3 == 2) {
                    transacoes.executeTransacoes(threadId, 3, 1.5);
                    transacoes.executeTransacoes(threadId, 2, 1.5);
                    transacoes.executeTransacoes(threadId, 1, 1.5);
                } else {
                    transacoes.executeTransacoes(threadId, 3, 1.5);
                    transacoes.executeTransacoes(threadId, 2, 1.5);
                    transacoes.executeTransacoes(threadId, 1, 1.5);
                }
            });
        }

        executor.shutdown();
    }
}