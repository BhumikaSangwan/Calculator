import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Calculator extends Frame implements ActionListener {
    Label lb;
    String msg = "";
    String num = "";
    String symbol = "";
    float x, y;

    Calculator() {
        setSize(320, 400);
        setLayout(null);
        setVisible(true);
        // createTextfield();
        lb = new Label();
        lb.setText("Input :");
        lb.setBounds(10, 10, 160, 70);
        add(lb);
        String[] symbol = new String[16];
        symbol[0] = "9";
        symbol[1] = "8";
        symbol[2] = "7";
        symbol[3] = "/";
        symbol[4] = "6";
        symbol[5] = "5";
        symbol[6] = "4";
        symbol[7] = "*";
        symbol[8] = "3";
        symbol[9] = "2";
        symbol[10] = "1";
        symbol[11] = "-";
        symbol[12] = ".";
        symbol[13] = "0";
        symbol[14] = "=";
        symbol[15] = "+";
        int btnX = 0;
        int btnY = 90;
        int idx = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                createButton(symbol[idx++], btnX, btnY);
                btnX += 80;
            }
            btnX = 0;
            btnY += 77;
        }
    }

    public void createButton(String s, int x, int y) {
        Button btn = new Button(s);
        btn.setBounds(x, y, 80, 77);
        add(btn);
        btn.addActionListener(this);
    }

    public void createTextfield() {
        TextField tf = new TextField(10);
        tf.setText("Result : ");
        tf.setBounds(10, 10, 160, 70);
        add(tf);
    }

    public void actionPerformed(ActionEvent e) {
        Button clickedButton = (Button) e.getSource();
        String str = clickedButton.getLabel();
        if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
            symbol = str;
            char lastChar = msg.charAt(msg.length() - 1);
            if (lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/') {
                String modifiedMsg = msg.substring(0, msg.length() - 1);
                msg = "" + modifiedMsg;
            }
            x = Float.parseFloat(msg);
            msg += str;
            lb.setText(msg);
            num = "";
        } else if (str.equals("=")) {
            y = Float.parseFloat(num);
            msg += " = ";
            lb.setText(msg);
            num = "";
            float res = 0;
            switch (symbol) {
                case "+":
                    res = x + y;
                    break;
                case "-":
                    res = x - y;
                    break;
                case "*":
                    res = x * y;
                    break;
                case "/":
                    res = x / y;
                    break;
                default:
                    res = 5;
                    System.out.println(symbol);
            }
            String s = Float.toString(res);
            lb.setText(msg + s);
            msg = "";
        } else {
            num += str;
            msg += str;
            lb.setText(msg);
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}