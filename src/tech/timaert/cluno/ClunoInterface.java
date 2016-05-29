package tech.timaert.cluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClunoInterface {
    private Engine engine;
    private int playerAmount = 0;
    private List<String> playerNames;
    private Scanner scanner;

    public ClunoInterface() {
        scanner = new Scanner(System.in);
        engine = new Engine();
        showStartup();
        requestPlayerAmount();
        enterPlayerNames();
        createPlayers();
        engine.startGame();
    }

    private void showStartup() {
        System.out.println("===========================================");
        System.out.println("  _____   _        _    _   _   _    ____");
        System.out.println(" / ____| | |      | |  | | | \\ | |  / __ \\");
        System.out.println("| |      | |      | |  | | |  \\| | | |  | |");
        System.out.println("| |      | |      | |  | | | . ` | | |  | |");
        System.out.println("| |____  | |____  | |__| | | |\\  | | |__| |");
        System.out.println(" \\_____| |______|  \\____/  |_| \\_|  \\____/");
        System.out.println("");
        System.out.println("===========================================");
        System.out.println("");
    }

    private void requestPlayerAmount() {
        do {
            askValidPlayerAmount();
        } while(playerAmount < 2 && 10 > playerAmount);
    }

    private void askValidPlayerAmount() {
        System.out.print("Player Amount? (2 - 10): ");
        playerAmount = scanner.nextInt();
    }

    private void enterPlayerNames() {
        playerNames = new ArrayList<>();
        String validUsername;

        for(int i = 0; i < playerAmount; i++){
            validUsername = askUsername(i + 1);
            playerNames.add(validUsername);
        }
    }

    private String askUsername(int index) {
        String playerName;

        do {
            System.out.print("Name player " + index + "? : ");
            playerName = scanner.next();
        } while(!checkValidPlayerName(playerName));

        return playerName;
    }

    private boolean checkValidPlayerName(String playerName) {
        int nameLen = playerName.length();
        boolean isValidLength = 0 < nameLen && nameLen < 18;
        return playerName.isEmpty() || isValidLength;
    }

    private void createPlayers() {
        playerNames.forEach(engine::addPlayer);
    }
}
