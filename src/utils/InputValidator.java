package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidator {
    public static final String NAO_INFORMADO = "NÃO INFORMADO";

    public String validarNome(Scanner sc) {
        try {
            String nomeFornecido = sc.nextLine();
            if (nomeFornecido.isEmpty()) {
                nomeFornecido = NAO_INFORMADO;
                return nomeFornecido;
            } else if (!nomeFornecido.matches("^[A-Za-z ]+$")) {
                throw new IllegalArgumentException("Caracteres especiais e números não são permitidos");
            }
            String[] partes = nomeFornecido.split(" ");
            if (partes.length < 2 || partes[0].isEmpty() || partes[1].isEmpty()) {
                throw new IllegalArgumentException("Precisa ter nome e sobrenome");
            }
            return nomeFornecido;
        } catch (IllegalArgumentException e) {
            System.out.println("Entrada invalida " + e.getMessage());
            return validarNome(sc);
        }
    }

    public int validaUmOuDois(Scanner sc) {
        try {
            int numeroValido = sc.nextInt();
            sc.nextLine();

            if (numeroValido == 1 || numeroValido == 2) {
                return numeroValido;
            } else {
                throw new IllegalArgumentException("Somente o número 1 ou 2 são validos");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro: Digite apenas 1 ou 2 ");
            sc.nextLine();
            return validaUmOuDois(sc);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
            return validaUmOuDois(sc);
        }
    }

    public String validaIdade(Scanner sc) {
        try {
            String idadeRecebida = sc.nextLine();
            if (idadeRecebida.isEmpty()) {
                idadeRecebida = NAO_INFORMADO;
                return idadeRecebida;
            } else if (!idadeRecebida.matches("^[0-9.,]+$")) {
                throw new IllegalArgumentException("Sómente números são validos");
            }
            double petIdadeRecebida = Double.parseDouble(idadeRecebida.replace(",", "."));
            if (petIdadeRecebida > 20) {
                throw new IllegalArgumentException("idade maiores que 20 são invalidas");
            }
            return String.valueOf(petIdadeRecebida);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage() + " Tente novemente");
            return validaIdade(sc);
        }
    }

    public String validaPeso(Scanner sc) {
        try {
            String pesoRecebido = sc.nextLine();
            if (pesoRecebido.isEmpty()) {
                pesoRecebido = NAO_INFORMADO;
            }else if (!pesoRecebido.matches("^[0-9.,]+$")) {
                throw new IllegalArgumentException("Somente números são validos");
            }
            double petPesoRecebido = Double.parseDouble(pesoRecebido.replace(",", "."));
            if (petPesoRecebido < 0.5 || petPesoRecebido > 60) {
                throw new IllegalArgumentException("O Peso deve estár no intervalo de 0.5 a 60 kg");
            } return String.valueOf(petPesoRecebido);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage() + " Tente novamente");
            return validaPeso(sc);
        }
    }

    public String validaRaca(Scanner sc) {
        try {
            String racaRecebida = sc.nextLine();
            if (racaRecebida.isEmpty()) {
                racaRecebida = NAO_INFORMADO;
            }else if (!racaRecebida.matches("^[A-Za-z]+$")) {
                throw new IllegalArgumentException("Caracteres especiais e números não são permitidos");
            } return racaRecebida;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage() + " Tente novamente");
            return validaRaca(sc);
        }
    }
}

