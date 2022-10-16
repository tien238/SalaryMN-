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

public class salaryMainView extends javax.swing.JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  int id;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private JTextField textField_2;
	private JTextField textField_5;
	JComboBox<?> comboBox;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public salaryMainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1179, 723);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(582, 10, 1, 1);
		contentPane.add(desktopPane);
		
		JLabel lblNewLabel = new JLabel("     Tên");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(28, 75, 78, 56);
		contentPane.add(lblNewLabel);
		
		JLabel lblAge = new JLabel("    Tuổi");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAge.setBounds(28, 154, 78, 56);
		contentPane.add(lblAge);
		
		JLabel lblGender = new JLabel("  Giới tính");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGender.setBounds(28, 221, 78, 56);
		contentPane.add(lblGender);
		
		JLabel lblMajor = new JLabel("    Lương");
		lblMajor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMajor.setBounds(28, 287, 78, 56);
		contentPane.add(lblMajor);
		
		JLabel lblScore = new JLabel("  Thưởng");
		lblScore.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblScore.setBounds(28, 367, 78, 56);
		contentPane.add(lblScore);
		
		textField = new JTextField();
		textField.setBounds(116, 78, 190, 56);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(116, 157, 190, 56);
		contentPane.add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(116, 290, 190, 56);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(116, 370, 190, 56);
		contentPane.add(textField_4);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		comboBox.setBounds(116, 221, 63, 56);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            // TODO add your handling code here:
				JFrame t = new JFrame();
				int a = JOptionPane.showConfirmDialog(t, "Xác nhận tiến hành thêm trường dữ liệu này?", "Xác nhận th", JOptionPane.YES_NO_OPTION);
				System.out.print(a);
				if(a == 0) {
                            String ten;
                            int tuoi ,gioitinh;
                            float luong, thuong, phat , tong;
                            try{
                                ten = textField.getText();
                                tuoi = Integer.parseInt(textField_1.getText());
                                gioitinh = comboBox.getSelectedItem().toString().equals("Nữ")?1:0;
                                luong = Float.parseFloat(textField_3.getText());
                                thuong = Float.parseFloat(textField_4.getText());
                                phat = Float.parseFloat(textField_2.getText());
                                tong = Float.parseFloat(textField_5.getText());
                                People p = new People(ten, tuoi, gioitinh, luong, thuong, phat, tong);
                                ConnJDBC.insert(p);
                            } catch(NumberFormatException e1){
                            	JFrame f = new JFrame();
                            	JOptionPane.showMessageDialog(f,"Phải nhập số");  
                                return;
                                
                            }
                            showData(ConnJDBC.findAll());
			}
			}
		});

		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(591, 618, 162, 47);
		contentPane.add(btnNewButton);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame t = new JFrame();
				int a = JOptionPane.showConfirmDialog(t, "Bạn có muốn xóa trường dữ liệu này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
				if(a == 0) {
					People p = new People();
	                p.setId(id);
	                ConnJDBC.delete(p);
	                showData(ConnJDBC.findAll());
				}
                
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(372, 618, 162, 47);
		contentPane.add(btnDelete);
		
		JButton btnFind = new JButton("  Tìm kiếm theo tên");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				People p = new People();
				p.setTen(textField_6.getText());
				showData(ConnJDBC.findByName(p));
			}
		});
		btnFind.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFind.setBounds(926, 63, 218, 47);
		contentPane.add(btnFind);
		
		JButton btnRefresh = new JButton("Làm Mới");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showData(ConnJDBC.findAll());
			}
		});
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRefresh.setBounds(591, 544, 162, 47);
		contentPane.add(btnRefresh);
		
		JButton btnUpdate = new JButton("Cập Nhật");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame t = new JFrame();
				int a = JOptionPane.showConfirmDialog(t, "Xác nhận tiến hành cập nhật trường dữ liệu này?", "Xác nhận cập nhật", JOptionPane.YES_NO_OPTION);
				System.out.print(a);
				if(a == 0) {
					String ten;
	                int tuoi ,gioitinh;
	                float luong, thuong, phat , tong;
	                try{
	                    ten = textField.getText();
	                    tuoi = Integer.parseInt(textField_1.getText());
	                    gioitinh = comboBox.getSelectedItem().toString().equals("Nữ")?1:0;
	                    luong = Float.parseFloat(textField_3.getText());
	                    thuong = Float.parseFloat(textField_4.getText());
	                    phat = Float.parseFloat(textField_2.getText());
	                    tong = Float.parseFloat(textField_5.getText());
	                    People p = new People(id,ten, tuoi, gioitinh, luong, thuong, phat, tong);
	                    ConnJDBC.update(p);
	                    showData(ConnJDBC.findAll());
	                } catch(NumberFormatException e1){
	                	JFrame f = new JFrame();
	                	JOptionPane.showMessageDialog(f,"Cập nhật thất bại, nhập sai các trường dữ liệu số");  
	                    return;
	                }
				}
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(372, 544, 162, 47);
		contentPane.add(btnUpdate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(351, 119, 793, 373);
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
				" ID", "       T\u00EAn", "Tu\u1ED5i", "  Gi\u1EDBi t\u00EDnh", "   L\u01B0\u01A1ng(triệu đồng)", " Th\u01B0\u1EDFng(triệu đồng)", "Ph\u1EA1t(triệu đồng)", "T\u1ED5ng(triệu đồng)"
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
		 table.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	            	tableMouseClicked(evt);
	            }
	        });

		scrollPane.setViewportView(table);
		showData(ConnJDBC.findAll());
		
		JLabel lblPht = new JLabel("     Phạt");
		lblPht.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPht.setBounds(28, 454, 78, 56);
		contentPane.add(lblPht);
		
		JLabel lblTng = new JLabel("     Tổng");
		lblTng.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTng.setBounds(28, 542, 78, 56);
		contentPane.add(lblTng);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(116, 454, 190, 56);
		contentPane.add(textField_2);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(116, 542, 190, 56);
		contentPane.add(textField_5);
		
		JLabel lblNewLabel_1 = new JLabel("Bảng tổng kết lương");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(424, 10, 550, 56);
		contentPane.add(lblNewLabel_1);
		
		JButton btnThngK = new JButton("Thống kê nhân viên ưu tú");
		btnThngK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Thongke frame = new Thongke();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnThngK.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThngK.setBounds(808, 563, 247, 62);
		contentPane.add(btnThngK);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(633, 71, 283, 35);
		contentPane.add(textField_6);
		
	}
	private void tableMouseClicked(java.awt.event.MouseEvent evt) {
		 // Do something.
		 int row = table.getSelectedRow();
		 	id =Integer.parseInt(table.getValueAt(row, 0).toString()) ;
	        textField.setText(table.getValueAt(row, 1).toString());
	        textField_1.setText(table.getValueAt(row, 2).toString());
	        for(int i=0;i<comboBox.getItemCount();i++){
	            if(table.getValueAt(row, 3).toString().equals(comboBox.getItemAt(i).toString())){
	            	comboBox.setSelectedIndex(i);
	            }
	        }
	        textField_3.setText(table.getValueAt(row, 4).toString());
	        textField_4.setText(table.getValueAt(row, 5).toString());
	        textField_2.setText(table.getValueAt(row, 6).toString());
	        textField_5.setText(table.getValueAt(row, 7).toString());
	        
	    
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
