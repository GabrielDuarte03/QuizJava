
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Carros extends JFrame implements ItemListener {

	ButtonGroup bt = new ButtonGroup();
	JRadioButton rdBug, rdOnix, rdLambo, rdTesla, rdTracker;
	JLabel textoPer, imag, imgRes;
	JTextArea textoRes;
	ImageIcon bugatti = (new ImageIcon(Carros.class.getResource("/Imagens/certoBugatti.jpg")));
	ImageIcon onix = (new ImageIcon(Carros.class.getResource("/Imagens/onix.jpg")));
	ImageIcon lambo = new ImageIcon(Carros.class.getResource("/Imagens/lamborghini-veneno.jpg"));
	ImageIcon tesla = (new ImageIcon(Carros.class.getResource("/Imagens/Tesla.jpg")));
	ImageIcon track = new ImageIcon(Carros.class.getResource("/Imagens/track.jpg"));
	ImageIcon certo = new ImageIcon(Carros.class.getResource("/Imagens/certo.png"));
	ImageIcon errado = new ImageIcon(Carros.class.getResource("/Imagens/errado.png"));
	String caminhoC = "/Imagens/certo.wav";
	String caminhoE = "/Imagens/errado.wav";

	public Carros() {

		setTitle("Carros Caros");
		setSize(750, 700);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		getContentPane().setBackground(new Color(184, 215, 255));
		getContentPane().setLayout(null);

		imag = new JLabel();
		imgRes = new JLabel();
		textoPer = new JLabel("Qual é o carro mais caro do mundo?");
		textoPer.setBounds(170, 20, 500, 100);
		textoPer.setFont(new Font("ARIAL", 1, 25));
		textoPer.setForeground(new Color(255, 0, 0));

		rdBug = new JRadioButton("Bugatti La Voiture Noire");
		rdOnix = new JRadioButton("Chevrolet Onix S 2020");
		rdLambo = new JRadioButton("Lamborghini Veneno");
		rdTesla = new JRadioButton("Tesla Model 3");
		rdTracker = new JRadioButton("Chevrolet Tracker 2020");

		rdBug.setBackground(new Color(153, 153, 153));

		rdOnix.setBackground(new Color(102, 153, 153));

		rdLambo.setBackground(new Color(153, 153, 153));

		rdTesla.setBackground(new Color(102, 153, 153));
		rdTracker.setBackground(new Color(153, 153, 153));

		rdBug.setSelected(false);
		rdOnix.setSelected(false);
		rdLambo.setSelected(false);
		rdTesla.setSelected(false);
		rdTracker.setSelected(false);
		rdBug.setFont(new Font("ROBOTO", 1, 15));
		rdOnix.setFont(new Font("ROBOTO", 1, 15));
		rdLambo.setFont(new Font("ROBOTO", 1, 15));
		rdTesla.setFont(new Font("ROBOTO", 1, 15));
		rdTracker.setFont(new Font("ROBOTO", 1, 15));

		textoRes = new JTextArea();

		rdBug.setBounds(30, 200, 220, 30);
		rdOnix.setBounds(30, 227, 220, 30);
		rdLambo.setBounds(30, 255, 220, 30);
		rdTesla.setBounds(30, 285, 220, 30);
		rdTracker.setBounds(30, 315, 220, 30);
		imag.setBounds(30, 360, 300, 500);
		textoRes.setBounds(imag.getWidth() + 20, 380, 300, 250);
		textoRes.setEditable(false);
		textoRes.setBackground(new Color(184, 215, 255));
		textoRes.setFont(new Font("ROBOTO", 1, 12));

		bt.add(rdBug);
		bt.add(rdOnix);
		bt.add(rdLambo);
		bt.add(rdTesla);
		bt.add(rdTracker);
		getContentPane().add(imag);
		getContentPane().add(textoRes);
		getContentPane().add(rdBug);
		getContentPane().add(rdOnix);
		getContentPane().add(rdLambo);
		getContentPane().add(rdTesla);
		getContentPane().add(rdTracker);
		getContentPane().add(textoPer);
		getContentPane().add(imgRes);

		rdBug.addItemListener(this);
		rdOnix.addItemListener(this);
		rdLambo.addItemListener(this);
		rdTesla.addItemListener(this);
		rdTracker.addItemListener(this);

	}

	public void playCerto() {
		URL url = Carros.class.getResource(caminhoC);
		AudioClip audio = Applet.newAudioClip(url);
		audio.play();
	}

	public void playErrado() {
		URL url = Carros.class.getResource(caminhoE);
		AudioClip audio = Applet.newAudioClip(url);
		audio.play();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		if (rdBug.isSelected()) {
			playCerto();

			imag.setIcon(bugatti);
			textoRes.setLineWrap(true);
			textoRes.setWrapStyleWord(true);
			imgRes.setIcon(certo);
			imgRes.setBounds(300, 190, certo.getIconWidth(), certo.getIconHeight());

			textoRes.setText("Preço: US$ 18,7 milhões (R$ 70,6 milhões)\n\n"
					+ "ACERTOU! Custando US$ 12,5 milhões (R$ 47,2 milhões), que sobem para US$ 18,7 milhões (R$ 70,6 milhões) ao contar as taxas e demais custos, o Bugatti La Voiture Noire é oficialmente o carro mais caro já produzido. E com bons motivos. A interpretação moderna do Type 57 SC Atlantic de Jean Bugatti terá apenas uma unidade produzida - e já foi vendida! Seu motor é o 8.0 W16 igual ao do Chiron, produzindo 1.498 cv e 163,1 kgfm. Ele tem seis saídas de escapamento, novas rodas bem radicais, uma frente agressiva e o nome da marca na traseira totalmente iluminado. Haja extravagância!");
			imag.setBounds(30, 420, bugatti.getIconWidth(), bugatti.getIconHeight());
			textoRes.setBounds(imag.getWidth() + 40, 420, 400, 250);
			textoRes.setBackground(new Color(184, 215, 255));

		} else if (rdLambo.isSelected()) {
			playErrado();
			imgRes.setIcon(errado);
			imgRes.setBounds(300, 115, certo.getIconWidth(), certo.getIconHeight() + 100);

			imag.setIcon(lambo);
			textoRes.setLineWrap(true);
			textoRes.setWrapStyleWord(true);
			textoRes.setText("Preço: US$ 4,5 milhões (R$ 22.5 milhões)\n\n"
					+ "UMA PENA QUE ERROU, mas aproveitando --> A Lamborghini também fez um modelo extravagante e único, o Veneno. Teve apenas 14 unidades produzidas entre 2014 e 2015, cada uma custando cerca de US$ 4,5 milhões - dependendo de como era equipado. Estava disponível nas versões conversível e cupê, e usava uma versão mais potente do motor 6.5 V12 do Aventador, agora gerando 750 cv e 62,1 kgfm. Chegava até 96 km/h em 2,9 segundos. Até hoje foi o Lamborghini mais caro já vendido.");
			imag.setBounds(30, 420, lambo.getIconWidth(), lambo.getIconHeight());
			textoRes.setBounds(imag.getWidth() + 40, 420, 400, 170);
			textoRes.setBackground(new Color(184, 215, 255));
		} else if (rdOnix.isSelected()) {
			imgRes.setIcon(errado);
			playErrado();
			imgRes.setBounds(300, 115, certo.getIconWidth(), certo.getIconHeight() + 100);

			imag.setIcon(onix);
			textoRes.setLineWrap(true);
			textoRes.setWrapStyleWord(true);
			textoRes.setText("Preço: R$ 48.490\n\n"
					+ "UMA PENA QUE ERROU, mas aproveitando --> O Novo Chevrolet Onix Plus 2020 está aí e tem muitas novidades. O sedã compacto é o primeiro da dupla de entrada da General Motors, que agora foi completamente atualizada para continuar a trajetória de sucesso no mercado brasileiro, onde chegam com preços a partir de R$ 48.490.");
			imag.setBounds(30, 420, onix.getIconWidth(), onix.getIconHeight());
			textoRes.setBounds(imag.getWidth() + 40, 420, 400, 170);
			textoRes.setBackground(new Color(184, 215, 255));
		} else if (rdTesla.isSelected()) {
			imgRes.setIcon(errado);
			playErrado();
			imgRes.setBounds(300, 115, certo.getIconWidth(), certo.getIconHeight() + 100);

			imag.setIcon(tesla);
			textoRes.setLineWrap(true);
			textoRes.setWrapStyleWord(true);
			textoRes.setText("Preço: US$ 99.990 (R$ 410.895)\n\n"
					+ "UMA PENA QUE ERROU, mas aproveitando --> O Model S é um sedan esportivo elétrico produzido pela Tesla e foi lançado nos Estados Unidos em junho de 2012. Segundo a agência EPA, o carro elétrico pode andar 426 km (265 milhas) num único carregamento de seu pack de bateria de 85 kWh, atingindo assim a maior autonomia de qualquer carro elétrico disponível no mundo. modelo foi apresentado oficialmente pela Tesla em Hawthorne, California, em 26 de março de 2009.");
			imag.setBounds(30, 420, tesla.getIconWidth(), tesla.getIconHeight());
			textoRes.setBounds(imag.getWidth() + 40, 420, 400, 170);
			textoRes.setBackground(new Color(184, 215, 255));
		} else if (rdTracker.isSelected()) {
			imgRes.setIcon(errado);
			playErrado();
			imgRes.setBounds(300, 115, certo.getIconWidth(), certo.getIconHeight() + 100);

			imag.setIcon(track);
			textoRes.setLineWrap(true);
			textoRes.setWrapStyleWord(true);
			textoRes.setText("Preço: A partir de R$ 70.000 \n\n"
					+ "UMA PENA QUE ERROU, mas aproveitando --> O modelo importado do México é vendido pela Chevrolet com três versões (LT, Premier e Midnight), todas equipadas com motor 1.4 Turbo com 150 cavalos na gasolina e 153 cavalos no etanol, além de até 24,5 kgfm. O câmbio é automático de seis marchas e a tração dianteira. Com carroceria volumosa, embora compacta, o Chevrolet Tracker se destaca pelo visual com LEDs diurnos, multimídia MyLink com On Star, sistemas Google Android Auto e Apple Car Play, visual diferenciado na versão Midnight, teto solar elétrico, entre outros. Antes da atualização, o modelo tinha motor 1.8 de até 144 cavalos e o mesmo câmbio.");
			imag.setBounds(30, 420, track.getIconWidth(), track.getIconHeight());
			textoRes.setBounds(imag.getWidth() + 40, 420, 400, 250);
			textoRes.setBackground(new Color(184, 215, 255));
		}
	}

}
