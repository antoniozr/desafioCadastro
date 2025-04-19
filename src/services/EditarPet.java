package services;

import model.Pet;
import model.PetEndereco;
import utils.InputValidator;

import java.util.List;
import java.util.Scanner;

public class EditarPet {
    BuscarPetService buscarPetService = new BuscarPetService();
    Scanner sc = new Scanner(System.in);
    InputValidator inputValidator = new InputValidator();

    public void editarPet() {

        List<Pet> petslist;
        do {
            petslist = buscarPetService.buscarPet();
            if (petslist.isEmpty()) {
                System.out.println("Nenhum pet encontrado!, tente novamente!");
            }
        } while (petslist.isEmpty());

        System.out.println("Digite o número do pet que você deseja alterar");
        int numeroPetEdicao = inputValidator.validaQuantidadeOpcoes(sc,1,petslist.size());

        Pet petSelecionado = petslist.get(numeroPetEdicao - 1);
        String nomePetExcluido = petSelecionado.getNomePet();
        PetEndereco petEndereco = petSelecionado.getPetEndereco();

        System.out.println(petSelecionado);

        System.out.println("Digite o novo nome do pet (" + petSelecionado.getNomePet() + ") :");
        String nome = sc.nextLine();
        if (nome.trim().isEmpty()){
            System.out.println("Nome mantido " + petSelecionado.getNomePet());
        } else {
            petSelecionado.setNomePet(nome);
            System.out.println("Nome atualizada: " + petSelecionado.getNomePet());
        }

        
        System.out.println("Digite o novo endereço");
        System.out.println("i. Número da casa");
        String numeroCasaEndereco = sc.nextLine();
        if (numeroCasaEndereco.trim().isEmpty()) {
            System.out.println("N° da casa mantida " + petEndereco.getNumeroCasa());
        } else {
            petEndereco.setRua(numeroCasaEndereco);
            System.out.println("N° da casa alterada: " + petEndereco.getNumeroCasa());

        }

        System.out.println("ii. Cidade");
        String cidadeEndereco = sc.nextLine();
        if (cidadeEndereco.trim().isEmpty()) {
            System.out.println("Cidade mantida: " + petEndereco.getCidade());
        } else {
            petEndereco.setCidade(cidadeEndereco);
            System.out.println("Cidade alterada: " + petEndereco.getCidade());
        }

        System.out.println("iii. Rua");
        String ruaEndereco = sc.nextLine();
        if (ruaEndereco.trim().isEmpty()) {
            System.out.println("Rua mantida " + petEndereco.getRua());
        } else {
            petEndereco.setRua(ruaEndereco);
            System.out.println("Rua alterada: " + petEndereco.getRua());
        }

        petSelecionado.setPetEndereco(petEndereco);


        System.out.println("Digite a nova idade");
        String novaIdadePet = sc.nextLine();
        if (novaIdadePet.trim().isEmpty()) {
            String idadeLimpa = petSelecionado.getIdade().split(" ")[0]; // Remove "Anos"
            System.out.println("Idade mantida: " + idadeLimpa);
            petSelecionado.setIdade(idadeLimpa);
        } else {
            petSelecionado.setIdade(novaIdadePet);
            System.out.println("Idade atualizada: " + petSelecionado.getIdade());
        }

        System.out.println("Digite o novo peso");
        String novoPesoPet = sc.nextLine();
        System.out.println("peso inicial " + petSelecionado.getPeso());
        if (novoPesoPet.trim().isEmpty()) {
            String pesoLimpo = petSelecionado.getPeso().split(" ")[0]; // Remove "Kg"
            System.out.println("Peso mantido: " + petSelecionado.getPeso());
            petSelecionado.setPeso(pesoLimpo);
        } else {
            petSelecionado.setPeso(novoPesoPet);
            System.out.println("Peso atualizado: " + petSelecionado.getPeso());
        }

        System.out.println("Digite a nova raça");
        String novaRacaPet = sc.nextLine();
        if (novaRacaPet.trim().isEmpty()) {
            System.out.println("Raça mantida: " + petSelecionado.getRaca());
        } else {
            petSelecionado.setRaca(novaRacaPet);
            System.out.println("Raça atualizada: " + petSelecionado.getRaca());
        }

        petSelecionado.deletarPet(nomePetExcluido);
        petSelecionado.salvarArquivoPet(petSelecionado);
        System.out.println("Pet alterado com sucesso!");

    }
}
