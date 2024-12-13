package com.exemplo.folhapagamento;

public class FuncionarioCLT extends FuncionarioBase {
    public FuncionarioCLT(String nome, String cargo, double salarioBruto) {
        super(nome, cargo, salarioBruto);
    }

    @Override
    public double calcularSalarioLiquido() {
        double inss = salarioBruto * 0.11;
        double irrf = salarioBruto > 2500 ? salarioBruto * 0.075 : 0;
        return salarioBruto - inss - irrf;
    }
}
