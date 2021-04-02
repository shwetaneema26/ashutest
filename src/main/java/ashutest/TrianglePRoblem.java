import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.Stream;

public class TrianglePRoblem {

    /*public static void main(String[] args) {

        String input = readTextFile();
        int[][] input2DArray = create2DArrayFromInput(input);
        int result = maxPathSum(input2DArray);

        System.out.println(result);


    }*/

    public static void main(String[] args) throws Exception {
        String fileName = "/Users/shwetaneema/IdeaProjects/Sample/src/temp.txt";

        int[][] data = Files.lines(Paths.get(fileName))
                .map(s -> Arrays.stream(s.trim().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .toArray(int[][]::new);

        for (int r = data.length - 1; r > 0; r--)
            for (int c = 0; c < data[r].length - 1; c++)
                data[r - 1][c] += Math.max(data[r][c], data[r][c + 1]);

        System.out.println(data[0][0]);
    }


    // Function for finding maximum sum
    static int maxPathSum(int tri[][])
    {
        // loop for bottom-up calculation
        for (int i = tri.length-1; i > 0; i--)
        {
            for (int j = 0; j <tri[i].length-1; j++)
            {
                tri[i - 1][j] += Math.max(tri[i][j], tri[i][j + 1]);
            }
        }

        // return the top element
        // which stores the maximum sum
        return tri[0][0];
    }



    private static int[][] create2DArrayFromInput(String inputText) {
        String[] lines = inputText.split("\n");
        int tri[][] =  new int[lines.length][];

        for (int rowId = 0; rowId < lines.length; rowId++) {
            String[] elements = lines[rowId].split(" ");
            tri[rowId] = new int[elements.length];
            for (int colId = 0; colId < elements.length; colId++) {
                try {
                    int colVal = 0;
                    if(!elements[colId].trim().isEmpty()){
                        colVal = Integer.parseInt(elements[colId]);
                    }
                    tri[rowId][colId] = colVal;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Illegal Argument '"
                            + elements[colId] + "' found in line number " + (rowId + 1)
                            + " of input allowed numbers only");
                }

            }
        }

        return tri;
    }


    private static String readTextFile(){
        // The name of the file to open.
       // /Users/shwetaneema/IdeaProjects/Sample/src/temp.txt
        String fileName = "/Users/shwetaneema/IdeaProjects/Sample/src/temp.txt";
        String line = null;

        try(BufferedReader bufferedReader =
                    new BufferedReader(new FileReader(fileName))) {

            StringBuilder builder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line).append("\n");
            }

            return builder.toString();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
        }
        return "";
    }


}
