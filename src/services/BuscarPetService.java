package services;

import model.Pet;
import model.PetSexo;
import model.PetTipo;
import utils.InputValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuscarPetService {

    public void buscarPet() {
        Scanner sc = new Scanner(System.in);
        InputValidator inputValidator = new InputValidator();

        try {
            List<Pet> todosPets = Pet.exibirPetsSalvos();
            List<Pet> petsFiltrados = new ArrayList<>();

            System.out.println("Digite 1 para Cachorro ou 2 para Gato");
            int tipoAnimal = inputValidator.validaUmOuDois(sc);
            PetTipo petTipoBusca = null;
            if (tipoAnimal == 1) {
                petTipoBusca = PetTipo.CACHORRO;
            } else {
                petTipoBusca = PetTipo.GATO;
            }

            int criterio1 = exibirMenuBuscaCriterio(sc, inputValidator);

            int criterio2 = 0;
            if (criterio1 != 0) {
                do {
                    criterio2 = exibirMenuBuscaCriterio(sc, inputValidator);
                    if (criterio2 == criterio1) {
                        System.out.println("Escolha um critério diferente do primeiro");
                    }
                } while (criterio2 == criterio1);
            }

            String nomeBuscaPet = null;
            PetSexo petSexoBusca = null;
            String idadeBuscaPet = null;
            String pesoPetBusca = null;
            String racaPetBusca = null;
            String enderecoPetBusca = null;


            if (criterio1 == 1 || criterio2 == 1) {
                System.out.println("Digite o nome do Pet:");
                nomeBuscaPet = sc.nextLine();
            }

            if (criterio1 == 2 || criterio2 == 2) {
                System.out.println("Digite o sexo do pet:");
                int sexoPetBusca = inputValidator.validaUmOuDois(sc);
                if (sexoPetBusca == 1) {
                    petSexoBusca = PetSexo.MACHO;
                } else {
                    petSexoBusca = PetSexo.FEMEA;
                }
            }

            if (criterio1 == 3 || criterio2 == 3) {
                System.out.println("Digite a idade do pet: ");
                idadeBuscaPet = inputValidator.validaIdade(sc);
            }

            if (criterio1 == 4 || criterio2 == 4) {
                System.out.println("Digite peso do pet:");
                pesoPetBusca = inputValidator.validaPeso(sc);
            }

            if (criterio1 == 5 || criterio2 == 5) {
                System.out.println("Digite a raça do pet: ");
                racaPetBusca = sc.nextLine();
            }

            if (criterio1 == 6 || criterio2 == 6) {
                System.out.println("Digite o endereço do pet:");
                enderecoPetBusca = sc.nextLine();
            }

            for (Pet pets : todosPets) {
                if (pets.getPetTipo().equals(petTipoBusca) &&
                        (nomeBuscaPet == null || pets.getNomePet().toLowerCase().contains(nomeBuscaPet.toLowerCase())) &&
                        (petSexoBusca == null || pets.getPetSexo().equals(petSexoBusca)) &&
                        (idadeBuscaPet == null || pets.getIdade().equals(idadeBuscaPet)) &&
                        (pesoPetBusca == null || pets.getPeso().equals(pesoPetBusca)) &&
                        (racaPetBusca == null || pets.getRaca().toLowerCase().contains(racaPetBusca.toLowerCase())) &&
                        (enderecoPetBusca == null ||
                                pets.getPetEndereco().getCidade().toLowerCase().contains(enderecoPetBusca.toLowerCase()) ||
                                pets.getPetEndereco().getRua().toLowerCase().contains(enderecoPetBusca.toLowerCase()))) {

                    petsFiltrados.add(pets);

                }
            }


            listarPetsFiltrados(petsFiltrados);
        } catch (Exception e) {
            System.out.println("Erro ao buscar pets: " + e.getMessage());
        }
    }

    private int exibirMenuBuscaCriterio(Scanner sc, InputValidator inputValidator) {

        System.out.println("Escolha os critérios de busca");
        System.out.println("1 - Nome ou sobrenome");
        System.out.println("2 - Sexo");
        System.out.println("3 - Idade");
        System.out.println("4 - Peso");
        System.out.println("5 - Raça");
        System.out.println("6 - Endereço");
        System.out.println("0 - para buscar só pelo tipo de animal");
        int respostaEscolha = inputValidator.validaQuantidadeOpcoes(sc, 0, 6);
        return respostaEscolha;
    }

    private void listarPetsFiltrados(List<Pet> petsFiltrados) {

        if (petsFiltrados.isEmpty()) {
            System.out.println("Não encontramos nenhum pet");
        } else {
            int contador = 1;
            for (Pet pets : petsFiltrados) {
                System.out.println(contador + ". " + pets);
                contador++;
            }
        }
    }
}

