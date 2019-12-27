package by.it.filipovich.jd01_08;

public class Matrix extends Var {

    private double[][] value;

    public Matrix(double[][] value){
    this.value = new double[value.length][value[0].length];

    for (int i = 0; i < value.length; i++) {
        for (int j = 0; j < value[0].length; j++) {
            this.value[i][j] = value[i][j];
        }
    }
    }

    public Matrix(Matrix matrix){
        this(matrix.value);
    }

    public Matrix(String strMatrix){

    }

    public String toString(){

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            for (int j = 0; j < value[0].length; j++) {
                sb.append(value[i][j]);
                if(j != value[0].length-1)
                    sb.append(", ");
            }
            sb.append("}");
            if(i != value.length-1)
                sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }

}
