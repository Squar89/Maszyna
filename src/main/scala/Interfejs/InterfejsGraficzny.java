package Interfejs;

import Model.Maszyna;
import Wyjątki.*;
import java.io.IOException;
import java.util.List;

import Model.Farba;
import Model.Pigment;
/**
 *
 * @author squar
 */
public class InterfejsGraficzny extends javax.swing.JFrame {
    private Maszyna maszyna;
    private javax.swing.DefaultListModel<Farba> modelFarby;
    private javax.swing.DefaultListModel<Pigment> modelPigmenty;

    public InterfejsGraficzny() {
        initComponents();
        try {
            maszyna = new Model.Maszyna();
            maszyna.konfiguruj();
            ustawListęFarb(maszyna.pobierzListęFarb());
            ustawListęPigmentów(maszyna.pobierzListęPigmentów());
            mieszajButton.setEnabled(false);
            użyjPigmentuButton.setEnabled(false);
            zakończMieszanieButton.setEnabled(false);
        }
        /* wyjątek zgłoszony w przypadku błędów przy wczytywaniu pliku */
        catch (IOException e) {
            System.exit(1);
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jButton5 = new javax.swing.JButton();
        farbyPanel = new javax.swing.JPanel();
        dodajFarbeButton = new javax.swing.JButton();
        usuńZaznaczenieFarbyButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        modelFarby = new javax.swing.DefaultListModel<>();
        farbyJList = new javax.swing.JList<>(modelFarby);
        pigmentyPanel = new javax.swing.JPanel();
        dodajPigmentButton = new javax.swing.JButton();
        usuńZaznaczeniePigmentyButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        modelPigmenty = new javax.swing.DefaultListModel<>();
        pigmentyJList = new javax.swing.JList<>(modelPigmenty);
        toksycznośćLabel = new javax.swing.JLabel();
        jakośćLabel = new javax.swing.JLabel();
        zmianaToksycznośćLabel = new javax.swing.JLabel();
        zmianaJakośćLabel = new javax.swing.JLabel();
        toksycznośćFormattedTextField = new javax.swing.JFormattedTextField();
        jakośćFormattedTextField = new javax.swing.JFormattedTextField();
        zmianaToksycznośćFormattedTextField = new javax.swing.JFormattedTextField();
        zmianaJakośćFormattedTextField = new javax.swing.JFormattedTextField();
        mieszajButton = new javax.swing.JButton();
        użyjPigmentuButton = new javax.swing.JButton();
        zakończMieszanieButton = new javax.swing.JButton();

        jButton5.setText("jButton5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        farbyPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Farby", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP));

        dodajFarbeButton.setText("Dodaje farbę");
        dodajFarbeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodajFarbeButtonActionPerformed(evt);
            }
        });

        usuńZaznaczenieFarbyButton.setText("Usuń zaznaczenie");
        usuńZaznaczenieFarbyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuńZaznaczenieFarbyButtonActionPerformed(evt);
            }
        });

        farbyJList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        farbyJList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                farbyJListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(farbyJList);

        javax.swing.GroupLayout farbyPanelLayout = new javax.swing.GroupLayout(farbyPanel);
        farbyPanel.setLayout(farbyPanelLayout);
        farbyPanelLayout.setHorizontalGroup(
                farbyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, farbyPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(farbyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(usuńZaznaczenieFarbyButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(dodajFarbeButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                                .addContainerGap())
        );
        farbyPanelLayout.setVerticalGroup(
                farbyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, farbyPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usuńZaznaczenieFarbyButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dodajFarbeButton)
                                .addContainerGap())
        );

        pigmentyPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pigmenty", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP));

        dodajPigmentButton.setText("Dodaj pigment");
        dodajPigmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodajPigmentButtonActionPerformed(evt);
            }
        });

        usuńZaznaczeniePigmentyButton.setText("Usuń zaznaczenie");
        usuńZaznaczeniePigmentyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuńZaznaczeniePigmentyButtonActionPerformed(evt);
            }
        });

        pigmentyJList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(pigmentyJList);

        javax.swing.GroupLayout pigmentyPanelLayout = new javax.swing.GroupLayout(pigmentyPanel);
        pigmentyPanel.setLayout(pigmentyPanelLayout);
        pigmentyPanelLayout.setHorizontalGroup(
                pigmentyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pigmentyPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pigmentyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(usuńZaznaczeniePigmentyButton, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                        .addComponent(dodajPigmentButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addContainerGap())
        );
        pigmentyPanelLayout.setVerticalGroup(
                pigmentyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pigmentyPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usuńZaznaczeniePigmentyButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dodajPigmentButton)
                                .addContainerGap())
        );

        toksycznośćLabel.setLabelFor(toksycznośćFormattedTextField);
        toksycznośćLabel.setText("Toksyczność farby");

        jakośćLabel.setLabelFor(jakośćFormattedTextField);
        jakośćLabel.setText("Jakość farby");

        zmianaToksycznośćLabel.setLabelFor(zmianaToksycznośćFormattedTextField);
        zmianaToksycznośćLabel.setText("Zmiana toksyczności pigmentu");

        zmianaJakośćLabel.setLabelFor(zmianaJakośćFormattedTextField);
        zmianaJakośćLabel.setText("Zmiana jakości pigmentu");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, farbyJList, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.toksyczność}"), toksycznośćFormattedTextField, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, farbyJList, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.jakość}"), jakośćFormattedTextField, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, pigmentyJList, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.toksycznośćZmiana}"), zmianaToksycznośćFormattedTextField, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, pigmentyJList, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.jakośćZmiana}"), zmianaJakośćFormattedTextField, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        mieszajButton.setText("Mieszaj");
        mieszajButton.setPreferredSize(new java.awt.Dimension(150, 29));
        mieszajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mieszajButtonActionPerformed(evt);
            }
        });

        użyjPigmentuButton.setText("Użyj pigmentu");
        użyjPigmentuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                użyjPigmentuButtonActionPerformed(evt);
            }
        });

        zakończMieszanieButton.setText("Zakończ mieszanie");
        zakończMieszanieButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zakończMieszanieButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(farbyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pigmentyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(toksycznośćLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jakośćLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(zmianaJakośćLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(zmianaToksycznośćLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(zmianaToksycznośćFormattedTextField)
                                                        .addComponent(jakośćFormattedTextField)
                                                        .addComponent(toksycznośćFormattedTextField)
                                                        .addComponent(zmianaJakośćFormattedTextField, javax.swing.GroupLayout.Alignment.TRAILING)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(mieszajButton, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(użyjPigmentuButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(zakończMieszanieButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(12, 12, 12)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(farbyPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(1, 1, 1)
                                                                .addComponent(toksycznośćLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(toksycznośćFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(1, 1, 1)
                                                                .addComponent(jakośćLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jakośćFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(57, 57, 57)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(1, 1, 1)
                                                                .addComponent(zmianaToksycznośćLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(zmianaToksycznośćFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(1, 1, 1)
                                                                .addComponent(zmianaJakośćLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(zmianaJakośćFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(mieszajButton, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                                                        .addComponent(użyjPigmentuButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(zakończMieszanieButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addComponent(pigmentyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>


    private void ustawListęFarb(List<Farba> źródło) {
        modelFarby.clear();
        for (Farba farba : źródło) {
            modelFarby.insertElementAt(farba, 0);
        }
    }

    private void ustawListęPigmentów(List<Pigment> źródło) {
        modelPigmenty.clear();
        for (Pigment pigment : źródło) {
            modelPigmenty.insertElementAt(pigment, 0);
        }
    }

    private void usuńZaznaczenieFarbyButtonActionPerformed(java.awt.event.ActionEvent evt) {
        farbyJList.clearSelection();
        mieszajButton.setEnabled(false);
        toksycznośćFormattedTextField.setText("");
        jakośćFormattedTextField.setText("");
    }

    private void usuńZaznaczeniePigmentyButtonActionPerformed(java.awt.event.ActionEvent evt) {
        pigmentyJList.clearSelection();
        użyjPigmentuButton.setEnabled(false);
        zmianaToksycznośćFormattedTextField.setText("");
        zmianaJakośćFormattedTextField.setText("");
    }

    private void dodajFarbeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        maszyna.dodajFarbę();
        ustawListęFarb(maszyna.pobierzListęFarb());
    }

    private void dodajPigmentButtonActionPerformed(java.awt.event.ActionEvent evt) {
        maszyna.dodajPigment();
        ustawListęPigmentów(maszyna.pobierzListęPigmentów());
    }

    private void mieszajButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void użyjPigmentuButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void zakończMieszanieButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void farbyJListValueChanged(javax.swing.event.ListSelectionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfejsGraficzny.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfejsGraficzny.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfejsGraficzny.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfejsGraficzny.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfejsGraficzny().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton dodajFarbeButton;
    private javax.swing.JButton dodajPigmentButton;
    private javax.swing.JList<Farba> farbyJList;
    private javax.swing.JPanel farbyPanel;
    private javax.swing.JButton jButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JFormattedTextField jakośćFormattedTextField;
    private javax.swing.JLabel jakośćLabel;
    private javax.swing.JButton mieszajButton;
    private javax.swing.JList<Pigment> pigmentyJList;
    private javax.swing.JPanel pigmentyPanel;
    private javax.swing.JFormattedTextField toksycznośćFormattedTextField;
    private javax.swing.JLabel toksycznośćLabel;
    private javax.swing.JButton usuńZaznaczenieFarbyButton;
    private javax.swing.JButton usuńZaznaczeniePigmentyButton;
    private javax.swing.JButton użyjPigmentuButton;
    private javax.swing.JButton zakończMieszanieButton;
    private javax.swing.JFormattedTextField zmianaJakośćFormattedTextField;
    private javax.swing.JLabel zmianaJakośćLabel;
    private javax.swing.JFormattedTextField zmianaToksycznośćFormattedTextField;
    private javax.swing.JLabel zmianaToksycznośćLabel;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration
}
