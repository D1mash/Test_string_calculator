import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calc implements ActionListener {

    JTextField jtf,jlabPromt;
    JLabel  jlabContents;
    JButton jbtnRev;

    Calc(){
        JFrame jfrm = new JFrame("Calculator");
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(400,120);


        jtf = new JTextField(10);
        jbtnRev = new JButton("=");
        jlabPromt = new JTextField(10);
        jlabContents = new JLabel("");

        jtf.setActionCommand("");
        jtf.addActionListener(this);
        jbtnRev.addActionListener(this);

        jfrm.add(jtf);
        jfrm.add(jbtnRev);
        jfrm.add(jlabPromt);
        jfrm.add(jlabContents);

        jfrm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("=")){

            String strinp = jtf.getText();

            if (!strinp.isEmpty()){
                jlabContents.setText("");
                CalcImplement impl = new CalcImplement();
                jlabPromt.setText(impl.Result(strinp));
            }
            else {
                jlabContents.setText("You haven't entered expression");
            }
        }
    }
}
