public class Uni5Exe10 {
    public static void main(String[] args) {
        System.out.println("Os 10 primeiros números com a propriedade especial:");
        
        for (int number = 1000, count = 0; count < 10; number++) {
            int firstPart = number / 100;
            int secondPart = number % 100;
            int sum = firstPart + secondPart;
            
            if (sum * sum == number) {
                System.out.println(number);
                count++;
            }
        }
    }
}