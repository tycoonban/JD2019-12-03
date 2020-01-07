package by.it.kuzmichalex.jd01_08;

import com.sun.istack.internal.NotNull;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.sql.SQLOutput;

class Scalar extends Var {
    double value;

    /*******************
     * constructors
     *******************/
    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    /*****************************
     * Override Var.toString method
     *****************************/
    @Override
    public String toString() {
        return Double.toString(this.value);
    }

    //////////////////////// Сложения со скаляром
    @Override
    public Var add(Var rightOperand) {
        System.out.println("Scalar.add var " + rightOperand);
        return rightOperand.add(this);
    }

    //Scalar+Scalar
    @Override
    public Var add(Scalar leftOperand) {
        System.out.println("Scalar + Scalar " + leftOperand + " " + this);
        return new Scalar(leftOperand.value + this.value);
    }

    //Vector+Scalar
    @Override
    public Var add(Vector leftOperand) {
        return leftOperand.add(this);
    }

    //Matrix+Scalar
    @Override
    public Var add(Matrix leftOperand) {
        return leftOperand.add(this);
    }

    //////////////////////// Отнимание скаляра
    @Override
    public Var sub(Var rightOperand) {
        System.out.println("Scalar.sub var " + rightOperand);
        return rightOperand.sub(this);
    }

    //Scalar-Scalar
    @Override
    public Var sub(Scalar leftOperand) {
        System.out.println("Scalar - Scalar " + leftOperand + " " + this);
        return new Scalar(leftOperand.value - this.value);
    }

    //Vector-Scalar
    @Override
    public Var sub(Vector leftOperand) {
        Var minusScalar = new Scalar(this.value * -1.0);
        return leftOperand.add(minusScalar);
    }

    //Matrix - Scalar
    @Override
    public Var sub(Matrix leftOperand) {
        double[][] returnMatrix = new double[leftOperand.value.length][leftOperand.value[0].length];
        for (int y = 0; y <leftOperand.value.length ; y++) {
            for (int x = 0; x <leftOperand.value.length ; x++) {
                returnMatrix[x][y]=leftOperand.value[x][y]-this.value;
            }
        }
        return new Matrix(returnMatrix);
    }

    //////////////////////// Умножения на скаляр
    @Override
    public Var mul(Var rightOperand) {
        System.out.println("Scalar.sub var " + rightOperand);
        return rightOperand.mul(this);
    }

    //Scalar*Scalar
    @Override
    public Var mul(Scalar leftOperand) {
        System.out.println("Scalar * Scalar " + leftOperand + " " + this);
        return new Scalar(leftOperand.value * this.value);
    }

    //Vector*Scalar
    @Override
    public Var mul(Vector leftOperand) {
        return leftOperand.mul(this);
    }

    //Matrix*Scalar
    @Override
    public Var mul(Matrix leftOperand) {
        return leftOperand.mul(this);
    }

    //////////////////////// деления на скаляр
    @Override
    public Var div(Var rightOperand) {
        System.out.println("Scalar.div var " + rightOperand);
        return rightOperand.div(this);
    }

    //Scalar/Scalar
    @Override
    public Var div(Scalar leftOperand) {
        System.out.println("Scalar / Scalar " + leftOperand + " " + this);
        if (this.value == 0) {
            System.out.println("Деление на ноль detected");
            return null;
        }
        return new Scalar(leftOperand.value / this.value);
    }

    //Vector/Scalar
    @Override
    public Var div(Vector leftOperand) {
        System.out.println("Vector /Scalar " + leftOperand + " " + this);
        double[] returnVector = new double[leftOperand.value.length];
        for (int i = 0; i < leftOperand.value.length; i++) {
            returnVector[i] = leftOperand.value[i] / this.value;
        }
        return new Vector(returnVector);
    }
}

