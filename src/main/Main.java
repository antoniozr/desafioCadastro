package main;

import repository.Filerepository;
import services.BuscarPetService;
import services.ImprimirMenu;
import services.CadastrarPet;
import services.ListarPets;

public class Main {
    public static void main(String[] args) {
        Filerepository file = new Filerepository();
        file.criarFile();
        file.lerFile();
        ImprimirMenu imprimirMenu = new ImprimirMenu();
        CadastrarPet cadastrarPet = new CadastrarPet();
        BuscarPetService buscarPet = new BuscarPetService();
        ListarPets listarPets = new ListarPets();

        int opcao = 0;

        while (opcao != 6) {
            opcao = imprimirMenu.imprimirMenuPrincipal();
            switch (opcao) {
                case 1:
                    cadastrarPet.cadastrarPet();
                    break;
                case 4:
                    listarPets.listarTodosPets();
                    break;
                case 5:
                    buscarPet.buscarPet();
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