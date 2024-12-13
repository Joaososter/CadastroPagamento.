package com.exemplo.folhapagamento;

public class Main {
    public static void main(String[] args) {
        FolhaPagamento folha = new FolhaPagamento();

        Funcionario clt = new FuncionarioCLT("João", "Analista", 3000);
        Funcionario pj = new FuncionarioCLT("Maria", "Desenvolvedora", 5000);

        folha.adicionarFuncionario(clt);
        folha.adicionarFuncionario(pj);

        folha.exibirRelatorio();
    }
}
