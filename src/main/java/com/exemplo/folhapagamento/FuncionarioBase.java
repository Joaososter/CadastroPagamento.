package com.exemplo.folhapagamento;

public abstract class FuncionarioBase implements Funcionario {
    protected String nome;
    protected String cargo;
    protected double salarioBruto;

    public FuncionarioBase(String nome, String cargo, double salarioBruto) {

        this.nome = nome;
        this.cargo = cargo;
        this.salarioBruto = salarioBruto;
    }


    @Override
    public String getDetalhes() {
        return "Nome: " + nome + ". cargo: " + cargo + ", Salario Bruto: R$ " +salarioBruto;

    }
}
