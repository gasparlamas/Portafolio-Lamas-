public class Factorial {
    public static void main(String[] args) throws Exception {
        
        int prueba = factorial(5);
        System.out.println("El factorial es: " + prueba);
        
        int pares = sumaPares(6);
        System.out.println(pares);
    }

    public static int factorial(int num){
        int resultado = 1;

        for(int i = 1; i <= num;  i++){
            resultado *= i;
        }
    return resultado;
    }


    public static int sumaPares(int n){
        int resultado = 0;
        int i = 0;
        if (isPrime(n) == true){
            while (i<=n){
                if (i%2 == 0){
                    resultado += i;
                }
                i++;
            }
        } else{
            while (i<=n){
            if (i%2 != 0){
                resultado +=i;
            }
            i++;
        }
        }
        return resultado;
    } 




    public static boolean isPrime(long n) {
        boolean prime = true;
        for (long i = 3; i <= Math.sqrt(n); i += 2)
            if (n % i == 0) {
                prime = false;
                break;
            }
        if (( n%2 !=0 && prime && n > 2) || n == 2) {
               return true;
        } else {
               return false;
        }
        }
}
