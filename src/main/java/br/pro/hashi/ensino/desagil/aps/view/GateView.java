package br.pro.hashi.ensino.desagil.aps.view;

import br.pro.hashi.ensino.desagil.aps.model.Gate;
import br.pro.hashi.ensino.desagil.aps.model.Switch;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GateView extends FixedPanel implements ActionListener, MouseListener {

    private final Gate gate;
    private final JCheckBox Entrada;
    private final JCheckBox Saida;

    private final JCheckBox Entrada2;

    public GateView(Gate gate) {
        super(245, 346);

        this.gate = gate;


        Entrada = new JCheckBox();
        Entrada2 = new JCheckBox();
        Saida = new JCheckBox();


        JLabel Saidalabel = new JLabel("saida");

        if (gate.getInputSize() > 1) {

            JLabel Entradalabel = new JLabel("Entradas");

            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            add(Entradalabel);
            add(Entrada);
            add(Entrada2);

            add(Saidalabel);
            add(Saida);

            Entrada.addActionListener(this);
            Entrada2.addActionListener(this);

            Saida.setEnabled(false);

            update();

        } else {

            JLabel Entradalabel = new JLabel("Entrada");

            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            add(Entradalabel);
            add(Entrada);

            add(Saidalabel);
            add(Saida);

            Entrada.addActionListener(this);

            Saida.setEnabled(false);

            update();

        }


    }

    private void update() {
        if (gate.getInputSize() > 1) {
            Switch A = new Switch();
            Switch B = new Switch();
            try {
                Object PinoA = Entrada.getSelectedObjects();
                if (PinoA == null) {
                    A.turnOff();
                } else {
                    A.turnOn();
                }
            } catch (NullPointerException exception) {
                System.out.println("Exception");
            }
            try {
                Object PinoB = Entrada2.getSelectedObjects();
                if (PinoB == null) {
                    B.turnOff();
                } else {
                    B.turnOn();
                }
            } catch (NullPointerException exception) {
                System.out.println("Exception");
            }

            gate.connect(0, A);
            gate.connect(1, B);
            boolean resul = gate.read();
            if (resul) {
                Saida.setSelected(true);
                Saida.setEnabled(false);
            } else {
                Saida.setSelected(false);
                Saida.setEnabled(false);
            }
        } else {
            Switch A = new Switch();
            try {
                Object PinoA = Entrada.getSelectedObjects();
                if (PinoA == null) {
                    A.turnOff();
                } else {
                    A.turnOn();
                }
            } catch (NullPointerException exception) {
                System.out.println("Exception");
            }
            gate.connect(0, A);
        }

        boolean resul = gate.read();
        if (resul) {
            Saida.setSelected(true);
            Saida.setEnabled(false);
        } else {
            Saida.setSelected(false);
            Saida.setEnabled(false);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
