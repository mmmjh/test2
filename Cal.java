import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.lang.*;
public class Cal extends JFrame{
	static int res = 0;
	static int dadui = 0;
	static int n1 = 0;
	static int n2 = 0;
	static int num = 0;
	static char y = '\0';
	static int tishu = 1;
	static int shu = 0;
	static String ysf = "+-*/";
	public Cal(){
		initComponent();
	}
	private void initComponent(){
		setTitle("��ʼ����");
		
		
		//��һ�� ��ʾ���ֺ������
		JPanel ncount = new JPanel();
		JLabel n_in = new JLabel("����������:");
		Font f = new Font("�����п�",0,20);
		n_in.setFont(f);
		ncount.add(n_in);
		JTextField ct = new JTextField(4);
		ncount.add(ct);
		add(ncount);
		
		
		//�ڶ��У���ʼ��ť ����ײ�
		JPanel p_bt1 = new JPanel();
		p_bt1.setLayout(new GridLayout(1,1));
		JButton s_btn = new JButton("��ʼ");
		//��ť������¼�
		s_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				//���ñ����������������
				String c = ct.getText();
				if(isNumeric(c)){
					//�������������
					shu=Integer.parseInt(c);
					//��������Ĵ���
					setVisible(false);
					JFrame test = new JFrame("��Ŀ����");
					
					//test.setSize (300,120);
					JPanel ti = new JPanel();
					
					//�������1-9֮�������
					Random r1 = new Random();
					//Random r2 = new Random();
					n1 = r1.nextInt(8)+1;
					n2 = r1.nextInt(8)+1;
					// n1 = (int)(8*Math.random()+1);
					// n2 = (int)(8*Math.random()+1);
					
					//��������
					//Random r3 = new Random();
					num = r1.nextInt(3);
					// num = (int)(3*Math.random());
					y = ysf.charAt(num);
					
					//���м���
					switch(num){
						case 0:	res = n1 + n2 ;break;
						case 1:	res = n1 - n2 ;break;
						case 2:	res = n1 * n2 ;break;
						case 3:	res = n1 / n2 ;break;
					}
					
					//д��ʽ
					JLabel num1 = new JLabel(""+n1);
					JLabel ysf0 = new JLabel(""+y);
					JLabel num2 = new JLabel(""+n2);
					JLabel deng = new JLabel("=");
					JTextField rs = new JTextField(4);
					num1.setFont(f);
					ysf0.setFont(f);
					num2.setFont(f);
					deng.setFont(f);
					
					//�ڽ�����д����ʽ
					ti.add(num1);
					ti.add(ysf0);
					ti.add(num2);
					ti.add(deng);
					ti.add(rs);
					test.add(ti);
					
					JPanel p_bt2 = new JPanel();
					p_bt2.setLayout(new GridLayout(1,2));
					JLabel zi = new JLabel("����");
					zi.setFont(f);
					JButton n_btn = new JButton("��һ��");
					
					n_btn.addActionListener(new ActionListener() { 
						@Override
						public void actionPerformed(ActionEvent e){
							if(tishu<shu){
								if(isNumeric(rs.getText()))
									{
										if(res==Integer.parseInt(rs.getText())){
											dadui++;
										}
										Random r1 = new Random();
										n1 = r1.nextInt(8)+1;
										Random r2 = new Random();
										n2 = r2.nextInt(8)+1;
										Random r3 = new Random();
										num = r3.nextInt(3);
										y = ysf.charAt(num);
										
										switch(num){
											case 0:	res = n1 + n2 ;break;
											case 1:	res = n1 - n2 ;break;
											case 2:	res = n1 * n2 ;break;
											case 3:	res = n1 / n2 ;break;
										}
										
										num1.setText("" + n1);
										ysf0.setText("" + y);
										num2.setText("" + n2);
									}
								else JOptionPane.showConfirmDialog(null,"��������ȷ�����֣�","��ʾ��Ϣ",JOptionPane.DEFAULT_OPTION);
								tishu++;
							}
							else{
								if(res==Integer.parseInt(rs.getText())){
											dadui++;
								}
								String str = "�������"+dadui+"���⣬�ٽ�������";
								int i = JOptionPane.showConfirmDialog(null,str,"��ʾ��Ϣ",JOptionPane.DEFAULT_OPTION);
								if(i == 0){
									System.exit(0);
								}
							}
							rs.setText("");
						}
					});	
					
					p_bt2.add(zi);
					p_bt2.add(n_btn);
					test.add(p_bt2,BorderLayout.SOUTH);
					
					//���ý���Ĵ�С���رհ�ť
					test.setSize(300,120);
					test.setDefaultCloseOperation(EXIT_ON_CLOSE);
					//���þ���
					test.setLocationRelativeTo(null);
					//���ô�С���ɸ���
					test.setResizable(false);
					//���ô��ڿɼ�
					test.setVisible(true);
				}
				else{
					JOptionPane.showConfirmDialog(null,"��������ȷ�����֣�","��ʾ��Ϣ",JOptionPane.DEFAULT_OPTION);
				}
			}
		});
		
		p_bt1.add(s_btn);
		add(p_bt1,BorderLayout.SOUTH);
		
		//���ý���Ĵ�С���رհ�ť
		setSize(300,120);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//���þ���
		setLocationRelativeTo(null);
		//���ô�С���ɸ���
		setResizable(false);
		//���ô��ڿɼ�
		setVisible(true);
	}
	//������
	public static void main(String[] args) {
		new Cal();
	}
	
	//�ж��Ƿ�����
	public static boolean isNumeric(String str){
		if(Character.isDigit(str.charAt(0))||str.charAt(0)=='-')
		{for (int i = 1; i < str.length(); i++){
			if (!Character.isDigit(str.charAt(i))){
				return false;
			}
		}
		return true;}
		else return false;
	}
	
}