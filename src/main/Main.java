package main;

import repository.Filerepository;
import services.ImprimirMenu;

public class Main {
    public static void main(String[] args) {
        Filerepository file = new Filerepository();
        file.criarFile();
        file.lerFile();
        ImprimirMenu imprimirMenu = new ImprimirMenu();
        int opcao = 0;

        while (opcao != 6) {
            opcao = imprimirMenu.imprimirMenuPrincipal();
            switch (opcao) {
                case 1:
                    break;
                case 6:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente!");
            }
        }
    }
}