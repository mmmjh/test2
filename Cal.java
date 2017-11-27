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
		setTitle("开始界面");
		
		
		//第一行 显示文字和输入框
		JPanel ncount = new JPanel();
		JLabel n_in = new JLabel("请输入题数:");
		Font f = new Font("华文行楷",0,20);
		n_in.setFont(f);
		ncount.add(n_in);
		JTextField ct = new JTextField(4);
		ncount.add(ct);
		add(ncount);
		
		
		//第二行，开始按钮 界面底部
		JPanel p_bt1 = new JPanel();
		p_bt1.setLayout(new GridLayout(1,1));
		JButton s_btn = new JButton("开始");
		//按钮的鼠标事件
		s_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				//设置变量接受输入的题数
				String c = ct.getText();
				if(isNumeric(c)){
					//接受输入的数字
					shu=Integer.parseInt(c);
					//弹出做题的窗口
					setVisible(false);
					JFrame test = new JFrame("题目窗口");
					
					//test.setSize (300,120);
					JPanel ti = new JPanel();
					
					//随机生成1-9之间的数字
					Random r1 = new Random();
					//Random r2 = new Random();
					n1 = r1.nextInt(8)+1;
					n2 = r1.nextInt(8)+1;
					// n1 = (int)(8*Math.random()+1);
					// n2 = (int)(8*Math.random()+1);
					
					//随机运算符
					//Random r3 = new Random();
					num = r1.nextInt(3);
					// num = (int)(3*Math.random());
					y = ysf.charAt(num);
					
					//进行计算
					switch(num){
						case 0:	res = n1 + n2 ;break;
						case 1:	res = n1 - n2 ;break;
						case 2:	res = n1 * n2 ;break;
						case 3:	res = n1 / n2 ;break;
					}
					
					//写算式
					JLabel num1 = new JLabel(""+n1);
					JLabel ysf0 = new JLabel(""+y);
					JLabel num2 = new JLabel(""+n2);
					JLabel deng = new JLabel("=");
					JTextField rs = new JTextField(4);
					num1.setFont(f);
					ysf0.setFont(f);
					num2.setFont(f);
					deng.setFont(f);
					
					//在界面上写下算式
					ti.add(num1);
					ti.add(ysf0);
					ti.add(num2);
					ti.add(deng);
					ti.add(rs);
					test.add(ti);
					
					JPanel p_bt2 = new JPanel();
					p_bt2.setLayout(new GridLayout(1,2));
					JLabel zi = new JLabel("加油");
					zi.setFont(f);
					JButton n_btn = new JButton("下一题");
					
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
								else JOptionPane.showConfirmDialog(null,"请输入正确的数字！","提示信息",JOptionPane.DEFAULT_OPTION);
								tishu++;
							}
							else{
								if(res==Integer.parseInt(rs.getText())){
											dadui++;
								}
								String str = "您答对了"+dadui+"道题，再接再厉！";
								int i = JOptionPane.showConfirmDialog(null,str,"提示信息",JOptionPane.DEFAULT_OPTION);
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
					
					//设置界面的大小，关闭按钮
					test.setSize(300,120);
					test.setDefaultCloseOperation(EXIT_ON_CLOSE);
					//设置居中
					test.setLocationRelativeTo(null);
					//设置大小不可更改
					test.setResizable(false);
					//设置窗口可见
					test.setVisible(true);
				}
				else{
					JOptionPane.showConfirmDialog(null,"请输入正确的数字！","提示信息",JOptionPane.DEFAULT_OPTION);
				}
			}
		});
		
		p_bt1.add(s_btn);
		add(p_bt1,BorderLayout.SOUTH);
		
		//设置界面的大小，关闭按钮
		setSize(300,120);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//设置居中
		setLocationRelativeTo(null);
		//设置大小不可更改
		setResizable(false);
		//设置窗口可见
		setVisible(true);
	}
	//主函数
	public static void main(String[] args) {
		new Cal();
	}
	
	//判断是否数字
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