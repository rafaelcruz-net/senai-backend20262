package org.example.bankapisenai;

public class Calculadora {
    public int somar(int a, int b) {
        return a+b;
    }

    public int multiplicar(int a, int b) {
        return a*b;
    }

    public int divisao(int a, int b) throws Exception {
        if (b == 0) {
            throw new Exception("Não é possivel fazer uma divisão por zero");
        }

        return a / b;
    }
}
