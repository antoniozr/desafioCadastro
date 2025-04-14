package services;

import model.Pet;


import java.util.List;

public class ListarPets {

    public void listarTodosPets() {
        try {
            List<Pet> pets = Pet.exibirPetsSalvos();

            if (pets.isEmpty()) {
                System.out.println("Nenhum pet cadastrado");
            } else {
                int contador = 1;
                for (Pet pet : pets) {
                    System.out.println(contador + ". " + pet);
                    contador++;
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar pets: " + e.getMessage());
        }
    }
}
