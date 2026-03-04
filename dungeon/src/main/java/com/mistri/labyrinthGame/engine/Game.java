package com.mistri.labyrinthGame.engine;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import com.mistri.labyrinthGame.model.Personaggio;
import com.mistri.labyrinthGame.world.Labirinto;

public class Game {

    private int x = 1;
    private int y = 1;

    public void start(Personaggio player) throws Exception {

        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new com.googlecode.lanterna.screen.TerminalScreen(terminal);
        screen.startScreen();
        screen.setCursorPosition(null); // nasconde cursore

        Labirinto lab = new Labirinto();

        try {

            while (true) {

                screen.clear();

                char[][] map = lab.getMappa();

                // Disegno mappa
                for (int r = 0; r < map.length; r++) {
                    for (int c = 0; c < map[r].length; c++) {
                        screen.setCharacter(c, r + 2,
                                new TextCharacter(map[r][c]));
                    }
                }

                // Disegno player
                screen.setCharacter(x, y + 2,
                        new TextCharacter(player.getEmoji().charAt(0)));

                // HUD (stats in alto)
                String hud = "Lv: " + player.getLivello() +
                        "  Vita: " + player.getStats().getVita() +
                        "  Forza: " + player.getStats().getForza() +
                        "  Mana: " + player.getStats().getMana() +
                        "  Int: " + player.getStats().getIntelligenza() +
                        "  Sta: " + player.getStats().getStamina();

                screen.newTextGraphics().putString(0, 0, hud);
                screen.newTextGraphics().putString(0, 1, "ESC per uscire");

                screen.refresh();

                KeyStroke key = screen.readInput();

                int newX = x;
                int newY = y;

                switch (key.getKeyType()) {
                    case ArrowUp:
                        newY--;
                        break;
                    case ArrowDown:
                        newY++;
                        break;
                    case ArrowLeft:
                        newX--;
                        break;
                    case ArrowRight:
                        newX++;
                        break;
                    case Escape:
                        screen.stopScreen();
                        return;
                }

                if (puoMuoversi(newX, newY, map)) {
                    x = newX;
                    y = newY;
                }
            }

        } finally {
            screen.stopScreen();
        }
    }

    private boolean puoMuoversi(int newX, int newY, char[][] map) {

        int rows = map.length;
        int cols = map[0].length;

        return newY >= 0 && newY < rows &&
                newX >= 0 && newX < cols &&
                map[newY][newX] != '▓';
    }
}