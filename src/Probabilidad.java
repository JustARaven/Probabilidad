
public class Probabilidad {
    public static void main(String[] args) {
        Contador contador = new Contador();
        Contador vecesSucedido = new Contador();
        Probabilidad probabilidad = new Probabilidad();
        //Numero de veces que has de hacer algo para que te salga lo que tú quieres
        int numeroVeces = 5;
        //Veces que intentas hacer algo
        int numeroIntentos = 3;
        //Resultado / cantidad extra esperada (0 equivale a lo que debería darte)
        int resultadoEsperado = 2;
        //Número de veces que simulas el escenario
        int numeroTotalDeSimulaciones = 100000;
        //Cantidad de números decimales, hasta un maximo de 5 | -1 te saca todos los decimales
        int cantidadDecimales = 1;

        int numerosDecimales = probabilidad.comprobarDecimales(cantidadDecimales);
        double porcentaje = 0;
        int numeroDeSucesos = 1;
        int numeroTotalDeRepeticiones = 100;
        String resultado;


        Evento evento = new Evento(contador, numeroVeces, numeroDeSucesos);

        for (int i = 1; i <= numeroTotalDeSimulaciones; i++){
            for (int k = 1; k <= numeroTotalDeRepeticiones; k++){
                for (int j = 1; j <= numeroIntentos; j++){
                    evento.calcular();
                }
                if (contador.obtenerContador() >= resultadoEsperado){
                    vecesSucedido.incrementarContador();
                }
                contador.restablecer();
            }
            porcentaje += vecesSucedido.obtenerContador();
            vecesSucedido.restablecer();
        }
        if (numerosDecimales == 0){
            resultado =  "" + Math.round(porcentaje/numeroTotalDeSimulaciones);
        }else if (numerosDecimales == -1){
            resultado = "" + (porcentaje/numeroTotalDeSimulaciones);
        } else {
            double entero = Math.floor(porcentaje/numeroTotalDeSimulaciones);
            double decimal = Math.round(((porcentaje/numeroTotalDeSimulaciones) - entero) * numerosDecimales);

            resultado = "" + (entero + (decimal / numerosDecimales));
        }

        System.out.println(resultado + " %");

    }
    int comprobarDecimales(int cantidadDecimales){

        int[] listado = {
                0, 10, 100, 1000, 10000, 100000
        };
        if (cantidadDecimales == -1){
            return -1;
        }else return listado[cantidadDecimales];

    }
}
