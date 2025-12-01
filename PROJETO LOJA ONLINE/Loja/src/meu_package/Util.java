package meu_package;

public class Util {
    
    public static void limparConsole() {
        try {
        	//Windows
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Linux/Mac
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Fallback: imprime 50 linhas em branco
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }
    
    // Outros métodos úteis podem vir aqui
    public static void pausar() {
        System.out.println("\nPressione Enter para continuar...");
        new java.util.Scanner(System.in).nextLine();
    }
}