public class App {
    public static void main(String[] args) throws Exception {
        Corrida schumacher = new Corrida("Schumacher");
        Corrida senna = new Corrida("Senna");
        Corrida barrichello = new Corrida("Barrichello");
        Thread thread = new Thread(schumacher);
        Thread thread1 = new Thread(senna);
        Thread thread2 = new Thread(barrichello);
        thread.join();
        thread1.join();
        thread2.join();
        System.out.println("Acabou a corrida");
    }
}
