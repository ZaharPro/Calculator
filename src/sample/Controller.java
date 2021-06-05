package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label oper;

    @FXML
    void backspaceAction() {
        int l = s2.length() - 1;
        if (l >= 0) {
            if (l == 0) {
                oper.setText("");
                s2 = "";
            } else {
                s2 = s2.substring(0, l);
            }
        } else {
            s2 = s1;
            s1 = "";
        }
        label1.setText(s1);
        label2.setText(s2);
    }

    @FXML
    void cAction() {
        s1 = EMPTY;
        s2 = EMPTY;
        operations = NONE;
        oper.setText(operations);
        label1.setText(s1);
        label2.setText(s2);
    }

    @FXML
    void procentAction() {
        setOperation(PROCENT);
    }

    @FXML
    void divAction() {
        setOperation(DIV);
    }

    @FXML
    void multiplyAction() {
        setOperation(MULTIPLY);
    }

    @FXML
    void minusAction() {
        setOperation(MINUS);
    }

    @FXML
    void sumAction() {
        setOperation(SUM);
    }

    @FXML
    void resultAction() {
        calculate();
    }

    @FXML
    void expAction() {
        if (s2.isEmpty())
            append("" + Math.E);
    }

    @FXML
    void pointAction() {
        append(".");
    }

    @FXML
    void nineAction() {
        append(9);
    }

    @FXML
    void eightAction() {
        append(8);
    }

    @FXML
    void sevenAction() {
        append(7);
    }

    @FXML
    void sixAction() {
        append(6);
    }

    @FXML
    void fiveAction() {
        append(5);
    }

    @FXML
    void fourAction() {
        append(4);
    }

    @FXML
    void threeAction() {
        append(3);
    }

    @FXML
    void twoAction() {
        append(2);
    }

    @FXML
    void oneAction() {
        append(1);
    }

    @FXML
    void zeroAction() {
        append(0);
    }


    private static final String EMPTY = "";
    private static final String NONE = "";
    private static final String SUM = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIV = "/";
    private static final String PROCENT = "%";

    private String operations = NONE;
    private String s1 = EMPTY;
    private String s2 = EMPTY;

    private void append(int i) {
        append("" + i);
    }

    private void append(String s) {
        s2 += s;
        label2.setText(s2);
    }

    private void setOperation(String s) {
        if (operations.equals(NONE)) {
            operations = s;
            oper.setText(operations);
        }

        if (s1.isEmpty()) {
            s1 = s2;
            s2 = EMPTY;
            label1.setText(s1);
            label2.setText(s2);
        } else {
            calculate();
        }
    }

    private void calculate() {
        if (s2.isEmpty())
            return;
        try {
            double value = Double.parseDouble(s2);
            switch (operations) {
                case SUM:
                    value = Double.parseDouble(s1) + value;
                    break;
                case MINUS:
                    value = Double.parseDouble(s1) - value;
                    break;
                case MULTIPLY:
                    value = Double.parseDouble(s1) * value;
                    break;
                case DIV:
                    value = Double.parseDouble(s1) / value;
                    break;
                case PROCENT:
                    value = Double.parseDouble(s1) * value / 100;
                    break;
                case NONE:
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + operations);
            }
            s2 = Double.toString(value);
        } catch (NumberFormatException e) {
            s2 = EMPTY;
        }
        s1 = EMPTY;
        label1.setText(s1);
        label2.setText(s2);

        operations = NONE;
        oper.setText(operations);
    }
}