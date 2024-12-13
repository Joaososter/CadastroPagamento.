package com.exemplo.folhapagamento;

public class FuncionarioEstagiario extends FuncionarioBase {
    public FuncionarioEstagiario(String nome, String cargo, double salarioBruto) {
        super(nome, cargo, salarioBruto);
    }

    @Override
    public double calcularSalarioLiquido() {
        // Estagiário não tem descontos de impostos
        return salarioBruto;
    }

    @Override
    public String getDetalhes() {
        return super.getDetalhes() + " (Estagiário)";
    }
}
