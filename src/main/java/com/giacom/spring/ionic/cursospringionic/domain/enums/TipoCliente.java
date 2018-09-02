package com.giacom.spring.ionic.cursospringionic.domain.enums;

public enum TipoCliente {

    PESSOA_FISICA(1, "Pessoa Física"),
    PESSOA_JURIDICA(2, "Pessoa Jurídica");

    private int cod;
    private String descricao;

    TipoCliente(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public static TipoCliente toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (TipoCliente o : TipoCliente.values()) {
            if (cod.equals(o.getCod())) {
                return o;
            }
        }
        throw new IllegalArgumentException("Tipo inválido!");
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }
}
