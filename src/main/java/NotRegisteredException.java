public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String playerName) {
        super("Игрок с именем " + playerName + " не найден");
    }
}

/* int player1 = players.get(playerName1);
        int player2 = players.get(playerName2);*/
