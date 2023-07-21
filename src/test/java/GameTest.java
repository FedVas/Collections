import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class GameTest {


    Player player1 = new Player(6, 31, "Vasya");
    Player player2 = new Player(3, 30, "Oleg");
    Player player3 = new Player(5, 28, "Sasha");
    Player player4 = new Player(8, 31, "Vanya");

    Game game = new Game();

    @Test
    public void firstPlayerWin() {

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Vasya", "Oleg");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondPlayerWin() {

        game.register(player3);
        game.register(player4);

        int expected = 2;
        int actual = game.round("Sasha", "Vanya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void draw() {

        game.register(player1);
        game.register(player4);

        int expected = 0;
        int actual = game.round("Vasya", "Vanya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstPlayerNotFound() {

        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Alexey", "Sasha")
        );
    }

    @Test
    public void secondPlayerNotFound() {

        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Oleg", "Tolya")
        );
    }

    @Test
    public void twoPlayersNotFound() {

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Oleg", "Tolya"));
    }

    @Test
    public void coatingGetStrength() {
        Assertions.assertEquals(31, player1.getStrength());
    }

    @Test
    public void coatingGetName() {
        Assertions.assertEquals("Sasha", player3.getName());
    }
}
