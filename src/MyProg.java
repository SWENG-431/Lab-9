import java.util.ArrayList;

public class MyProg
{
    public static void main(String[] args)
    {
        int [][]values = {{1,2},{2,3},{3,-1},{4,-1}};
        StructuralTestingTool graph = new StructuralTestingTool(4, 5, values);
        System.out.println("\nTotal number of tests = " + graph.getNumTests());
        graph.independentPaths();
    }
}
