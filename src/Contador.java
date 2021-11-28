public class Contador {
    int contador = 0;

    void incrementarContador(){
        contador++;
    }
    int obtenerContador(){
        return contador;
    }

    void restablecer(){
        contador = 0;
    }

}
