package lesson24.resorce;

public class Figure {

    public static String[][] rock() {
        String[][] rock = {
                {"__________________________________________________"},
                {"__________________________11111___________________"},
                {"________________________0001_11001________________"},
                {"_________________11111101________100______________"},
                {"_______________1001_111____________10_____________"},
                {"______________10_____________________0____________"},
                {"__________11110_______________________01__________"},
                {"________001______________1_____________01_________"},
                {"_______01________________11____________001________"},
                {"____1001__________________01___________0010_______"},
                {"__101____________1_________00__________101_0______"},
                {"__0______________11_________00_________100_10_____"},
                {"__0______1________11_________001______1000__01____"},
                {"__0_______1________11________1000011000000__00____"},
                {"__10______11________10_______100000000000___00____"},
                {"___01______11________001_____0000000001____101____"},
                {"____0_______00________00001000000_________001_____"},
                {"____10_______00_______00000000000_______0001______"},
                {"_____101_____1000011000000000000001___1000________"},
                {"_______101__100000000001___11100000000001_________"},
                {"_________10000001_______________1000001___________"},
                {"__________________________________________________"}
        };
        return rock;
    }

    public static String[][] paper() {
        String[][] paper = {
                {"__________________________________________________"},
                {"__________________________________________________"},
                {"__________________________________________________"},
                {"__________________________________________________"},
                {"____0000000000000000000000000000000000000_________"},
                {"____0000000000000000000000000000000000000_________"},
                {"_____0000000000000000000000000000000000000________"},
                {"_____0000000000000000000000000000000000000________"},
                {"______0000000000000000000000000000000000000_______"},
                {"______0000000000000000000000000000000000000_______"},
                {"_______0000000000000000000000000000000000000______"},
                {"_______0000000000000000000000000000000000000______"},
                {"________0000000000000000000000000000000000000_____"},
                {"________0000000000000000000000000000000000000_____"},
                {"_________0000000000000000000000000000000000000____"},
                {"_________0000000000000000000000000000000000000____"},
                {"__________0000000000000000000000000000000000000___"},
                {"__________0000000000000000000000000000000000000___"},
                {"__________________________________________________"},
                {"__________________________________________________"},
                {"__________________________________________________"},
                {"__________________________________________________"}
        };
        return paper;
    }

    public static String[][] scissors() {
        String[][] scissors = {
                {"__________________________________________________"},
                {"__________________________________________________"},
                {"__________________________________________________"},
                {"__________________________________________________"},
                {"_________________________________111000000000001__"},
                {"________________100000000000010111____________101_"},
                {"00001________0001_______________________00000001__"},
                {"00000001110001___________________1000000__________"},
                {"00001__000__________________10111_______00000001__"},
                {"00001__00___________101_______1000111_________101_"},
                {"00001__00____________10000001____111000000000001__"},
                {"00001__00_____________001___1000000_0011111111____"},
                {"00001__00_____________101_________00______________"},
                {"00001__00____________01_10011_____101_____________"},
                {"00001__00___________10011__10000001_______________"},
                {"00001__00__________00__1000111111_________________"},
                {"00001__0001________11011__111100__________________"},
                {"000000011100000______1110000011___________________"},
                {"00001_________1000000000__________________________"},
                {"__________________________________________________"},
                {"__________________________________________________"},
                {"__________________________________________________"}
        };
        return scissors;
    }
}
