package services;

import model.Pet;
import utils.InputValidator;

import java.util.List;
import java.util.Scanner;

public class DeletarPet {
    BuscarPetService buscarPetService = new BuscarPetService();
    InputValidator inputValidator = new InputValidator();
    Scanner sc = new Scanner(System.in);

    public void deletarPet() {
        List<Pet> petsLists;

        do {
            petsLists = buscarPetService.buscarPet();
            if (petsLists.isEmpty()) {
                System.out.println("Nenhum resultado encontrado, Tente novamente!");
            }
        } while (petsLists.isEmpty());

        System.out.println("Digite o número do pet que você deseja deletar");
        int numeroPetDelete = inputValidator.validaQuantidadeOpcoes(sc, 1, petsLists.size());

        Pet petSelecionado = petsLists.get(numeroPetDelete - 1);

        System.out.println("Você realmente deseja deletar o pet " + petSelecionado.getNomePet());
        String simNao = inputValidator.validaSimNao(sc);

        if (simNao.equals("NAO")) {
            System.out.println("Operação cancelada!");
            return;
        } else {
            petSelecionado.deletarPet(petSelecionado.getNomePet());
            System.out.println("Pet " + petSelecionado.getNomePet() + " deletado com sucesso!");
        }
    }
}