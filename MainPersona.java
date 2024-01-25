public class MainPersona {
    public static void main(String[] args) {
        Persona persona0 = new Persona("Francisco", "Muñoz", 21, "20911537Y");
        Persona persona1= new Persona("Ramon", "Gual", 15, "20956717Z");
        Persona persona2= new Persona("Adolfo", "Tur", 67, "54433876Y");
        persona0.print();
        persona1.print();
        persona2.print();
        persona0.isAdult();
        persona1.isAdult();
        persona2.isAdult();
        persona0.isRetired();
        persona1.isRetired();
        persona2.isRetired();
        persona0.ageDifference(persona1);
        persona0.ageDifference(persona2);
        persona1.ageDifference(persona2);
    }
}