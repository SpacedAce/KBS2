package BPP;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class helpPanel extends JFrame{
	public helpPanel(){
		setTitle("Help");
		setSize(500, 800);
		setLayout(new FlowLayout());
		
		ImageIcon image = new ImageIcon(getClass().getResource("helpPanelimg/hoofdscherm.png"));
		JLabel img = new JLabel();
		img.setIcon(image);
		img.setBounds(10, 10, 350, 240);
		img.setBorder(new EmptyBorder(0, 10, 0, 10));
		add(img);
		String _text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent cursus lectus lorem, in efficitur erat eleifend vitae. Aenean sit amet facilisis nisi, a pulvinar diam. Duis velit risus, maximus et nulla vel, varius suscipit massa. Phasellus in fringilla velit. Phasellus maximus fermentum quam vel tristique. Morbi aliquam enim ut interdum consequat. Praesent nulla velit, imperdiet sagittis mauris in, tempus vehicula augue. Proin congue libero ut interdum semper. Donec sagittis ex volutpat eros tincidunt, a semper erat imperdiet. Praesent tincidunt vulputate ante, sagittis tincidunt odio lobortis at. Nunc eu ante quis sapien blandit facilisis. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. In nunc quam, ullamcorper vitae mauris sit amet, ullamcorper venenatis ligula. Nulla scelerisque risus sit amet lacus vulputate, quis euismod mauris eleifend. In eleifend blandit elementum."
				+ "                                                                 Pellentesque convallis varius arcu, nec maximus dui auctor vel. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Vivamus consequat ac velit a vulputate. Sed egestas nulla dolor, vel dignissim massa feugiat sit amet. Aliquam varius justo sapien, sed placerat elit laoreet et. Aenean vel ante et elit accumsan porta eu mattis tellus. Donec in purus sagittis, tristique orci in, euismod urna. Vivamus facilisis porttitor nibh, dignissim ullamcorper quam.";
		JLabel text =  new JLabel(String.format("<html><div style=\"width:%dpx;\">%s</div><html>", 360, _text));
		text.setBounds(10, 250, 480, 540);
		add(text);
		
		setVisible(true);
	}
}
