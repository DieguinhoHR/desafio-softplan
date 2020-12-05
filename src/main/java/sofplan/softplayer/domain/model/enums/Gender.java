package sofplan.softplayer.domain.model.enums;

public enum Gender {
    MALE(1, "Masculino"),
    FEMALE(2, "Feminino");

    private int cod;
    private String description;

    private Gender(int cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public int getCod() {
        return cod;
    }

    public String getDescription() {
        return this.description;
    }

    public static Gender toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (Gender x : Gender.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}
