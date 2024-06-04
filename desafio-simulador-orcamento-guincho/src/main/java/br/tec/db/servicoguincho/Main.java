package br.tec.db.servicoguincho;

import br.tec.db.servicoguincho.simulador.*;
import br.tec.db.servicoguincho.simulador.cargas.TipoVeiculo;

public class Main {

    public static void main(String[] args) {
        // Cenário 1 -  carro novo - do centro para o bairro A
        SimuladorDeOrcamento simulador = new SimuladorDeOrcamentoImpl(); // instanciar implementação de simulaodr
        Veiculo carroNovo = new CarroNovo(); // instanciar implementação de veiculo
        Trajeto centroParaBairroA = new centroParaBairroA(); // instanciar trajeto
        double custoCenario1 = simulador.calcularCustoTotal(carroNovo, centroParaBairroA);
        System.out.println("Cenário 1 - Custo Total do Serviço: R$" + custoCenario1);
    }
}
