package services;

import model.Pet;
import model.PetEndereco;
import repository.Filerepository;
import utils.InputValidator;

import java.util.Scanner;

public class CadastrarPet {
    public static final String NAO_INFORMADO = "NÃO INFORMADO";

    public void cadastrarPet() {
        Scanner sc = new Scanner(System.in);
        Pet pet = new Pet();
        PetEndereco petEndereco = new PetEndereco();
        Filerepository filerepository = new Filerepository();
        InputValidator inputValidator = new InputValidator();

        filerepository.lerLinhaEspecifica(1);
        pet.setNomePet(inputValidator.validarNome(sc));

        filerepository.lerLinhaEspecifica(2);
        System.out.println("1 Cachorro | 2 Gato");
        pet.setPetTipoEscolha(inputValidator.validaUmOuDois(sc));

        filerepository.lerLinhaEspecifica(3);
        System.out.println("1 Masculino | 2 Feminino");
        pet.setPetSexoEscolha(inputValidator.validaUmOuDois(sc));

        filerepository.lerLinhaEspecifica(4);
        System.out.println("i. Número da casa");
        petEndereco.setNumeroCasa(sc.nextLine());

        System.out.println("ii. Cidade");
        petEndereco.setCidade(sc.nextLine());

        System.out.println("iii. Rua");
        petEndereco.setRua(sc.nextLine());

        pet.setPetEndereco(petEndereco);

        filerepository.lerLinhaEspecifica(5);
        pet.setIdade(inputValidator.validaIdade(sc));

        filerepository.lerLinhaEspecifica(6);
        pet.setPeso(inputValidator.validaPeso(sc));

        filerepository.lerLinhaEspecifica(7);
        pet.setRaca(inputValidator.validaRaca(sc));

        filerepository.salvarArquivoPet(pet);
    }
}
