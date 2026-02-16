public class Pasillo extends Comunes{
    private int numPasillo;

    public Pasillo(double tamaño, int numPasillo) {
        super(tamaño);
        this.numPasillo = numPasillo;
    }

    public int getNumPasillo() {
        return numPasillo;
    }

    public void setNumPasillo(int numPasillo) {
        this.numPasillo = numPasillo;
    }
}
