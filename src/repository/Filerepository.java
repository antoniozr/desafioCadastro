package repository;

import java.io.*;

public class Filerepository {
    String fommulario = "C:\\Projects_java\\DevDojo\\desafioCadastro\\src\\data\\formulario";
    public void criarFile() {
        File file = new File(fommulario);
        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fw)){
                 bw.write("1 - Qual o nome e sobrenome do pet?\n2 - Qual o tipo do pet (Cachorro/Gato)?\n3 - Qual o sexo do animal?\n4 - Qual endereço e bairro que ele foi encontrado?\n5 - Qual a idade aproximada do pet?\n6 - Qual o peso aproximado do pet?\n7 - Qual a raça do pet?");
                 bw.flush();
        } catch (IOException e ){
            throw new RuntimeException(e);
        }
    }

    public void lerFile() {
        try (FileReader fr = new FileReader(fommulario);
        BufferedReader br = new BufferedReader(fr)){
            String linha;
            while ((linha = br.readLine()) != null){
                System.out.println(linha);
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
