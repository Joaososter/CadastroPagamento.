package com.exemplo.folhapagamento;

import java.util.ArrayList;
import java.util.List;

public class FolhaPagamento {
    private List<Funcionario> funcionarios;

    // Construtor para inicializar a lista de funcionários
    public FolhaPagamento() {
        funcionarios = new ArrayList<>();
    }

    // Método para adicionar um funcionário à lista
    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    // Método para retornar a lista de funcionários
    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    // Método para exibir o relatório dos funcionários e salários
    public void exibirRelatorio() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }

        System.out.println("Relatório da Folha de Pagamento:");
        for (Funcionario f : funcionarios) {
            System.out.println(f.getDetalhes());
            System.out.println("Salário Líquido: R$ " + String.format("%.2f", f.calcularSalarioLiquido()));
            System.out.println("---------------------------");
        }
    }
}
