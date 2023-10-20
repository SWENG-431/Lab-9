import java.util.ArrayList;

public class StructuralTestingTool
{
    int vertices;
    int edges;
    int rows;
    int[][] graph;

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

    public void setColumns()
    {

    }

    public void independentPaths()
    {
        int vertex = 2;
        String consecutivePath = null, otherPath = null;

        //Find a consecutive path connecting all vertices from 0 to last.
        for (int r = 0; r < this.rows; r++)
        {
            for (int c = 0; c < graph[r].length; c++)
            {
                if (graph[r][c] == (r+1))
                {
                    if (r == 0 && c == 0)
                    {
                        consecutivePath = Integer.toString(r) + " -> " + Integer.toString((r+1));
                    }
                    else if (r < this.rows - 1)
                    {
                        consecutivePath += " -> " + Integer.toString((r+1));
                    }
                }
            }
        }

        for (int r = 0; r < this.rows; r++)
        {
            for (int c = 0; c < graph[r].length; c++)
            {
                if (graph[r][c] == vertex && r < this.rows - 1)
                {
                    if (r == 0)
                    {
                        otherPath = Integer.toString(r) + " -> " + Integer.toString(graph[r][c]);
                    }
                    else
                    {

                    }
                    vertex++;
                }
            }
            vertex = 2;
        }



        System.out.println("******************************* ");
        System.out.println("-**Independent testing paths**- ");
        System.out.println(consecutivePath);
        System.out.println(otherPath);
        System.out.println("\n******************************* ");
    }

}
