package trab3;

import javax.swing.*;

    public class Janela extends JFrame {

        private CriaLista criaLista;
        private JPanel panel;
        JButton btn;

        public Janela(){
            setTitle("Tarefas");
            setSize(400,500);
            configurarJanela();
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setVisible(true);
        }
    
        private void configurarJanela() {
            panel = new JPanel();

            panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
            JScrollPane scrollPanel = new JScrollPane(panel);

            JLabel label = new JLabel("Cadastro de Tarefas");
            label.setHorizontalTextPosition(10);

            criaLista = new CriaLista();
            btn = new JButton("Nova Tarefa");
            btn.setHorizontalTextPosition(AbstractButton.RIGHT);

            panel.add(btn);
            panel.add(Box.createVerticalStrut(30));
            panel.add(label);
            popularLista();
            add(scrollPanel);
        }

        private void popularLista(){
            for(String str : criaLista.listar()){
                panel.add(ItemLista(str));
                panel.add(Box.createVerticalStrut(20));
            }
        }

        private JPanel ItemLista(String item){
            JPanel panel = new JPanel();
            JLabel label = new JLabel(item);
            JCheckBox CheckBox = new JCheckBox("");
            CheckBox.setSelected(true);
    
            panel.setBorder(BorderFactory.createEtchedBorder());
            panel.add(label);
            panel.add(CheckBox);
            return panel;
        }
    }


