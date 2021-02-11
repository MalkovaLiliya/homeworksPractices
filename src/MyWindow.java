import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame
{
    public MyWindow()
    {
        setSize(500, 500);
        setLocation(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(1, 2));
        ExitListener lst = new ExitListener();
        JButton bt1 = new JButton("Выход");
        JButton bt2 = new JButton("2 кнопка");
        bt1.addActionListener(lst);
        panel.add(bt1);
        panel.add(bt2);

        add(panel, BorderLayout.NORTH);





        setVisible(true);

    }

}
