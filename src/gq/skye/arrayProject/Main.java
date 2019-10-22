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
     * Main Method
     * @param args Terminal arguments (Not used)
     */

    public static void main(String[] args) {
        menu();
    }

    static void topbar() {
        System.out.println();
        System.out.println("Elections Canada");
        System.out.println("Official Super Ultra Extra Secure E-Voting System");
        System.out.println("====================================================");
        System.out.println();
    }

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
     * @param vote
     */

    static void simulate(int vote) {
        int winningParty;

        int ridings = 338;

        int voterTurnout = (int) (Math.random() * 60)+20;

        for (int i = 0; i < ridings; i++) {
            
        }

        System.out.println(voterTurnout);

        topbar();
        System.out.println("Running an election...");
        System.out.println("The " + partiesNameLong[5] + " has won!");
    }
}