import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
    private HashMap<String, Integer> players = new HashMap<>(); //создаем коллекцию


    public void register(Player player) {//метод регистрации (добавления в коллекцию)
        players.put(player.name, player.strength);            // в коллекцию players добавляем  вводимого player
    }

    public int round(String playerName1, String playerName2) {
        int player1Strength = -1;
        int player2Strength = -1;

        if (players.containsKey(playerName1)) {  //если в мапе находится имя 1ого игрока,то player1 = его сила
            player1Strength = players.get(playerName1);
        }

        if (players.containsKey(playerName2)) { //если в мапе находится имя 2ого игрока, то player2 = его сила
            player2Strength = players.get(playerName2);
        }

        if (player1Strength == -1) {
            throw new NotRegisteredException(playerName1);
        }
        if (player2Strength == -1) {
            throw new NotRegisteredException(playerName2);
        }

        if (player1Strength > player2Strength) {
            return 1;
        }
        if (player1Strength < player2Strength) {
            return 2;
        }
        return 0;

    }
}
