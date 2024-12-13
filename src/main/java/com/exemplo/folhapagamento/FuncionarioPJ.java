package com.exemplo.folhapagamento;

public class FuncionarioPJ extends FuncionarioBase {
    public FuncionarioPJ(String nome, String cargo, double salarioBruto) {
        super(nome, cargo, salarioBruto);
    }

    @Override
    public double calcularSalarioLiquido() {
        // Funcionário PJ não tem descontos, retorna o salário bruto diretamente
        return salarioBruto;
    }

    @Override
    public String getDetalhes() {
        return super.getDetalhes() + " (Pessoa Jurídica - PJ)";
    }
}
