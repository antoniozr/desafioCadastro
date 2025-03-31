package model;

public class Pet {
    private String nomePet;
    private PetTipo tipoPet;
    private PetSexo petSexo;
    private PetEndereco petEndereco;
    private double idade;
    private double peso;
    private String raca;

    public Pet(String nomePet, PetTipo tipoPet, PetSexo petSexo, PetEndereco petEndereco, double idade, double peso, String raca) {
        this.nomePet = nomePet;
        this.tipoPet = tipoPet;
        this.petSexo = petSexo;
        this.petEndereco = petEndereco;
        this.idade = idade;
        this.peso = peso;
        this.raca = raca;
    }

    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    public PetTipo getTipoPet() {
        return tipoPet;
    }

    public void setTipoPet(PetTipo tipoPet) {
        this.tipoPet = tipoPet;
    }

    public PetSexo getPetSexo() {
        return petSexo;
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

    public double getIdade() {
        return idade;
    }

    public void setIdade(double idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }
}
