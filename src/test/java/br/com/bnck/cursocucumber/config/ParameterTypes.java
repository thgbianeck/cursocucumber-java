package br.com.bnck.cursocucumber.config;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.bnck.cursocucumber.entidades.TipoAluguel;
import io.cucumber.java.ParameterType;

public class ParameterTypes {

	@ParameterType(".*")
	public Date data(String s) throws Throwable {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return format.parse(s);
	}

    @ParameterType("R\\$\\s*\\d+(?:,\\d{2})?")
    public Double moeda(String valor) {
        return Double.valueOf(valor.replace("R$", "").replace(",", ".").trim());
    }

    @ParameterType("A.\\d{3}")
    public String ticket(String ticket) {
        return ticket;
    }

	@ParameterType("( especial)?")
    public String especial(String ticket) {
        return ticket;
    }

    @ParameterType("\"(.{5,20})\"")
    public String passageiro(String nome) {
        return nome;
    }

    @ParameterType("(9\\d{3}-\\d{4})")
    public String telefonePassageiro(String telefone) {
        return telefone;
    }

	@ParameterType("(dia|dias|mes|meses)")
    public String unTempo(String tempo) {
        return tempo;
    }

	@ParameterType("extendido|comum|semanal")
    public TipoAluguel tipoAluguel(String tipoPlano) {
        return TipoAluguel.fromNome(tipoPlano);
    }
	

}
