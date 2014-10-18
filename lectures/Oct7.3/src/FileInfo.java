import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class FileInfo extends JFrame implements ActionListener {
	private JButton button3 = new JButton();
	private Container cp = null;
	private JTextField tf = null;
	private JTextArea ta = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileInfo me = new FileInfo();
		me.setVisible(true);
	}
	
	public FileInfo() {
		setSize(400,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button = new JButton("This is a button");
		tf = new JTextField();
		JButton button2 = new JButton("Hi Mom");
		button3 = new JButton("Buttons Rock!");
		button3.addActionListener(this);
		button3.setActionCommand("BUTTON3");
		JButton button4 = new JButton("This is another button");
		JButton button5 = new JButton("Me Too!!!");
		button5.setActionCommand("BUTTON5");
		button5.addActionListener(this);
		ta = new JTextArea();
		ta.setForeground(Color.WHITE);
		ta.setBackground(Color.GREEN);
		
		cp = this.getContentPane();
		
		cp.setLayout(new BorderLayout());
		
		cp.add(tf, BorderLayout.PAGE_START);
		cp.add(ta, BorderLayout.CENTER);
		
		JPanel myPanel = new JPanel();
		myPanel.setLayout(new FlowLayout());
		myPanel.add(button3);
		myPanel.add(button4);
		myPanel.add(button5);
		
//		cp.add(button3, BorderLayout.PAGE_END);
//		cp.add(button4, BorderLayout.PAGE_END);
//		cp.add(button5, BorderLayout.PAGE_END);
		cp.add(myPanel, BorderLayout.PAGE_END);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		switch(e.getActionCommand()) {
		case "BUTTON3":
			if (button3.getText().compareToIgnoreCase("OUCH") == 0){
				button3.setText("Ahhhh");
				ta.setBackground(Color.BLUE);
			} else {
				button3.setText("OUCH");
				ta.setBackground(Color.RED);
			}
			break;
			
		case "BUTTON5":
			System.out.println("button 5");
			System.out.println(tf.getText());
			
			File f = new File(tf.getText());
			ta.setText("");
			if (f.exists()) {
				ta.append("File Exists\n");
			} else {
				ta.append("File does not Exist\n");
				return;
			}
			
			if (f.isDirectory()) {
				ta.append("File is a Directory\n");
			} else {
				ta.append("File is a file (" + f.length() + " Bytes)\n");
			}
			
			
			break;
			
			default:
				System.out.println(e.getActionCommand());
			
		}
		
	}

}
