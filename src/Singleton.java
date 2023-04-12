public class Singleton {

    private static Singleton admin;

    private Singleton() {}

    public static Singleton getInstance() {
        if (admin == null) {
            admin = new Singleton();
        }
        return admin;
    }
}