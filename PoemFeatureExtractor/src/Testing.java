import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Testing extends JPanel{
	public static String sx1, sx2, sy1, sy2;
	public void paintComponent(Graphics g) {
		int x1 = Integer.parseInt(sx1);
		int y1 = Integer.parseInt(sy1);
		int x2 = Integer.parseInt(sx2);
		int y2 = Integer.parseInt(sy2);
		int dx = x2 - x1;
		int dy = y2 - y1;
		int steps;
		if(Math.abs(dx) > Math.abs(dy))
			steps = dx;
		else
			steps = dy;
		float xinc = dx / steps;
		float yinc = dy / steps;
		int k;
		float x = x1, y = y1;
		g.drawLine(Math.round(x), Math.round(y), Math.round(x), Math.round(y));
		for(k = 0; k < steps; k++)
		{
			x = x + xinc;
			y = y + yinc;
			g.drawLine(Math.round(x), Math.round(y), Math.round(x), Math.round(y));
		}
		
	}
	public static void main(String args[])
	{
		sx1 = JOptionPane.showInputDialog("Enter x1 : ");
		sy1 = JOptionPane.showInputDialog("Enter y1 : ");
		sx2 = JOptionPane.showInputDialog("Enter x2 : ");
		sy2 = JOptionPane.showInputDialog("Enter y2 : ");
		JFrame f = new JFrame("DDA");
		f.setSize(500,500);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new Testing());
	}
}
