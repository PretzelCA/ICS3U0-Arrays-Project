package gq.skye.arrayProject;

import java.util.Scanner;

/**
 * Main Class
 */

public class Main {

    /**
     * Short name of parties
     */

    static String[] partiesNameShort = {"Liberal", "Conservative", "NDP", "Green Party", "Bloc Québécois", "Communist"};

    /**
     * Long name of parties
     */

    static String[] partiesNameLong = {"Liberal Party of Canada", "Conservative Party of Canada", "New Democratic Party", "Green Party of Canada", "Bloc Québécois", "Communist Party of Canada"};

    /**
     * List of random names
     */

    static String[] randomNames = {"Emilis","Mcarthur", "Eesa","Singh", "Rick","Mercado", "Rhea","Moran", "Gurpreet","Le", "Emre","Burt", "Milton","Robles", "Ellen","Stephenson", "Rheanna","Horn", "Rayhaan","Duncan", "Lachlan","Lennon", "Efa","Kline", "Chance","Fischer", "Finley","Mcnally", "Emile","Dixon", "Franky","Bond", "Hannah","Fletcher", "Jeanette","Curry", "Misbah","Mcghee", "Bonnie","Patterson", "Mujtaba","Estes", "Ihsan","Fenton", "Siddharth","Wilks", "Hugo","Stein", "Joann","Baxter", "Zaine","Reynolds", "Daniyal","Sims", "Kynan","Pritchard", "Melanie","Bourne", "Chelsy","Crane", "Harri","Irvine", "Rianne","Prince", "Kellie","Burn", "Indiana","Blackburn", "Donte","Melendez", "Lorcan","Welch", "Frances","Hansen", "Jules","Owen", "Andre","O'Connor", "Harley","Curtis", "Tyler-James","Walter", "Filip","Ellwood", "Hashir","Ross", "Romany","Williams", "Taliyah","Davie", "Vikram","Haigh", "Darla","Allan", "Ralphy","Hayes", "Isobelle","Gallagher", "Jad","Irving", "Imaan","Khan", "Ewan","Greer", "Vijay","Tanner", "Trystan","Ray", "Shaquille","Timms", "Montana","Paul", "Yisroel","Alston", "Leticia","Moyer", "Ismaeel","Marsden", "Jaheim","Booker", "Jagdeep","Ware", "Shyam","Cooper", "Samera","Mann", "Robyn","Robertson", "Lexi-May","Logan", "Leigh","Mitchell", "Lillie-Mai","Duggan", "Fynn","Carter", "Maurice","Leon", "Beatrix","Esparza", "Isabelle","Summers", "Cristian","Ahmad", "Missy","Fountain", "Alexander","Franklin", "Kylo","Deleon", "Cassia","Villanueva", "Hamish","Currie", "Chelsey","Conley", "Adem","Baldwin", "Haiden","Villarreal", "Madison","Charles", "Persephone","Wickens", "Eamon","Guest", "Rianna","Harrington", "Ava-Grace","Flower", "Kaycee","Vance", "Cameron","Bradshaw", "Myron","Robson", "Kirstin","Salgado", "Jocelyn","Meyers", "Cherie","Phillips", "Keir","Milne", "Teri","Avalos", "Amna","Hutchings", "Benedict","Rayner", "Fatimah","Cox", "Bruce","Pierce", "Yvie","Lin", "Catherine","Sargent", "Najma","Fitzgerald"};

    /**
     * Party votes amount
     */

    static int[] votesForParty = {0,0,0,0,0,0};

    /**
     * Seats Amount
     */

    static int[] partiesSeats = {0,0,0,0,0,0};

    /**
     * Main Method
     * @param args Terminal arguments (Not used)
     */

    public static void main(String[] args) {
        menu();
    }

    /**
     * Prints the topbar
     */

    static void topbar() {
        System.out.println();
        System.out.println("Elections Canada");
        System.out.println("Official Super Ultra Extra Secure E-Voting System");
        System.out.println("====================================================");
        System.out.println();
    }

    /**
     * Prints the menu
     */

    static void menu() {
        topbar();
        Scanner input = new Scanner(System.in);

        System.out.println("1. Vote");
        System.out.println("2. Don't Vote");
        System.out.println();
        System.out.println("3. Quit");

        System.out.print("> ");

        String option = input.nextLine();

        if (option.equals("1")) {
            simulate(vote());
        } else if (option.equals("2")) {
            simulate(0);
        } else if (option.equals("3")) {
            System.exit(0);
        } else {
            menu();
        }
    }

    /**
     * Votes for a party
     * @return The vote in int
     */

    static int vote() {
        Scanner input = new Scanner(System.in);

        System.out.println();
        System.out.println("Pick a party:");
        System.out.println();

        for (int i = 0; i < partiesNameShort.length; i++) {
            System.out.println((i + 1) + ". " + partiesNameShort[i]);
        }

        System.out.println();
        System.out.print("Enter Vote > ");

        return Integer.parseInt(input.nextLine());
    }

    /**
     * Simulates an election
     * @param vote User's vote
     */

    static void simulate(int vote) {
        System.out.println("Running an election...");

        String statusOfGov;

        int winningParty = 0;

        int ridings = 338;

        for (int i = 0; i < ridings; i++) {
            int ridingPartyWin;
            int voterTurnout = (int) (Math.random() * 60)+20;
            int population = ((int) (Math.random() * 100000)+1000);
            int voterPopulation = (int) (population - ((double) voterTurnout/100 * population));
            String mpName = randomNames[(int) (Math.random() * randomNames.length)] + " " + randomNames[(int) (Math.random() * randomNames.length)];
            ridingPartyWin = (int) (Math.random() * votesForParty.length);
            votesForParty[ridingPartyWin] = voterPopulation;
            partiesSeats[ridingPartyWin]++;
            System.out.println(mpName + " of The " + partiesNameLong[ridingPartyWin] + " has won riding " + (i + 1));
        }

        for (int i = 0; i < partiesSeats.length; i++) {
            if (partiesSeats[i] > partiesSeats[winningParty]) {
                winningParty = i;
            }
        }

        if (partiesSeats[winningParty] >= 170) {
            statusOfGov = "majority";
        } else {
            statusOfGov = "minority";
        }

        topbar();
        System.out.println("The " + partiesNameLong[winningParty] + " has won a " + statusOfGov + " government with a total of " + votesForParty[winningParty] + " votes!");
        System.out.println("They have claimed " + partiesSeats[winningParty] + " seats!");
    }
}