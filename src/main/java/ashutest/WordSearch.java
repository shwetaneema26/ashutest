import java.util.Arrays;
import java.util.stream.IntStream;

public class WordSearch{
    public static void main(String []args){
        final char[][] matrix = {
                {'X', 'H', 'A', 'T'},
                {'X', 'E', 'X', 'X'},
                {'X', 'L', 'X', 'O'},
                {'X', 'L', 'X', 'W'},
                {'C', 'O', 'O', 'L'}
        };

        previewMatrix(matrix);

        String[] searchSequences = {"COOL", "HAT", "HELLO", "OWL", "WORLD"};

        for (String searchSequence : searchSequences) {
            boolean isWordFound = searchWord(searchSequence, matrix);

            if (isWordFound) {
                System.out.printf("[ PASS ] The character sequence %s has been found in the matrix.\n", searchSequence);
            } else {
                System.out.printf("[ FAIL ] The character sequence %s was not found in the matrix.\n", searchSequence);
            }
        }
    }

    private static boolean searchWord(String searchSequence, char[][] matrix) {
        boolean isWordFound = false;
        String rowString = null;

        for (char[] row : matrix) {
            rowString = new String(row);

            if (rowString.contains(searchSequence)) {
                isWordFound = true;
                break;
            }
        }

        if (!isWordFound) {
            int columnsCount = matrix[0].length;
            String colString = null;

            for (int colIndex=0; colIndex < columnsCount; colIndex++) {
                colString = getColumnContent(matrix, colIndex);
                if (colString.contains(searchSequence)) {
                    isWordFound = true;
                    break;
                }
            }
        }

        return isWordFound;
    }

    private static void previewMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char ch : row) {
                System.out.print(ch + " ");
            }

            System.out.println();
        }

        System.out.println();
    }

    private static String getColumnContent(char[][] matrix, int columnIndex) {
        return IntStream
                .range(0, matrix.length)
                .mapToObj(i -> (char) matrix[i][columnIndex])
                .collect(
                        StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
    }
}
