/**
 * Class MyProg.
 * Driver program.
 * Initializes a DD path graph and
 * calls the StructuralTestingTool
 * visited method to begin depth
 * first traversal.
 *
 * @author Brian Karimi, Katie Killian, Nicole Vadillo
 */
public class MyProg
{
    /**
     * Function main begins with program execution
     * @param args - command line arguments
     */
    public static void main(String[] args)
    {
        int vertices = 4,
                edges = 5;

        //DD Path graph
        int [][]values = {{1, 2}, {2, 3}, {3}, {}};

        StructuralTestingTool graph = new StructuralTestingTool(vertices, edges, values);
        System.out.println("\nTotal number of tests = " + graph.getNumTests());
        graph.visited(0, new Boolean[vertices - 1]);
    }
}
