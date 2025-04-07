package exercitiul2;

public class FormTest {
    public static void main(String[] args) {
        Form[] forms = new Form[4];
        forms[0] = new Triangle("rosu", 4, 5);
        forms[1] = new Circle("verde", 2.0f);
        forms[2] = new Triangle("rosu", 4, 5); // egal cu forms[0]
        forms[3] = new Circle("albastru", 3.0f);

        System.out.println("--- toString() pentru fiecare formă ---");
        for (Form form : forms) {
            System.out.println(form);
        }

        System.out.println("\n--- Dimensiuni forme folosind instanceof ---");
        for (Form form : forms) {
            if (form instanceof Triangle t) {
                t.printTriangleDimensions();
            } else if (form instanceof Circle c) {
                c.printCircleDimensions();
            }
        }

        System.out.println("\n--- Egalitate între triunghiuri ---");
        System.out.println("forms[0] == forms[2]? " + forms[0].equals(forms[2]));
    }
}
