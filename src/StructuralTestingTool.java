import java.util.Arrays;

/**
 * Class StructuralTestingTool.
 * Prints the independent testing
 * paths of a given DD path graph
 * using DFT.
 *
 * @author Brian Karimi, Katie Killian, Nicole Vadillo
 */
public class StructuralTestingTool
{
    int vertices;
    int edges;
    int rows;
    int maxEdges;
    int[][] graph;
    String[] paths;

    /**
     *
     * @param vertices takes in graph vertices.
     * @param edges holds in graph edges.
     * @param graph array containing adjacent vertices
     *              to the graph index.
     */
    public StructuralTestingTool(int vertices, int edges, int [][] graph)
    {
        this.edges = edges;
        this.vertices = vertices;
        this.graph = graph;
        this.rows = vertices;
        paths = getPathVariables();
    }

    /**
     * Method that computes the
     * Cyclomatic complexity of
     * a given DD path graph.
     * @return the number of test cases
     */
    public int getNumTests()
    {
        return (edges - vertices + 2);
    }

    /**
     * Method that stores the independent
     * paths obtained from the DFT.
     * @return a string array to store
     * each path.
     */
    public String[] getPathVariables()
    {
        String[] paths = new String[getNumTests()];
        return paths;
    }

    /**
     * Method that simulates the DFT.
     * @param i is the current vertex
     *          being traversed.
     * @param visited determines whether
     *                the current vertex
     *                has already been traversed.
     */
    public void independentPaths(int i, Boolean[] visited)
    {
        int tests = getNumTests() - 1;

        for (int edge = 0; edge < graph[i].length; edge++)
        {
            if (!visited[i])
            {
                if (i == 0)
                {
                    paths[tests] = i + " -> " + graph[i][edge];
                    tests--;
                }
                else
                {
                    for (Integer arrVal : graph[i])
                    {
                        if (paths[tests].contains(Integer.toString(i)))
                        {
                            if (tests > 1)
                            {
                                if (paths[tests - 2] != null && paths[tests - 2].contains(Integer.toString(i)))
                                {
                                    paths[tests - 2] = "0 -> " + i + " -> " + graph[i][edge];
                                } else if (paths[tests - 2] == null)
                                {
                                    paths[tests - 2] = "0 -> " + i + " -> " + graph[i][edge];
                                }
                            }

                            if (!paths[tests].contains(Integer.toString(arrVal)))
                            {
                                paths[tests] += " -> " + graph[i][edge];
                            }
                            break;
                        }
                        else if (paths[tests - 1].contains(Integer.toString(i)))
                        {
                            paths[tests - 1] += " -> " + graph[i][edge];
                            break;
                        }
                    }
                }
            }
        }
        visited[i] = true;
    }

    /**
     * Method that traverses the DD path
     * graph and sets the corresponding
     * boolean variable after each traversal.
     * @param i is the current vertex being
     *          handled.
     * @param visited is the corresponding
     *                boolean variable.
     */
    public void visited(int i, Boolean[] visited)
    {
        Arrays.fill(visited, false);
        for (int index = i; index < visited.length; index++)
        {
            independentPaths(index, visited);
        }

        System.out.println("******************************* ");
        System.out.println("-**Independent testing paths**- ");
        for(String s : paths)
        {
            System.out.println(s);
        }
        System.out.println("\n******************************* ");
    }
}
