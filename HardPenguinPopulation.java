public class HardPenguinPopulation extends MiniJava{
    public static void main(String[] args){
        int steps = readInt("Please insert the number of time steps (>= 1):");
        if (steps < 1) {
            write("number of steps >= 1 required");
        } else {
            int youth = readInt("Initial number of young:");
            int young_adults = readInt("Initial number of young adults:");
            int adults = readInt("Initial number of adults");
            int old_adults = readInt("Initial number of old adults");
            int elders = readInt("Initial number of elders");
            int food_supply = 0;
            int temp_youth, temp_young_adults, temp_adults, temp_old_adults;

            if (youth < 0 || young_adults < 0 || adults < 0 || old_adults < 0 || elders < 0) {
                write("Negative numbers are not accepted");
            } else {
                while (steps != 0 && (youth + young_adults + adults + old_adults + elders) > 0) {
                    food_supply = (3 * young_adults) + (2 * adults);
                    if (food_supply < (youth + young_adults + adults + old_adults + elders)) {
                        int starvers = (youth + young_adults + adults + old_adults + elders) - food_supply;
                        if (starvers < elders) {
                            elders -= starvers;
                        } else if (starvers < (elders + old_adults)) {
                            old_adults -= (starvers - elders);
                            elders = 0;
                        } else if (starvers < (elders + old_adults + adults)) {
                            adults -= (starvers - elders - old_adults);
                            old_adults = 0;
                            elders = 0;
                        } else if (starvers < (young_adults + adults + old_adults + elders)) {
                            young_adults -= (starvers - elders - old_adults - adults);
                            elders = 0;
                            old_adults = 0;
                            adults = 0;
                        } else if (starvers < ((youth + young_adults + adults + old_adults + elders))) {
                            youth -= (starvers - elders - old_adults - adults - young_adults);
                            elders = 0;
                            old_adults = 0;
                            adults = 0;
                            young_adults = 0;
                        } else {
                            elders = 0;
                            old_adults = 0;
                            adults = 0;
                            young_adults = 0;
                            youth = 0;
                        }
                    }

                    temp_youth = youth;
                    temp_young_adults = young_adults;
                    temp_adults = adults;
                    temp_old_adults = old_adults;

                    youth = young_adults / 4 + adults / 2 + old_adults / 3;
                    young_adults = temp_youth;
                    adults = temp_young_adults;
                    old_adults = temp_adults;
                    elders = temp_old_adults;

                    steps--;
                }
                write("Final number of youth:" + youth);
                write("Final number of young adults:" + young_adults);
                write("Final number of adults:" + adults);
                write("Final number of old adults:" + old_adults);
                write("Final number of elders:" + elders);
            }
        }
    }
}