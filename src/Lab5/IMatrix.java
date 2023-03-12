package Lab5;

public interface IMatrix {
    public int getRows();

    public int getColumns();

    public double getElement(int row, int column);

    public void setElement(int row, int column, double value);
}
