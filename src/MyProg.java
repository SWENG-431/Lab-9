import java.util.ArrayList;

public class MyProg
{
    public static void main(String[] args)
    {
        int [][]values = {{1, 2}, {2, 3}, {3}, {}};
        StructuralTestingTool graph = new StructuralTestingTool(4, 5, values);
        System.out.println("\nTotal number of tests = " + graph.getNumTests());
        graph.visited(0, new Boolean[4]);
    }
}
