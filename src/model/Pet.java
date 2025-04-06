package model;

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

    public void setPetTipoEscolha(int escolha){
        if (escolha == 1){
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
        if (escolha == 1 ) {
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
        return "NomePet: " + nomePet  +
                "\npetTipo: " + petTipo +
                "\npetSexo: " + petSexo +
                "\npetEndereco: " + petEndereco +
                "\nidade:" + idade +
                "\npeso:" + peso +
                "\nraca:" + raca;
    }
}
