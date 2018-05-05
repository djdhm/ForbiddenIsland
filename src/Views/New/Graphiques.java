/**
 *
 */
package Views.New;
import java.awt.Color;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.border.Border;



/**
 * @author nihil
 *
 */
public class Graphiques {
    // borders
    public static final Border ACTIVE_BORDER_SELECTED = BorderFactory.createLineBorder(Color.GREEN, 5, true);

    public static final Border ACTIVE_BORDER_HOVER       = BorderFactory.createLineBorder(new Color(10, 194, 10), 5,
            true);
    public static final Border ACTIVE_BORDER_SHORE_HOVER = BorderFactory.createLineBorder(new Color(255, 212, 2), 5,
            true);
    public static final Border ACTIVE_BORDER_SWIM_HOVER  = BorderFactory.createLineBorder(Color.BLUE, 5, true);
    public static final Border ACTIVE_BORDER_EXIT        = BorderFactory.createLineBorder(new Color(70, 255, 104), 4,
            true);
    public static final Border ACTIVE_BORDER_SWIM_EXIT   = BorderFactory.createLineBorder(new Color(20, 79, 254), 4,
            true);
    public static final Border ACTIVE_BORDER_SHORE_EXIT  = BorderFactory.createLineBorder(new Color(249, 170, 0), 4,
            true);
    public static final Border INACTIVE_BORDER           = BorderFactory.createLineBorder(Color.GRAY, 3, true);


    public static final String [][] ImageZone={
            {
                "./res/images/zones/Breakers Bridge@2x.png",
                "./res/images/zones/Bronze Gate@2x.png",
                "./res/images/zones/Cave of Embers@2x.png",
                "./res/images/zones/Cave of Shadows@2x.png",
                "./res/images/zones/Cliffs of Abandon@2x.png",
                "./res/images/zones/Copper Gate@2x.png"
            },  {
                "./res/images/zones/Coral Palace@2x.png",
                "./res/images/zones/Crimson Forest@2x.png",
                "./res/images/zones/Dunes of Deception@2x.png",
                "./res/images/zones/Fools' Landing@2x.png",
                "./res/images/zones/Breakers Bridge@2x.png",
                "./res/images/zones/Breakers Bridge@2x.png"
            },  {
                "./res/images/zones/Gold Gate@2x.png",
                "./res/images/zones/Breakers Bridge@2x.png",
                "./res/images/zones/Breakers Bridge@2x.png",
                "./res/images/zones/Breakers Bridge@2x.png",
                "./res/images/zones/Breakers Bridge@2x.png",
                "./res/images/zones/Breakers Bridge@2x.png"
            },  {
                "./res/images/zones/Breakers Bridge@2x.png",
                "./res/images/zones/Breakers Bridge@2x.png",
                "./res/images/zones/Breakers Bridge@2x.png",
                "./res/images/zones/Breakers Bridge@2x.png",
                "./res/images/zones/Breakers Bridge@2x.png",
                "./res/images/zones/Breakers Bridge@2x.png"
            },  {
                "./res/images/zones/Breakers Bridge@2x.png",
                "./res/images/zones/Breakers Bridge@2x.png",
                "./res/images/zones/Breakers Bridge@2x.png",
                "./res/images/zones/Breakers Bridge@2x.png",
                "./res/images/zones/Breakers Bridge@2x.png",
                "./res/images/zones/Breakers Bridge@2x.png"
            },  {
                "./res/images/zones/Breakers Bridge@2x.png",
                "./res/images/zones/Breakers Bridge@2x.png",
                "./res/images/zones/Breakers Bridge@2x.png",
                "./res/images/zones/Breakers Bridge@2x.png",
                "./res/images/zones/Breakers Bridge@2x.png",
                "./res/images/zones/Breakers Bridge@2x.png"
            }
    };
    // Pawns
//    private static PawnComponent DIVER;
//    private static PawnComponent EXPLORER;
//    private static PawnComponent ENGINEER;
//    private static PawnComponent MESSENGER;
//    private static PawnComponent PILOT;
//    private static PawnComponent NAVIGATOR;


    /**
     * @author nihil
     *
     */
//    public static void init(Observer obs) {
//        DIVER = new PawnComponent(AdventurerType.DIVER, obs);
//        EXPLORER = new PawnComponent(AdventurerType.EXPLORER, obs);
//        ENGINEER = new PawnComponent(AdventurerType.ENGINEER, obs);
//        MESSENGER = new PawnComponent(AdventurerType.MESSENGER, obs);
//        PILOT = new PawnComponent(AdventurerType.PILOT, obs);
//        NAVIGATOR = new PawnComponent(AdventurerType.NAVIGATOR, obs);
//    }
//
//
//    /**
//     * @author nihil
//     *
//     */
//    public static PawnComponent getPawn(AdventurerType adv) {
//        switch (adv) {
//            case DIVER:
//                return DIVER;
//            case ENGINEER:
//                return ENGINEER;
//
//            case EXPLORER:
//                return EXPLORER;
//
//            case MESSENGER:
//                return MESSENGER;
//
//            case NAVIGATOR:
//                return NAVIGATOR;
//
//            case PILOT:
//                return PILOT;
//
//            default:
//                return null;
//        }// end switch
//    }
}
