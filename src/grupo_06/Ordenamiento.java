package grupo_06;
/*
Aqui deje los ordenamientos a usar, quick cumple con divide and conquer y eso de ser eficiente
 y el insercion para cumplir con lo del algoritmo cuadratico, aun no se en que parte implementarlos todavia
 creo que eso lo vemos despues
*/
public class Ordenamiento {
    /*El quick sort tiene una complejidad de O(n log n) porque divide el arreglo en dos mitades iguales
    constantemente , su peor caso es 0(N^2) si el pivote que se elige siempre es el menor o mayor del array
    */
    public static void QuickSort(int[] array, int inicio, int fin){
        if (inicio < fin) {
            int posPivote = partir(array, inicio, fin); 

            QuickSort(array, inicio, posPivote - 1);
            QuickSort(array, posPivote + 1, fin);
        }
    }
    public static int partir(int[] arreglo, int inicio, int fin) {
        int pivote = arreglo[fin];  
        int indiceMin = inicio - 1;  

        for (int indiceActual = inicio; indiceActual < fin; indiceActual++) {
            if (arreglo[indiceActual] <= pivote) {
                indiceMin++;

                int temp = arreglo[indiceMin];
                arreglo[indiceMin] = arreglo[indiceActual];
                arreglo[indiceActual] = temp;
            }
        }

        int temp = arreglo[indiceMin + 1];
        arreglo[indiceMin + 1] = arreglo[fin];
        arreglo[fin] = temp;

        return indiceMin + 1; 
    }
    //Aqui cache que podiamos usar sobrecarga para no tener el codigo aqui muerto fsoiuaghfoa
    public static void QuickSortReclamos(Reclamos[] array, int inicio, int fin) {
        if (inicio < fin) {
            int posPivote = partirReclamos(array, inicio, fin); 

            QuickSortReclamos(array, inicio, posPivote - 1);
            QuickSortReclamos(array, posPivote + 1, fin);
        }
    }
    private static int partirReclamos(Reclamos[] arreglo, int inicio, int fin) {
        //usamos la prioridad como pivote
        int pivote = arreglo[fin].getNivelPrioridad();  
        int indiceMin = inicio - 1;  

        for (int indiceActual = inicio; indiceActual < fin; indiceActual++) {
            //comparamos usando el getter de la prioridad
            if (arreglo[indiceActual].getNivelPrioridad() <= pivote) {
                indiceMin++;

                //intercambiamos las referencias
                Reclamos temp = arreglo[indiceMin];
                arreglo[indiceMin] = arreglo[indiceActual];
                arreglo[indiceActual] = temp;
            }
        }
        Reclamos temp = arreglo[indiceMin + 1];
        arreglo[indiceMin + 1] = arreglo[fin];
        arreglo[fin] = temp;

        return indiceMin + 1; 
    }
    
    public static void InsertionFecha(Reclamos[] arr, int[] dias, int n){        
        for(int i=1; i<n; i++){
            Reclamos keyReclamo = arr[i];
            int keyDias = dias[i];
            int j = i-1;
            
            while(j >= 0 && dias[j] > keyDias){
                arr[j+1] = arr[j];
                dias[j+1] = dias[j];
                j--;
            }
            arr[j+1] = keyReclamo;
            dias[j+1] = keyDias;
        }
    }
    
    public static void imprimir(int[] array) {
        for (int numero : array) {
            System.out.print(numero + " ");
        }
        System.out.println();
    }
}
