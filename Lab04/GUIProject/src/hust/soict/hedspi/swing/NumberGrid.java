package hust.soict.hedspi.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGrid extends JFrame {
    private JButton[] btnNumber = new JButton[10];
    private JButton btnDelete,btnReset;
    private JTextField tfDisplay;

    public NumberGrid() {
        tfDisplay = new JTextField();
        tfDisplay.setComponentOrientation(
                ComponentOrientation.RIGHT_TO_LEFT);
        JPanel panelButtons = new JPanel(new GridLayout(4,3));
        addButtons(panelButtons);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(tfDisplay, BorderLayout.NORTH);
        cp.add(panelButtons, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Number Grid");
        setSize(200,200);
        setVisible(true);


    }

    public void addButtons(JPanel panelButtons) {
        ButtonListener btnListener = new ButtonListener();
        for(int i=1;i<=9;i++){
            btnNumber[i] = new JButton(""+i);
            panelButtons.add(btnNumber[i]);
            btnNumber[i].addActionListener(btnListener);
        }

        btnDelete = new JButton("DEL");
        panelButtons.add(btnDelete);
        btnDelete.addActionListener(btnListener);

        btnReset = new JButton("C");
        panelButtons.add(btnReset);
        btnReset.addActionListener(btnListener);

        btnNumber[0] = new JButton("0");
        panelButtons.add(btnNumber[0]);
        btnNumber[0].addActionListener(btnListener);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            String curtext = tfDisplay.getText();
            if ( button.charAt(0) >= '0' && button.charAt(0) <= '9') {
                tfDisplay.setText(tfDisplay.getText() + button);

            }else if(button.equals("DEL")){
                if (!curtext.equals("")){
                    curtext=curtext.substring(0,curtext.length()-1);
                    tfDisplay.setText(curtext);
                }else{
                    tfDisplay.setText("");
                }

            }else{
                tfDisplay.setText("");
            }

        }




    }

    public static void main(String[] args) {
        new NumberGrid();
    }
}