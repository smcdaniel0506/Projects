package app;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class appWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton button1, button2, button3, button4, button5, button6;
	private int clicks = 0;
	private JButton btnReset;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					appWindow frame = new appWindow();
					frame.setVisible(true);
				}

				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public appWindow() {

		setTitle("Positive and Negative Counter");
		initComponents();
		createEvents();

	}

	///////////////////////////////////////////////
	/// Initialize the components, create contents
	///////////////////////////////////////////////
	private void initComponents() {

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		lblNewLabel = new JLabel();
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setText("0");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 50));
		button1 = new JButton("-1");
		button2 = new JButton("+1");
		button3 = new JButton("+5");
		button4 = new JButton("-5");
		button6 = new JButton("+10");
		button5 = new JButton("-10");
		btnReset = new JButton("RESET");

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(28)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(button1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(button2, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
								.addGap(52)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(button3, GroupLayout.PREFERRED_SIZE, 86,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(button4, GroupLayout.PREFERRED_SIZE, 86,
												GroupLayout.PREFERRED_SIZE))
								.addGap(44)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(button5, GroupLayout.PREFERRED_SIZE, 86,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(button6, GroupLayout.PREFERRED_SIZE, 86,
												GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(18).addComponent(lblNewLabel,
								GroupLayout.PREFERRED_SIZE, 397, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(179).addComponent(btnReset)))
				.addContainerGap(19, Short.MAX_VALUE)));
		gl_contentPane
				.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(btnReset).addGap(3)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(button2)
										.addComponent(button3).addComponent(button6))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(button1)
										.addComponent(button4).addComponent(button5))
								.addContainerGap(28, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);

	}

	///////////////////////////////
	/// Handling events
	//////////////////////////////
	private void createEvents() {

		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				--clicks;
				clickCheck();
				lblNewLabel.setText(Integer.toString(clicks));
			}
		});
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				++clicks;
				clickCheck();
				lblNewLabel.setText(Integer.toString(clicks));
			}
		});
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clicks += 5;
				clickCheck();
				lblNewLabel.setText(Integer.toString(clicks));
			}
		});
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clicks -= 5;
				clickCheck();
				lblNewLabel.setText(Integer.toString(clicks));
			}
		});
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clicks -= 10;
				clickCheck();
				lblNewLabel.setText(Integer.toString(clicks));
			}
		});
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clicks += 10;
				clickCheck();
				lblNewLabel.setText(Integer.toString(clicks));
			}
		});
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetCount();
			}
		});
	}

	//////////////////////////////////////////////////////////////////////////////////
	/// Methods to check current number or reset counter
	//////////////////////////////////////////////////////////////////////////////////
	public void clickCheck() {
		if (clicks == 0) {
			contentPane.setBackground(Color.LIGHT_GRAY);
		} else if (clicks > 0) {
			contentPane.setBackground(Color.GREEN);
		} else if (clicks < 0) {
			contentPane.setBackground(Color.RED);
		}
	}


	public void resetCount() {
		clicks = 0;
		contentPane.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setText(Integer.toString(clicks));
	}
}
