package SwingGrafpFX;

import Swing.MyWindow;
import javafx.scene.shape.Box;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWind extends JFrame {
   public MyWind()
   {
          setTitle("MyWindow");
          setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
         int sizeWidth = 1000;
         int sizeHeight = 600;
         int locationX = (screenSize.width - sizeWidth) / 2;
         int locationY = (screenSize.height - sizeHeight) / 2;
       setBounds(locationX, locationY, sizeWidth, sizeHeight);
       setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
       Font font = new Font("Ariel",3,30);
       JTextArea textArea = new JTextArea();textArea.setFont(font);
       JScrollPane jScrollPane = new JScrollPane(textArea);
       jScrollPane.setPreferredSize(new Dimension(200,300));
       //textArea.append("Text :\n");
       JTextField jTextField = new JTextField();jTextField.setFont(font);
       jTextField.setPreferredSize(new Dimension(300,100));
        add(jScrollPane);add(jTextField);
        jTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append(jTextField.getText()+"\n");
                jTextField.setText("");jTextField.grabFocus();
            }
        });


       setVisible(true);
   }

    public static void main(String[] args) {
        new MyWind();
    }
}
