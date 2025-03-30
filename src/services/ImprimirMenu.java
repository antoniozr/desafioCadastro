package services;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ImprimirMenu {
    public int imprimirMenuPrincipal() {
        Scanner sc = new Scanner(System.in);
        int escolha = 0;

        while (true) {
            System.out.println();
            System.out.println("1. Cadastrar um novo pet");
            System.out.println("2. Alterar os dados do pet cadastrado");
            System.out.println("3. Deletar um pet cadastrado");
            System.out.println("4. Listar todos os pets cadastrados");
            System.out.println("5. Listar pets por algum critério (idade, nome, raça)");
            System.out.println("6. Sair");

            try {
                escolha = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida, digite um número!");
                sc.next();
            }
        }
        return escolha;
    }
}
