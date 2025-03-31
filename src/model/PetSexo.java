package model;

public enum PetSexo {
    MACHO("MACHO"),
    FEMEA("FEMEA");

     String petSexo;

    PetSexo(String descricao) {
        this.petSexo = descricao;
    }

    @Override
    public String toString() {
        return petSexo;
    }
}
