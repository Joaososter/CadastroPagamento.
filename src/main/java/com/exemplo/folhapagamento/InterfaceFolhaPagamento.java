package com.exemplo.folhapagamento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceFolhaPagamento extends JFrame {
    private JTextField txtNome;
    private JTextField txtSalarioBruto;
    private JComboBox<String> cbCargo;
    private JComboBox<String> cbTipoFuncionario;
    private JTextArea txtRelatorio;
    private JButton btnAdicionar, btnRelatorio, btnLimpar;
    private FolhaPagamento folhaPagamento;

    public InterfaceFolhaPagamento() {
        // Inicializando a folha de pagamento
        folhaPagamento = new FolhaPagamento();

        // Configurações da janela principal
        setTitle("Sistema de Folha de Pagamento");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel superior: Entrada de dados
        JPanel panelEntrada = new JPanel(new GridLayout(4, 2, 10, 10));
        panelEntrada.setBorder(BorderFactory.createTitledBorder("Cadastro de Funcionário"));

        panelEntrada.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        panelEntrada.add(txtNome);

        panelEntrada.add(new JLabel("Cargo:"));
        cbCargo = new JComboBox<>(new String[]{"Analista", "Desenvolvedor", "Gerente", "Estagiário", "Administrador"});
        panelEntrada.add(cbCargo);

        panelEntrada.add(new JLabel("Salário Bruto:"));
        txtSalarioBruto = new JTextField();
        panelEntrada.add(txtSalarioBruto);

        panelEntrada.add(new JLabel("Tipo de Funcionário:"));
        cbTipoFuncionario = new JComboBox<>(new String[]{"CLT", "PJ", "Estagiário"});
        panelEntrada.add(cbTipoFuncionario);

        add(panelEntrada, BorderLayout.NORTH);

        // Painel central: Relatório
        txtRelatorio = new JTextArea();
        txtRelatorio.setEditable(false);
        txtRelatorio.setBorder(BorderFactory.createTitledBorder("Relatório"));
        add(new JScrollPane(txtRelatorio), BorderLayout.CENTER);

        // Painel inferior: Botões
        JPanel panelBotoes = new JPanel(new FlowLayout());
        btnAdicionar = new JButton("Adicionar Funcionário");
        btnRelatorio = new JButton("Exibir Relatório");
        btnLimpar = new JButton("Limpar Dados");

        panelBotoes.add(btnAdicionar);
        panelBotoes.add(btnRelatorio);
        panelBotoes.add(btnLimpar);

        add(panelBotoes, BorderLayout.SOUTH);

        // Ações dos botões
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarFuncionario();
            }
        });

        btnRelatorio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirRelatorio();
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparDados();
            }
        });

        setVisible(true);
    }

    private void adicionarFuncionario() {
        try {
            String nome = txtNome.getText().trim();
            String cargo = (String) cbCargo.getSelectedItem(); // Cargo selecionado do ComboBox
            double salarioBruto = Double.parseDouble(txtSalarioBruto.getText().trim());
            String tipo = (String) cbTipoFuncionario.getSelectedItem();

            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, preencha o nome!");
                return;
            }

            Funcionario funcionario;
            switch (tipo) {
                case "CLT":
                    funcionario = new FuncionarioCLT(nome, cargo, salarioBruto);
                    break;
                case "PJ":
                    funcionario = new FuncionarioPJ(nome, cargo, salarioBruto);
                    break;
                case "Estagiário":
                    funcionario = new FuncionarioEstagiario(nome, cargo, salarioBruto);
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Tipo de funcionário inválido!");
                    return;
            }

            folhaPagamento.adicionarFuncionario(funcionario);
            JOptionPane.showMessageDialog(this, "Funcionário adicionado com sucesso!");
            limparCamposEntrada();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Salário deve ser um número válido!");
        }
    }

    private void exibirRelatorio() {
        StringBuilder relatorio = new StringBuilder();
        for (Funcionario f : folhaPagamento.getFuncionarios()) {
            relatorio.append(f.getDetalhes())
                    .append("\nSalário Líquido: R$ ")
                    .append(String.format("%.2f", f.calcularSalarioLiquido()))
                    .append("\n-------------------\n");
        }
        txtRelatorio.setText(relatorio.toString());
    }

    private void limparDados() {
        folhaPagamento = new FolhaPagamento(); // Reinicia a lista de funcionários
        txtRelatorio.setText("");
        JOptionPane.showMessageDialog(this, "Todos os dados foram limpos!");
    }

    private void limparCamposEntrada() {
        txtNome.setText("");
        txtSalarioBruto.setText("");
        cbCargo.setSelectedIndex(0);
        cbTipoFuncionario.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        new InterfaceFolhaPagamento();
    }
}
