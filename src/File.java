import java.io.*;

public class File {

    private String file = "game.txt";

    int read_steps_No()
    {
        try
        {
            FileReader read = new FileReader(file);
            BufferedReader buff_read = new BufferedReader(read);
            var lines = buff_read.lines().toArray();
            var count_lines = lines.length;
            if(lines.length != 0)
            {
                count_lines--;
            }
            int result = 0;
            if(!lines[count_lines].equals("end game"))
            {
                String step = "Шаг ";
                String string = (String)lines[count_lines];
                if(string.regionMatches(0, step, 0, step.length()))
                {
                    var start = string.indexOf(" ") + 1;
                    var end = string.indexOf(":");
                    var simbols = new char[end - start];
                    string.getChars(start, end, simbols, 0);
                    String char_result = "";
                    for (var simbol : simbols)
                    {
                        char_result += simbol;
                    }
                    result = Integer.parseInt(char_result);
                }
            }
            buff_read.close();
            read.close();
            return result;
        }
        catch(IOException e)
        {
            return 0;
        }
    }
    void write_file(String write_str)
    {
        try
        {
            FileWriter write = new FileWriter(file, true);
            write.write(write_str + "\n");
            write.close();
        }
        catch(IOException e){}
    }
    int check_number()
    {
        try
        {
            FileReader read = new FileReader(file);
            BufferedReader buff_read = new BufferedReader(read);
            var lines = buff_read.lines().toArray();
            var count_lines = lines.length;
            if(lines.length != 0)
            {
                count_lines--;
            }
            int result = 0;
            if(!lines[count_lines].equals("end game"))
            {
                String number = "Загадано число";
                String string = (String)lines[count_lines];
                while(!string.regionMatches(0, number, 0, number.length()))
                {
                    count_lines--;
                    string = (String)lines[count_lines];
                }
                var start = string.lastIndexOf(" ") + 1;
                var end = string.length();
                var simbols = new char[end - start];
                string.getChars(start, end, simbols, 0);
                String char_result = "";
                for (var simbol : simbols)
                {
                    char_result += simbol;
                }
                result = Integer.parseInt(char_result);
            }
            buff_read.close();
            read.close();
            return result;
        }
        catch(IOException e)
        {
            return 0;
        }
    }
}
