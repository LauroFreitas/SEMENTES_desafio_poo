package br.tec.db.servicoguincho.simulador;

import br.tec.db.servicoguincho.simulador.cargas.EstadoConservacao;
import br.tec.db.servicoguincho.simulador.cargas.TipoVeiculo;

public class SimuladorDeOrcamentoImpl implements SimuladorDeOrcamento {
    @Override
    public double calcularCustoTotal(Veiculo veiculo, Trajeto trajeto) throws IllegalArgumentException {
        if ((veiculo.getTipo() == TipoVeiculo.CARRO || veiculo.getTipo() == TipoVeiculo.MINIVAN) && veiculo.getEstado() == EstadoConservacao.QUEBRADO) {
            return trajeto.getDistanciaEmKM() * 2;
        }
        else if ((veiculo.getTipo() == TipoVeiculo.CARRO || veiculo.getTipo() == TipoVeiculo.MINIVAN) && veiculo.getEstado() == EstadoConservacao.NOVO) {
            return trajeto.getDistanciaEmKM() * 5;
        }
        else if (veiculo.getTipo() == TipoVeiculo.ONIBUS || veiculo.getTipo() == TipoVeiculo.CAMINHAO) {
            return trajeto.getDistanciaEmKM() * 10;
        }
        else{
            throw new IllegalArgumentException("Erro, não foi possível calcular o frete");
        }
    }
}
