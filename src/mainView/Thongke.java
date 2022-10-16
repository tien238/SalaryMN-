package mainView;

import connData.ConnJDBC;
import model.People;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorListener;
import javax.swing.JLayeredPane;
import java.awt.FlowLayout;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class Thongke extends javax.swing.JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  int id;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Thongke() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1179, 723);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(582, 10, 1, 1);
		contentPane.add(desktopPane);
		
		JButton btnNewButton = new JButton("Trở về");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            // TODO add your handling code here:
                         dispose();
                         EventQueue.invokeLater(new Runnable() {
     						public void run() {
     							try {
     								salaryMainView frame = new salaryMainView();
     								frame.setVisible(true);
     							} catch (Exception e) {
     								e.printStackTrace();
     							}
     						}
     					});
			}
		});

		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(533, 578, 162, 47);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(117, 101, 940, 391);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				" ID", "       T\u00EAn", "Tu\u1ED5i", "  Gi\u1EDBi t\u00EDnh", "         L\u01B0\u01A1ng", "    Th\u01B0\u1EDFng", "      Ph\u1EA1t", "     T\u1ED5ng"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(0).setMinWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setMinWidth(30);
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
		table.getColumnModel().getColumn(3).setMinWidth(60);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setMinWidth(100);
		table.getColumnModel().getColumn(5).setMinWidth(50);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
	
		showData(ConnJDBC.getTopExellent());
		scrollPane.setViewportView(table);
		showData(ConnJDBC.getTopExellent());
		
		JLabel lblNewLabel_1 = new JLabel("Danh sách nhân viên ưu tú");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(372, 10, 550, 56);
		contentPane.add(lblNewLabel_1);
		
	}

	public void showData(List<People>peoples) {
		List<People>listPeoples= new ArrayList<>();
		listPeoples = peoples;
		DefaultTableModel tableModel;
		table.getModel();
		tableModel=(DefaultTableModel)table.getModel();
		tableModel.setRowCount(0);
		listPeoples.forEach((people)->{
			String gioitinh;
			if(people.getGioitinh()==0) gioitinh="Nam";
			else {gioitinh="Nữ";}
			tableModel.addRow(new Object[] {
					people.getId(),people.getTen(),people.getTuoi(),
					gioitinh,people.getLuong(),people.getThuong(),
					people.getPhat(),people.getTong()
			});
		});
	}
    
}
