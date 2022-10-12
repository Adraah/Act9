import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
        Scanner scan = new Scanner(System.in);
        CardsDeck Deck = new CardsDeck();

        System.out.println("Bienvenido al Poker!");
        System.out.println("Selecciona una opcion: ");
        System.out.println("1 Mezclar deck");
        System.out.println("2 Sacar una carta");
        System.out.println("3 Carta al azar");
        System.out.println("4 Generar una mano de 5 cartas");
        System.out.println("0 Salir");

        int num = scan.nextInt();

        switch (num){
            case 0:
                break;
            case 1:
                Deck.reset();
                System.out.println("Se mezclo el deck!");
                break;
            case 2:
                System.out.println("Primera carta: "+ Deck.getFirst());
                Deck.cardsLeft();
                break;
            case 3:
                System.out.println("Carta al azar: "+ Deck.pullRandom());
                Deck.cardsLeft();
                break;
            case 4:
                System.out.println("Mano:" + Arrays.toString(Deck.hand().toArray()));
                Deck.cardsLeft();
                break;
        }
    }
}