# ICS3U0 Arrays Project

This project is a very loose simulation of a Canadian federal election written in Java.

You can either choose to vote or just watch the simulation of the election.

All 338 ridings are present and most of the parties are listed and voteable.
Although the following variables are randomized:
* The voter turnout
* The populationm per riding
* MP names

This is done by creating a 338 long matrix with the first slot for the name and the second slot for the votes. The program then goes through each riding, prints the name, generates the population and voter turnout, and then will randomize the votes for each party, making sure the total votes is equal to the voter turnout.