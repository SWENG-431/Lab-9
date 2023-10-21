import java.util.ArrayList;

public class StructuralTestingTool
{
    int vertices;
    int edges;
    int rows;
    int[][] graph;

    public StructuralTestingTool()
    {

    }

    public StructuralTestingTool(int vertices, int edges, int [][] graph)
    {
        this.edges = edges;
        this.vertices = vertices;
        this.graph = graph;
        this.rows = vertices;
    }

    public int getNumTests()
    {
        return (edges - vertices + 2);
    }

    public String[] getPathVariables()
    {
        String[] paths = new String[getNumTests()];
        return paths;
    }

    public void independentPaths()
    {
        int prevIteration,
                remainingEdges = edges;

        String[] paths = getPathVariables();

        for (int r = 0; r < this.rows; r++)
        {
            prevIteration = r;
            for (int c = 0; c < graph[r].length; c++)
            {
                if (remainingEdges > 0)
                {
                    if (r == 0)
                    {
                        paths[r + c] = r + " -> " + graph[r][c];
                        remainingEdges--;
                    }
                    else    //Find a consecutive path connecting all vertices from 0 to last.
                    {
                        prevIteration--;
                        for (int i = 0; i < graph[prevIteration].length; i++)
                        {
                            if (graph[r][c] == graph[prevIteration][i] + 1 && r < this.rows - 1)
                            {
                                if (!paths[0].contains(Integer.toString(graph[r][c])))
                                {
                                    paths[0] += " -> " + graph[r][c];
                                    remainingEdges--;
                                }
                            }
                        }
                        prevIteration++;
                    }
                }
            }
        }
        /*
        {
            if (graph[r][c] == graph[prevIteration][i])
                            {
                                if (r > 1 && graph[prevIteration][i] == graph[prevIteration - 1][i] + 1)
                                {
                                    paths[prevIteration - 1] += " -> " + graph[r][c];
                                }
                                else
                                {
                                    paths[prevIteration] += " -> " + graph[r][c];
                                }
                                remainingEdges--;
                            }
        }

        */

        System.out.println("******************************* ");
        System.out.println("-**Independent testing paths**- ");
        for(String s : paths)
        {
            System.out.println(s);
        }
        System.out.println("\n******************************* ");
    }

}
