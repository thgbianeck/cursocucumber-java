package br.com.bnck.cursocucumber.steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.junit.jupiter.api.Assertions;

import br.com.bnck.cursocucumber.entidades.Filme;
import br.com.bnck.cursocucumber.entidades.NotaAluguel;
import br.com.bnck.cursocucumber.entidades.TipoAluguel;
import br.com.bnck.cursocucumber.servicos.AluguelService;
import br.com.bnck.cursocucumber.utils.DateUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class AlugarFilmeSteps {

    private Filme filme;
	private final AluguelService aluguel = new AluguelService();
	private NotaAluguel nota;
	private String erro;
	private TipoAluguel tipoAluguel;

    @Dado("um filme com estoque de {int} unidades")
    public void umFilmeComEstoqueDeUnidades(Integer arg1) {
        filme = new Filme();
		filme.setEstoque(arg1);
    }

    @Dado("um filme")
    public void umFilme(DataTable table) {
        Map<String, String> map = table.asMap(String.class, String.class);
		filme = new Filme();
		filme.setEstoque(Integer.valueOf(map.get("estoque")));
		filme.setAluguel(Double.valueOf(map.get("preco")));
		String tipo = map.get("tipo");
		tipoAluguel = tipo.equals("semanal") ? TipoAluguel.SEMANAL
				: tipo.equals("extendido") ? TipoAluguel.EXTENDIDO : TipoAluguel.COMUM;
    }

    @Quando("alugar")
    public void alugar() {
        try {
			nota = aluguel.alugar(filme, tipoAluguel);
		} catch (RuntimeException e) {
			erro = e.getMessage();
		}
    }

    @Então("o preço do aluguel será {moeda}")
    public void oPreçoDoAluguelSeráR$(Double valor) {
        Assertions.assertEquals(valor, nota.getPreco());
    }

    @Então("a data de entrega será em {int} dia")
    public void aDataDeEntregaSeráEmDia(Integer int1) {
    }

    @Então("o estoque do filme será {int} unidade")
    public void oEstoqueDoFilmeSeráUnidade(Integer int1) {
        Assertions.assertEquals(int1, filme.getEstoque());
    }

    

    @Então("não será possível por falta de estoque")
    public void nãoSeráPossívelPorFaltaDeEstoque() {
        Assertions.assertEquals("Filme sem estoque", erro);
    }

    @Dado("que o preço do aluguel seja {moeda}")
    public void queOPreçoDoAluguelSejaR$(Double valor) {
        filme.setAluguel(valor);
    }

    @Dado("que o tipo do aluguel seja {tipoAluguel}")
    public void queOTipoDoAluguelSeja(TipoAluguel tipo) {
        tipoAluguel = tipo.getNome().equals("semanal") ? TipoAluguel.SEMANAL
				: tipo.getNome().equals("extendido") ? TipoAluguel.EXTENDIDO : TipoAluguel.COMUM;
    }

    @Então("a data de entrega será em {int} dias")
    public void aDataDeEntregaSeráEmDias(Integer arg1) {
        Date dataEsperada = DateUtils.obterDataDiferencaDias(arg1);
		Date dataReal = nota.getDataEntrega();

		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		Assertions.assertEquals(format.format(dataEsperada), format.format(dataReal));
    }

    @Então("a pontuação será de {int} pontos")
    public void aPontuaçãoSeráDePontos(Integer arg1) {
        Assertions.assertEquals(arg1, nota.getPontuacao());
    }

}
