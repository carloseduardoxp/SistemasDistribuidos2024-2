public class ProdutorConsumidor {

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Produtor produtor = new Produtor(buffer);
        Consumidor consumidor = new Consumidor(buffer);

        Thread thread = new Thread(produtor);
        Thread thread1 = new Thread(consumidor);

        thread.start();
        thread1.start();
    }
}

