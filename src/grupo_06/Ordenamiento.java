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
    
    public static void Burbuja (int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j <n-i - 1; j++){
                  if (arr [j] > arr[j + 1]) {
                     int temp = arr[j];
                     arr[j] = arr[j + 1];
                     arr[j + 1] = temp;
            }
        }
    }
    public static void Insercion (int[] arr){
        int n = arr.length;
        for(int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i = 1;
        // Mueve los elementos mayores a key mas adelante
            while(j >= 0 && arr[j] > key) {
            arr[j+1] = arr[j];
            j = j - 1;
            }
            arr[j+1] = key;
            
        }
    }
    public static void imprimir(int[] array) {
        for (int numero : array) {
            System.out.print(numero + " ");
        }
        System.out.println();
    }
}

