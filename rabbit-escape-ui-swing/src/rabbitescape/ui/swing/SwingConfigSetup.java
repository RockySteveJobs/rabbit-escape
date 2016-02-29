package rabbitescape.ui.swing;

import static rabbitescape.engine.config.ConfigKeys.*;

import javax.swing.JFileChooser;

import rabbitescape.engine.config.ConfigFile;
import rabbitescape.engine.config.ConfigSchema;
import rabbitescape.engine.util.RealFileSystem;

public class SwingConfigSetup
{
    private static final String CONFIG_PATH =
        "~/.rabbitescape/config/ui.properties"
            .replace( "~", System.getProperty( "user.home" ) );

    public static final String CFG_GAME_WINDOW_LEFT   = "game.window.left";
    public static final String CFG_GAME_WINDOW_TOP    = "game.window.top";
    public static final String CFG_GAME_WINDOW_WIDTH  = "game.window.width";
    public static final String CFG_GAME_WINDOW_HEIGHT = "game.window.height";
    public static final String CFG_CLICK_THRESHOLD_MS = "click.threshold.ms";
    public static final String DEPRECATED_CFG_MENU_WINDOW_LEFT   = "menu.window.left";
    public static final String DEPRECATED_CFG_MENU_WINDOW_TOP    = "menu.window.top";
    public static final String DEPRECATED_CFG_MENU_WINDOW_WIDTH  = "menu.window.width";
    public static final String DEPRECATED_CFG_MENU_WINDOW_HEIGHT = "menu.window.height";
    public static final String CFG_MUTED = "muted";

    public static ConfigFile createConfig()
    {
        ConfigSchema definition = new ConfigSchema();

        definition.set(
            DEPRECATED_CFG_MENU_WINDOW_LEFT,
            String.valueOf( Integer.MIN_VALUE ),
            "deprecated"
        );
        definition.set(
            DEPRECATED_CFG_MENU_WINDOW_TOP,
            String.valueOf( Integer.MIN_VALUE ),
            "deprecated"
        );
        definition.set(
            DEPRECATED_CFG_MENU_WINDOW_WIDTH,
            String.valueOf( Integer.MIN_VALUE ),
            "deprecated"
        );
        definition.set(
            DEPRECATED_CFG_MENU_WINDOW_HEIGHT,
            String.valueOf( Integer.MIN_VALUE ),
            "deprecated"
        );

        definition.set(
            CFG_GAME_WINDOW_LEFT,
            String.valueOf( Integer.MIN_VALUE ),
            "The x position of the game window on the screen"
        );
        definition.set(
            CFG_GAME_WINDOW_TOP,
            String.valueOf( Integer.MIN_VALUE ),
            "The y position of the game window on the screen"
        );
        definition.set(
            CFG_GAME_WINDOW_WIDTH,
            String.valueOf( Integer.MIN_VALUE ),
            "The width of the game window on the screen"
        );
        definition.set(
            CFG_GAME_WINDOW_HEIGHT,
            String.valueOf( Integer.MIN_VALUE ),
            "The height of the game window on the screen"
        );

        definition.set(
            CFG_CLICK_THRESHOLD_MS,
            String.valueOf( 300 ),
            "Time in ms. Longer than this are drags." );

        definition.set(
            CFG_LEVELS_COMPLETED,
            "{}",
            "Which level you have got to in each level set."
        );

        definition.set(
            CFG_MUTED,
            String.valueOf( false ),
            "Disable all sound"
        );

        definition.set(
            CFG_LOAD_LEVEL_PATH,
            new JFileChooser().getCurrentDirectory().getAbsolutePath(),
            "Default path in the dialog to load a level file for testing."
        );

        definition.set(
            CFG_DEBUG_PRINT_STATES,
            String.valueOf( false ),
            "Rabbit states are printed to System.out."
        );

        return new ConfigFile( definition, new RealFileSystem(), CONFIG_PATH );
    }
}
