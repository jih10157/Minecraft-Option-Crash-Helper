package com.jih10157.MCOCH;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

class SelectFrame extends JFrame{
    private File optionFile = new File(System.getProperty("user.home")+File.separator+"AppData"+File.separator+"Roaming"+File.separator+".minecraft"+File.separator+"options.txt");
    SelectFrame(String path) {
        this();
        this.optionFile = new File(path);
    }
    SelectFrame() {
        super("MC Option Crash Helper");
        setSize(345, 205);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        JLabel text1 = new JLabel("마인크래프트를 플레이 시 1.12.2(상위 버전) 을 플레이하다가");
        JLabel text2 = new JLabel("1.5.2(하위 버전)으로 넘어갈 경우");
        JLabel text3 = new JLabel("마인크래프트 폴더 안의 options.txt 파일에 의해서");
        JLabel text4 = new JLabel("crash가 발생하는데 이를 해결하는 유틸입니다.");
        JLabel made = new JLabel("Made by. Uni_Jih");
        JLabel blog = new JLabel("개발자 블로그 바로가기");
        blog.setForeground(Color.BLUE);
        add(text1);
        add(text2);
        add(text3);
        add(text4);
        add(made);
        add(blog);
        text1.setBounds(5, 10, 350, 30);
        text2.setBounds(5, 30, 350, 30);
        text3.setBounds(5, 50, 350, 30);
        text4.setBounds(5, 70, 350, 30);
        made.setBounds(230, 90, 100, 30);
        blog.setBounds(190, 105, 150, 30);
        JLabel path = new JLabel("경로: ");
        add(path);
        JTextArea pathText = new JTextArea(this.optionFile.getPath());
        add(pathText);
        JButton runButton = new JButton("실행");
        add(runButton);
        runButton.addActionListener(e -> {
            File file = new File(pathText.getText());
            if(!file.exists()||!file.getName().equals("options.txt")) {
                JOptionPane.showMessageDialog(this, "options.txt 파일을 선택해주세요","Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Main.Run(file);
                JOptionPane.showMessageDialog(this, "해결되었습니다.", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        blog.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openBlog();
            }
        });
        path.setBounds(5, 105, 50, 30);
        pathText.setBounds(0, 130, 340, 20);
        runButton.setBounds(0, 150, 340, 30);
        setVisible(true);
    }
    private static void openBlog() {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            try { Desktop.getDesktop().browse(new URI("https://blog.naver.com/jih10157")); }
            catch (IOException | URISyntaxException e) { e.printStackTrace(); }
        }
    }
}
