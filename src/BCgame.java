import java.util.Scanner;


public class BCgame
{
    public static void main(String[] args)
    {
        var loader = new File();
        int try_num = loader.read_steps_No();
        var bulls = new Bull();
        var cows = new Cow();
        int number = loader.check_number();
        if (number == 0)
        {
            number = (int) ((Math.random() * ((9999 - 1000) + 1)) + 1000);
            loader.write_file("Загадано число: " + number);
        }
        String targetStr = number + "";
        Scanner input = new Scanner(System.in);
        System.out.print("Угадай число: " + number + "\n");
        do
        {
            int guess = input.nextInt();
            String guessStr = guess + "";
            try_num++;
            for(int i = 0; i < 4; i++)
            {
                if(guessStr.charAt(i) == targetStr.charAt(i))
                {
                    bulls.animal_counter++;
                }
                else if(targetStr.contains(guessStr.charAt(i) + ""))
                {
                    cows.animal_counter++;
                }
            }
            if(bulls.animal_counter != 4)
            {
                System.out.println(cows.animal_counter + " " + cows.get_number_animals() + " и " + bulls.animal_counter + " " + bulls.get_number_animals() + ".");
                loader.write_file("Шаг " + try_num  + ": " + cows.animal_counter + " " + cows.get_number_animals() + " " + bulls.animal_counter + " " + bulls.get_number_animals() + ".");
                bulls.reset_animal_counter();
                cows.reset_animal_counter();
            }
        }while(bulls.animal_counter != 4);
        if(try_num == 1)
        {
            System.out.println("Вы выйграли за " + try_num + " шаг!");
            loader.write_file("Вы выйграли за " + try_num + " шаг!");
        }
        else if(try_num < 5)
        {
            System.out.println("Вы выйграли за " + try_num + " шага!");
            loader.write_file("Вы выйграли за " + try_num + " шага!");
        }
        else
        {
            System.out.println("Вы выйграли за " + try_num + " шагов!");
            loader.write_file("Вы выйграли за " + try_num + " шагов!");
        }
        loader.write_file("end game");
    }
}

