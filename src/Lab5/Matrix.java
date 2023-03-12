package Lab5;

public abstract class Matrix implements IMatrix {

    protected int rows;
    protected int columns;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public abstract double getElement(int row, int column);

    public abstract void setElement(int row, int column, double value);
    public Matrix add(Matrix matrix) {
        if (getRows() != matrix.getRows() || getColumns() != matrix.getColumns()) {
            throw new IllegalArgumentException("Matrix sizes are not equal");
        }

        Matrix result = createMatrix(getRows(), getColumns());

        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                result.setElement(i, j, getElement(i, j) + matrix.getElement(i, j));
            }
        }

        return result;
    }

    public Matrix product(Matrix matrix) {
        if (getColumns() != matrix.getRows()) {
            throw new IllegalArgumentException("Matrix sizes are not equal");
        }

        Matrix result = createMatrix(getRows(), matrix.getColumns());

        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                double sum = 0;

                for (int k = 0; k < getColumns(); k++) {
                    sum += getElement(i, k) * matrix.getElement(k, j);
                }

                result.setElement(i, j, sum);
            }
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                builder.append(getElement(i, j) + " ");
            }

            builder.append("\n");
        }

        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Matrix)) {
            return false;
        }

        Matrix matrix = (Matrix) obj;

        if (getRows() != matrix.getRows() || getColumns() != matrix.getColumns()) {
            return false;
        }

        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                if (getElement(i, j) != matrix.getElement(i, j)) {
                    return false;
                }
            }
        }

        return true;
    }
    protected abstract Matrix createMatrix(int rows, int columns);

}