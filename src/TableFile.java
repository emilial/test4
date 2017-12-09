import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class TableFile
{
    private final static String FILE_NAME = MEM.tytul_tab;
    private final static String SEPARATOR = "/";

    public synchronized static void readData(int rows, int cols, String file, String title, Object[] nagl, Object[][] values)
    {
        try
        {
            InputStream stream = new FileInputStream(FILE_NAME);
            byte[] data = new byte[stream.available()];
            stream.read(data);

            String[] separatedData = new String(data).split(SEPARATOR);
            int index = 0;
            for(int rowIndex = 0; rowIndex < rows; rowIndex++)
            {
                for(int colIndex = 0; colIndex < cols; colIndex++)
                {
                    values[rowIndex][colIndex] = separatedData[index];
                    index++;
                }
            }
        }
        catch (IOException e)
        {
        }
    }

    public synchronized static void writeData(String file, String title, Object[] nagl, Object[][] values)
    {
        int rows = values.length;
        int cols = values[0].length;

        String data = new String();
        for(int rowIndex = 0; rowIndex < rows; rowIndex++)
        {
            for(int colIndex = 0; colIndex < cols; colIndex++)
            {
                Object value = values[rowIndex][colIndex];
                data += (value == null ? "" : value);
                if(!(rowIndex == rows - 1  && colIndex == cols - 1))
                {
                    data += SEPARATOR;
                }
            }
        }

        try
        {
            OutputStream stream = new FileOutputStream(FILE_NAME);
            stream.write(data.getBytes());
            stream.flush();
            stream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
