public class RabbitPopulation extends MiniJava {
    public static void main(String[] args){
        int months = readInt("Please insert a number:");
        int old_gen1, gen1 = 1, gen2 = 0, gen3 = 0, tmp = 1;

        while(tmp < 3 && tmp != months){
            gen3 = gen2;
            gen2 = gen1;
            gen1 = gen2 + gen3;
            tmp++;
        }

        while(tmp >=3 && tmp != months){
            old_gen1 = gen1;
            gen1 += gen2 + gen3;
            gen3 = gen2;
            gen2 = old_gen1;
            tmp++;
        }

        write(gen1 + gen2 + gen3);
    }
}