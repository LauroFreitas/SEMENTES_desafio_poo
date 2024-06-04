package br.tec.db.servicoguincho.simulador;

import br.tec.db.servicoguincho.simulador.cargas.EstadoConservacao;
import br.tec.db.servicoguincho.simulador.cargas.TipoVeiculo;

public class CarroNovo implements Veiculo {
    @Override
    public TipoVeiculo getTipo() {
       return TipoVeiculo.CARRO;
    }

    @Override
    public EstadoConservacao getEstado() {
        return EstadoConservacao.NOVO;
    }
}
