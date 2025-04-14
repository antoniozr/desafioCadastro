package model;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Pet {
    private String nomePet;
    private PetTipo petTipo;
    private PetSexo petSexo;
    private PetEndereco petEndereco;
    private String idade;
    private String peso;
    private String raca;


    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    public PetTipo getPetTipo() {
        return petTipo;
    }

    public void setPetTipoEscolha(int escolha) {
        if (escolha == 1) {
            setPetTipo(PetTipo.CACHORRO);
        } else if (escolha == 2) {
            setPetTipo(PetTipo.GATO);
        } else {
            System.out.println("Somente 1 ou 2 são validos");
        }
    }

    public void setPetTipo(PetTipo petTipo) {
        this.petTipo = petTipo;
    }

    public PetSexo getPetSexo() {
        return petSexo;
    }

    public void setPetSexoEscolha(int escolha) {
        if (escolha == 1) {
            setPetSexo(PetSexo.MACHO);
        } else if (escolha == 2) {
            setPetSexo(PetSexo.FEMEA);
        } else {
            System.out.println("Somente 1 ou 2 são validos");
        }
    }

    public void setPetSexo(PetSexo petSexo) {
        this.petSexo = petSexo;
    }

    public PetEndereco getPetEndereco() {
        return petEndereco;
    }

    public void setPetEndereco(PetEndereco petEndereco) {
        this.petEndereco = petEndereco;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    @Override
    public String toString() {
        return String.format(
                "%s - %s - %s - %s, %s - %s - %s - %s - %s",
                nomePet, petTipo, petSexo, petEndereco.getRua(), petEndereco.getNumeroCasa(),
                petEndereco.getCidade(), idade, peso, raca);
    }


    public void salvarArquivoPet(Pet pet) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
        String dateTimeFormater = now.format(formatter);
        String nameFormater = pet.getNomePet().replace(" ", "").toUpperCase();

        String nameArquivo = dateTimeFormater + "-" + nameFormater;
        String enderecoArquivo = "C:\\Projects_java\\DevDojo\\desafioCadastro\\src\\petsCadastrados\\" + nameArquivo + ".txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(enderecoArquivo))) {
            bw.write("1 - " + pet.getNomePet());
            bw.newLine();
            bw.write("2 - " + pet.getPetTipo());
            bw.newLine();
            bw.write("3 - " + pet.getPetSexo());
            bw.newLine();
            bw.write("4 - " + pet.getPetEndereco().getRua() + ", " + pet.getPetEndereco().getNumeroCasa() + ", " + pet.getPetEndereco().getCidade());
            bw.newLine();
            bw.write("5 - " + pet.getIdade() + " anos");
            bw.newLine();
            bw.write("6 - " + pet.getPeso() + "kg");
            bw.newLine();
            bw.write("7 - " + pet.getRaca());
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo " + e.getMessage());
        }

    }

    public static final String PETSCADASTRADOS = "C:\\Projects_java\\DevDojo\\desafioCadastro\\src\\petsCadastrados";


    public static List<Pet> exibirPetsSalvos() {
        List<Pet> pets = new ArrayList<>();
        File pasta = new File(PETSCADASTRADOS);

        if (pasta.isDirectory()) {
            File[] arquivos = pasta.listFiles();

            if (arquivos != null) {
                for (File arquivo : arquivos) {
                    try (FileReader fl = new FileReader(arquivo);
                         BufferedReader br = new BufferedReader(fl)) {
                        Pet pet = new Pet();
                        PetEndereco petEndereco = new PetEndereco();

                        pet.setNomePet(br.readLine().split(" - ")[1]);
                        pet.setPetTipo(PetTipo.valueOf(br.readLine().split(" - ")[1].toUpperCase()));
                        pet.setPetSexo(PetSexo.valueOf(br.readLine().split(" - ")[1].toUpperCase()));

                        String partesEndereco = br.readLine().split(" - ")[1];
                        String[] partes = partesEndereco.split(", ");

                        petEndereco.setRua(partes[0].trim());
                        petEndereco.setNumeroCasa(partes[1].trim());
                        petEndereco.setCidade(partes[2].trim());

                        pet.setPetEndereco(petEndereco);

                        pet.setIdade(br.readLine().split(" - ")[1]);
                        pet.setPeso(br.readLine().split(" - ")[1]);
                        pet.setRaca(br.readLine().split(" - ")[1]);


                        pets.add(pet);
                    } catch (FileNotFoundException e) {
                        System.out.println("Erro: " + e.getMessage());
                    } catch (IOException e) {
                        System.out.println("Erro ao ler arquivo : " + arquivo.getName());
                    }
                }
            }
        }
        return pets;
    }
}
