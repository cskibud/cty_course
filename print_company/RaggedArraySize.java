package print_company;

public class RaggedArraySize {
    public static void main(String[] args) {
        int[][] triangleArray = { 
            {1,2,3,4}, 
            {1,2,3} 
        }; 
        printRaggedArraySize(triangleArray);
    }
    public static void printRaggedArraySize(int[][] raggedArray) {
        for (int i = 0; i < raggedArray.length; i++) {
            System.out.println("The length of row " + (i + 1) + " is:");
            System.out.println(raggedArray[i].length);
        }
    }
}
