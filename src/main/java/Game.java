import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
    private HashMap<String, Integer> players = new HashMap<>(); //создаем коллекцию


    public void register(Player player) {//метод регистрации (добавления в коллекцию)
        players.put(player.name, player.strength);            // в коллекцию players добавляем  вводимого player
    }

//    public Player findByName(String playerName) { //метод поиска по имени
//        for (Player player : players) {
//            if (player.getName().equals(playerName)) {
//                return player;
//            } else {
//                throw new NotRegisteredException(playerName);
//            }
//        }
//        return null;
//    }


    public int round(String playerName1, String playerName2) {  
        int player1 = 3;
        int player2 = 3;

        for (String key : players.keySet()) {
            if (key.equals(playerName1)) {  //если имя существует то player1 = сила существующего игрока
                player1 = players.get(playerName1);
            }
            if (key.equals(playerName2)) {
                player2 = players.get(playerName2);
            }
        }

        if (player1 == 3) {
            throw new NotRegisteredException(playerName1);
        }
        if (player2 == 3) {
            throw new NotRegisteredException(playerName2);
        }

        if (player1 > player2) {
            return 1;
        }
        if (player1 < player2) {
            return 2;
        }
        return 0;

    }
}
