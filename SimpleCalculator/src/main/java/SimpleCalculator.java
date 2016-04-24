import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SimpleCalculator implements ActionListener {

  private JFrame f;
  private JMenuBar menuBar;
  private JMenu menu, submenu;
  private JTextField display;
  private JButton sevenButton, eightButton, nineButton, divideButton, equalsButton;
  private JButton fourButton, fiveButton, sixButton, multiplyButton;
  private JButton oneButton, twoButton, threeButton, subtractionButton;
  private JButton zeroButton, dotButton, deleteButton, additionButton;
  private ArrayList<JButton> buttons;

  private final static int externalBorder = 10;
  private final static int margin = 5;

  private final static int xScreen = 225;
  private final static int yScreen = 260;
  private final static int xText = xScreen - (2 * externalBorder) - margin;
  private final static int yText = 50;
  private final static int xButton = 35;
  private final static int yButton = 25;
  private final static int yButtonsFirstRow = externalBorder + yText + margin; // Space for display
  private final static int yButtonsSecondRow = yButtonsFirstRow + yButton + margin;
  private final static int yButtonsThirdRow = yButtonsSecondRow + yButton + margin;
  private final static int yButtonsFourthRow = yButtonsThirdRow + yButton + margin;

  private static ScriptEngine engine;

  public SimpleCalculator() {
    f = new JFrame();
    f.setResizable(false);

    menuBar = new JMenuBar();
    menu = new JMenu("Ver");
    menuBar.add(menu);
    menu = new JMenu("Edición");
    menuBar.add(menu);
    menu = new JMenu("Ayuda");
    menuBar.add(menu);

    engine = new ScriptEngineManager().getEngineByExtension("js");

    display = new JTextField();
    display.setBounds(externalBorder, externalBorder, xText, yText);
    display.setText("0");
    Font font = display.getFont();
    font = font.deriveFont(font.getSize() * 1.8f);
    display.setFont(font);
    display.setHorizontalAlignment(SwingConstants.TRAILING);
    display.setFocusable(false);

    buttons = new ArrayList<JButton>();

    sevenButton = new JButton("7");
    eightButton = new JButton("8");
    nineButton = new JButton("9");
    divideButton = new JButton("/");
    equalsButton = new JButton("=");

    fourButton = new JButton("4");
    fiveButton = new JButton("5");
    sixButton = new JButton("6");
    multiplyButton = new JButton("*");

    oneButton = new JButton("1");
    twoButton = new JButton("2");
    threeButton = new JButton("3");
    subtractionButton = new JButton("-");

    zeroButton = new JButton("0");
    dotButton = new JButton(".");
    deleteButton = new JButton("C");
    additionButton = new JButton("+");

    sevenButton.setMargin(new Insets(0, 0, 0, 0));
    eightButton.setMargin(new Insets(0, 0, 0, 0));
    nineButton.setMargin(new Insets(0, 0, 0, 0));
    divideButton.setMargin(new Insets(0, 0, 0, 0));
    equalsButton.setMargin(new Insets(0, 0, 0, 0));

    fourButton.setMargin(new Insets(0, 0, 0, 0));
    fiveButton.setMargin(new Insets(0, 0, 0, 0));
    sixButton.setMargin(new Insets(0, 0, 0, 0));
    multiplyButton.setMargin(new Insets(0, 0, 0, 0));

    oneButton.setMargin(new Insets(0, 0, 0, 0));
    twoButton.setMargin(new Insets(0, 0, 0, 0));
    threeButton.setMargin(new Insets(0, 0, 0, 0));
    subtractionButton.setMargin(new Insets(0, 0, 0, 0));

    zeroButton.setMargin(new Insets(0, 0, 0, 0));
    dotButton.setMargin(new Insets(0, 0, 0, 0));
    deleteButton.setMargin(new Insets(0, 0, 0, 0));
    additionButton.setMargin(new Insets(0, 0, 0, 0));

    sevenButton.addActionListener(this);
    eightButton.addActionListener(this);
    nineButton.addActionListener(this);
    divideButton.addActionListener(this);
    equalsButton.addActionListener(this);

    fourButton.addActionListener(this);
    fiveButton.addActionListener(this);
    sixButton.addActionListener(this);
    multiplyButton.addActionListener(this);

    oneButton.addActionListener(this);
    twoButton.addActionListener(this);
    threeButton.addActionListener(this);
    subtractionButton.addActionListener(this);

    zeroButton.addActionListener(this);
    dotButton.addActionListener(this);
    deleteButton.addActionListener(this);
    additionButton.addActionListener(this);

    sevenButton.setBounds(externalBorder, yButtonsFirstRow, xButton, yButton);
    eightButton.setBounds(externalBorder + xButton + margin, yButtonsFirstRow, xButton, yButton);
    nineButton.setBounds(externalBorder + (2 * xButton) + (2 * margin), yButtonsFirstRow, xButton,
        yButton);
    divideButton.setBounds(externalBorder + (3 * xButton) + (3 * margin), yButtonsFirstRow, xButton,
        yButton);
    equalsButton.setBounds(externalBorder + (4 * xButton) + (4 * margin), yButtonsFirstRow, xButton,
        (4 * yButton) + (3 * margin));

    fourButton.setBounds(externalBorder, yButtonsSecondRow, xButton, yButton);
    fiveButton.setBounds(externalBorder + xButton + margin, yButtonsSecondRow, xButton, yButton);
    sixButton.setBounds(externalBorder + (2 * xButton) + (2 * margin), yButtonsSecondRow, xButton,
        yButton);
    multiplyButton.setBounds(externalBorder + (3 * xButton) + (3 * margin), yButtonsSecondRow,
        xButton, yButton);

    oneButton.setBounds(externalBorder, yButtonsThirdRow, xButton, yButton);
    twoButton.setBounds(externalBorder + xButton + margin, yButtonsThirdRow, xButton, yButton);
    threeButton.setBounds(externalBorder + (2 * xButton) + (2 * margin), yButtonsThirdRow, xButton,
        yButton);
    subtractionButton.setBounds(externalBorder + (3 * xButton) + (3 * margin), yButtonsThirdRow,
        xButton, yButton);

    zeroButton.setBounds(externalBorder, yButtonsFourthRow, xButton, yButton);
    dotButton.setBounds(externalBorder + xButton + margin, yButtonsFourthRow, xButton, yButton);
    deleteButton.setBounds(externalBorder + (2 * xButton) + (2 * margin), yButtonsFourthRow,
        xButton, yButton);
    additionButton.setBounds(externalBorder + (3 * xButton) + (3 * margin), yButtonsFourthRow,
        xButton, yButton);

    f.setJMenuBar(menuBar);

    f.add(display);


    f.add(sevenButton);
    f.add(eightButton);
    f.add(nineButton);
    f.add(divideButton);
    f.add(equalsButton);

    f.add(fourButton);
    f.add(fiveButton);
    f.add(sixButton);
    f.add(multiplyButton);

    f.add(oneButton);
    f.add(twoButton);
    f.add(threeButton);
    f.add(subtractionButton);

    f.add(zeroButton);
    f.add(dotButton);
    f.add(deleteButton);
    f.add(additionButton);

    f.setSize(xScreen, yScreen);
    f.setLayout(null);
    f.setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("=")) {
      try {
        display.setText(engine.eval(display.getText()).toString());
      } catch (ScriptException se) {
        display.setText("Syntax error");
      }
    } else if (e.getActionCommand().equals("C")) {
      display.setText("0");
    } else if (display.getText().equals("0")) {
      display.setText(e.getActionCommand());
    } else {
      display.setText(display.getText() + e.getActionCommand());
    }
  }

  public static void main(String[] args) {
    new SimpleCalculator();
  }
}
