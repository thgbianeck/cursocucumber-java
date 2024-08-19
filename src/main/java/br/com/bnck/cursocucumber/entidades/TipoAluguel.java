package br.com.bnck.cursocucumber.entidades;

public enum TipoAluguel {
    EXTENDIDO("extendido"),
    COMUM("comum"),
    SEMANAL("semanal");

    private final String nome;

    TipoAluguel(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static TipoAluguel fromNome(String nome) {
        for (TipoAluguel tipo : TipoAluguel.values()) {
            if (tipo.getNome().equalsIgnoreCase(nome)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de plano inválido: " + nome);
    }

}