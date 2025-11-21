public class Main {
    public static void main(String[] args){
        Hospital h1 = new Hospital("a", "d");

        Areas a1 = new Areas("a", 3, 2, h1);
        h1.agregarArea(a1);

        Medico m1 = new Medico("324", "as", 2, "M", 13, 2000, a1);
        a1.aumentarMedico();

        m1.calcularSueldoNeto(0.5);

        System.out.println(m1.getAniosAntiguedad());
        System.out.println(a1.getNumMedicos());
    }
}