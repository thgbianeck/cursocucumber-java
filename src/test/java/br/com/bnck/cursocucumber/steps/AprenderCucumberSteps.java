package br.com.bnck.cursocucumber.steps;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Assertions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class AprenderCucumberSteps {

    private int contador = 0;
    private Date entrega = new Date();

    @Dado("que criei o arquivo corretamente")
    public void queCrieiOArquivoCorretamente() throws Throwable {
        // Implementação
    }

    @Quando("executá-lo")
    public void executáLo() throws Throwable {
        // Implementação
    }

    @Então("a especificação deve finalizar com sucesso")
    public void aEspecificaçãoDeveFinalizarComSucesso() throws Throwable {
        // Implementação
    }
    

    @Dado("que o valor do contador é {int}")
    public void queOValorDoContadorÉ(int valor) throws Throwable {
        contador = valor;
    }

    @Quando("eu incrementar em {int}")
    public void euIncrementarEm(int valor) throws Throwable {
        contador = contador + valor;
    }

    @Então("o valor do contador será {int}")
    public void oValorDoContadorSerá(int valor) throws Throwable {
        Assertions.assertEquals(valor, contador);
    }

    @Dado("que a entrega é dia {data}")
    public void queAEntregaÉDia(Date data) throws Throwable {
        entrega = data;
    }

    @Quando("a entrega atrasar em {int} {unTempo}")
    public void aEntregaAtrasarEm(int valor, String unidade) throws Throwable {
        Calendar cal = Calendar.getInstance();
        cal.setTime(entrega);
        if (unidade.equals("dias")) {
            cal.add(Calendar.DAY_OF_MONTH, valor);
        } else if (unidade.equals("meses")) {
            cal.add(Calendar.MONTH, valor);
        }
        entrega = cal.getTime();
    }

    @Então("a entrega será efetuada em {data}")
    public void aEntregaSeráEfetuadaEm(Date data) throws Throwable {
        Assertions.assertEquals(data, entrega);
    }

    @Dado("que o ticket{especial} é {ticket}")
    public void queOTicketÉAF(String especial, String ticket) throws Throwable {
        // Implementação
    }

    @Dado("que o valor da passagem é {moeda}")
    public void queOValorDaPassagemÉ(Double valor) throws Throwable {
        System.out.println(valor);
    }

    @Dado("que o nome do passageiro é {passageiro}")
    public void queONomeDoPassageiroÉ(String nome) throws Throwable {
        // Implementação
    }

    @Dado("que o telefone do passageiro é {telefonePassageiro}")
    public void queOTelefoneDoPassageiroÉ(String telefone) throws Throwable {
        // Implementação
    }

    @Dado("criar os steps")
    public void criarOsSteps() throws Throwable {
        // Implementação
    }

    @Dado("o teste vai funcionar")
    public void oTesteVaiFuncionar() throws Throwable {
        // Implementação
    }

    @Dado("que o ticket é CD123")
    public void queOTicketÉCD123() {
        // Implementação
    }

    @Dado("que o ticket é AG1234")
    public void queOTicketÉAG1234() {
        // Implementação
    }
}
