package repository;

import model.Pet;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Filerepository {
    private static final String FORMULARIO = "C:\\Projects_java\\DevDojo\\desafioCadastro\\src\\data\\formulario";

    public void criarFile() {
        File file = new File(FORMULARIO);
        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fw)){
                 bw.write("1 - Qual o nome e sobrenome do pet?\n2 - Qual o tipo do pet (Cachorro/Gato)?\n3 - Qual o sexo do animal?\n4 - Qual endereço e bairro que ele foi encontrado?\n5 - Qual a idade aproximada do pet?\n6 - Qual o peso aproximado do pet?\n7 - Qual a raça do pet?");
                 bw.flush();
        } catch (IOException e ){
            throw new RuntimeException(e);
        }
    }

    public void lerFile() {
        try (FileReader fr = new FileReader(FORMULARIO);
        BufferedReader br = new BufferedReader(fr)){
            String linha;
            while ((linha = br.readLine()) != null){
                System.out.println(linha);
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static String lerLinhaEspecifica(int numeroLinha) {
        try (FileReader fr = new FileReader(FORMULARIO);
        BufferedReader br = new BufferedReader(fr)){
            String linha;
            int cont = 1;

            while ((linha = br.readLine()) != null) {
                if (cont == numeroLinha){
                    System.out.println(linha);
                    return linha;
                }
                cont ++;
            }
            return linha;
        } catch (IOException e){
            throw new RuntimeException(e);
        }
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
        } catch (IOException e){
            System.out.println("Erroz ");
        }

    }
}
