import java.util.ArrayList;
import java.util.Arrays;

public class StructuralTestingTool
{
    int vertices;
    int edges;
    int rows;
    int maxEdges;
    int[][] graph;
    Integer[][] adjacentSets;
    int adjSetsLength;
    String[] paths;

    public StructuralTestingTool()
    {

    }

    public StructuralTestingTool(int vertices, int edges, int [][] graph)
    {
        this.edges = edges;
        this.vertices = vertices;
        this.graph = graph;
        this.rows = vertices;
        setMaxEdges();
        adjacentSets = new Integer[vertices * maxEdges][];
        paths = getPathVariables();
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

    public void independentPaths(int i, Boolean[] visited)
    {
        int prevIteration,
                remainingEdges = edges,
                tests = getNumTests() - 1;

        for (int edge = 0; edge < graph[i].length; edge++)
        {
            if (!visited[i])
            {
                adjacentSets[adjSetsLength] = new Integer[]{i, graph[i][edge]};
                adjSetsLength++;

                if (i == 0)
                {
                    paths[tests] = Integer.toString(i) + " -> " + graph[i][edge];
                    tests--;
                }
                else
                {
                    boolean found = false;
                    for (Integer[] arr : adjacentSets)
                    {
                        if(arr != null)
                        {
                            for (Integer arrVal : arr)
                            {
                                if (arrVal.equals(i) && paths[tests].contains(Integer.toString(i)))
                                {
                                    if (paths[tests].contains(Integer.toString(graph[i][edge])))
                                    {
                                        if (paths[tests - 1].contains(Integer.toString(i)))
                                        {
                                            break;
                                        }
                                    }
                                    else
                                    {
                                        paths[tests] += " -> " + graph[i][edge];
                                        found = true;
                                        break;
                                    }
                                }
                                else if (arrVal.equals(i) && paths[tests - 1].contains(Integer.toString(i)))
                                {
                                    paths[tests - 1] += " -> " + graph[i][edge];
                                    found = true;
                                    break;
                                }
                            }
                        }
                        if (found)
                        {
                            break;
                        }
                    }
                }
            }
        }
        visited[i] = true;
/*
        for (int r = 0; r < this.rows; r++)
        {
            prevIteration = r;
            for (int c = 0; c < graph[r].length; c++)
            {
                if (remainingEdges > 0 && tests < getNumTests()) //Find all vertices adjacent to first vertex
                {
                    if (r == 0)
                    {
                        paths[tests] = r + " -> " + graph[r][c];
                        tests++;
                        remainingEdges--;
                    } else
                    {
                        prevIteration--;
                        for (int i = 0; i < graph[prevIteration].length; i++)
                        {
                            //Find a consecutive path connecting all vertices from origin to terminal vertex.
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

            //Find all other paths
            int index = 0;
            for (String component : paths)
            {
                for (int[] components : graph)
                {
                    for (int values : components)
                    {
                        if (tests >= getNumTests())
                        {
                            tests--;
                        }
                        if (component != null && !component.contains(index + " -> " + Integer.toString(values)))
                        {
                            if (index < this.rows - 1)
                            {
                                paths[tests] = index + " -> " + values;

                                if ()
                            }
                            else
                                break;
                        }
                    }
                    index++;
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
    }

    public void visited(int i, Boolean[] visited)
    {
        for (int index = 0; index < visited.length; index++)
        {
            visited[index] = false;
        }
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

    public void setMaxEdges()
    {
        for (int rows = 0; rows < this.rows; rows++)
        {
            for (int edges = 0; edges < graph[rows].length; edges++)
            {
                if (rows == 0)
                {
                    maxEdges = graph[rows].length;
                }

                if (maxEdges < graph[rows].length)
                {
                    maxEdges = graph[rows].length;
                }
            }
        }
    }


}
