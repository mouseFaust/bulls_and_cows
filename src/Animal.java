public class Animal {
    protected String null_number;
    protected String one_number;
    protected String many_number;

    int animal_counter = 0;
    void reset_animal_counter()
    {
        animal_counter = 0;
    }

    String get_number_animals()
    {
        if(animal_counter == 0)
        {
            return null_number;
        }
        else if(animal_counter == 1)
        {
            return one_number;
        }
        else
        {
            return many_number;
        }
    }
}

