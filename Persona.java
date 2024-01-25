public class Persona {
    private String name;
    private String lastName;
    private final String dni;
    private int age;
    private static final int minimumAge = 0;
    private static final int adultAge = 18;
    private static final int retiredAge = 65;
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public String getDni() {
        return dni;
    }
    public void setAge(int age) {
        if (age>0) {
            this.age = age;
        }
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Persona(String name, String lastName, int age, String dni) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        if (checkDni(dni)) {
            this.dni = dni;
        } else {
            this.dni = "ERROR: DNI INCORRECTO";
        }
    }
    @Override
    public String toString() {
        return "------------\n" +
                "Nombre: " + name + "\n" +
                "Apellido: " + lastName + "\n" +
                "DNI: " + dni + "\n" +
                "Edad: " + age + "\n" +
                "------------";
    }
    public void print() {
        System.out.println(this);
    }
    public void isAdult() {
        if (age >= adultAge) {
            System.out.println(name + " " + lastName + " es mayor de edad.");
        } else {
            System.out.println(name + " " + lastName + " no es mayor de edad.");
        }
    }
    public void isRetired() {
        if (age >= retiredAge) {
            System.out.println(name + " " + lastName + " está jubilado/a.");
        } else {
            System.out.println(name + " " + lastName + " no está jubilado/a.");
        }
    }
    public void ageDifference(Persona persona) {
        if (age >= persona.age) {
            System.out.println("La diferencia de edad es de " + (age - persona.age) + " años.");
        } else {
            System.out.println("La diferencia de edad es de " + (persona.age - age) + " años.");
        }
    }
    public static boolean checkDni(String dni){
        boolean checkDni = true;
        String dniNumbers = dni.substring(0,8);
        String dniLetter = dni.substring(8);
        int numbers = Integer.parseInt(dniNumbers);
        int indexOfLetter = numbers % 23;
        char calculatedLetter = "TRWAGMYFPDXBNJZSQVHLCKE".charAt(indexOfLetter);
        if (dni.length() !=9) {
            checkDni = false;
        } else if (!dniLetter.equals(String.valueOf(calculatedLetter))){
            checkDni = false;
        }
        return checkDni;
    }
}