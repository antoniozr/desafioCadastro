package main;

import repository.Filerepository;
import services.ImprimirMenu;
import services.CadastrarPet;

public class Main {
    public static void main(String[] args) {
        Filerepository file = new Filerepository();
        file.criarFile();
        file.lerFile();
        ImprimirMenu imprimirMenu = new ImprimirMenu();
        CadastrarPet cadastrarPet = new CadastrarPet();

        int opcao = 0;

        while (opcao != 6) {
            opcao = imprimirMenu.imprimirMenuPrincipal();
            switch (opcao) {
                case 1:
                    cadastrarPet.cadastrarPet();
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