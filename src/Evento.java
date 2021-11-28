public class Evento {
    Contador contador;
    int numeroVeces;
    int numeroDeSucesos;

    public Evento(Contador contador, int numeroVeces, int numeroDeSucesos){
        this.contador = contador;
        this.numeroVeces = numeroVeces;
        this.numeroDeSucesos = numeroDeSucesos;
    }

    void calcular() {
        int numero = (int) (Math.random()*numeroVeces+1);
        if (numero == numeroDeSucesos){
            contador.incrementarContador();
        }
    }
}
