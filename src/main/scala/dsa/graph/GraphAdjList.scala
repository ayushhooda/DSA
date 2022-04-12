package dsa.graph

import scala.annotation.tailrec
import scala.collection.mutable

// Adjacency Matrix :
/**
 * 1. Adjacency Matrix is a 2D array of size V x V where V = number of vertices in a graph.
 * 2. Let the 2D array be adj[][], a slot adj[i][j] = 1 indicates that there is an edge from vertex i to vertex j.
 * 3. Adjacency matrix for undirected graph is always symmetric.
 * 4. Adjacency Matrix is also used to represent weighted graphs.
 * 5. If adj[i][j] = w, then there is an edge from vertex i to vertex j with weight w.
 */

// Pros :
/**
 * 1. Representation is easier to implement and follow.
 * 2. Removing an edge takes O(1) time.
 * 3. Queries like whether there is an edge from vertex ‘u’ to vertex ‘v’ are efficient and can be done O(1).
 */

// Cons :
/**
 * 1. Consumes more space O(V^2)
 * 2. Even if the graph is sparse(contains less number of edges), it consumes the same space.
 * 3. Adding a vertex is O(V^2) time.
 */

// Adjacency list :
/**
 * 1. An array of lists is used.
 * 2. The size of the array is equal to the number of vertices.
 * 3. An entry array[i] represents the list of vertices adjacent to the ith vertex.
 * 4. This representation can also be used to represent a weighted graph.
 * 5. The weights of edges can be represented as lists of pairs(by changing the structure of list).
 */

// Graph
// 0 ---- 1
// |   /  |    2
// 4 ---- 3

// Adjacency list
// 0 -> 1 -> 4
// 1 -> 0 -> 2 -> 3 -> 4
// 2 -> 1 -> 3
// 3 -> 1 -> 2 -> 4
// 4 -> 0 -> 1 -> 3

// Pros :
/**
 * 1. Saves space O(|V|+|E|).
 * 2. In the worst case, there can be C(V, 2) number of edges in a graph thus consuming O(V^2) space.
 * 3. Adding a vertex is easier.^
 */

// Cons :
/**
 * 1. Queries like whether there is an edge from vertex u to vertex v are not efficient and can be done O(V)
 */

case class Edge(startIndex: Int, endIndex: Int)
object GraphAdjList {

  type Graph = Array[List[Int]]

  /**
   * Adds all the edges of graph to adjacency list
   * @param adjList - input adjacency list (empty initially)
   * @param listOfEdges - list of edges to be added
   * @return - adjacency list with edges added
   */
  @tailrec
  def addEdges(adjList: Array[List[Int]], listOfEdges: List[Edge]): Graph = {
    listOfEdges match {
      case head :: tail =>
        adjList(head.startIndex) = adjList(head.startIndex) :+ head.endIndex
        adjList(head.endIndex) = adjList(head.endIndex) :+ head.startIndex
        addEdges(adjList, tail)
      case Nil => adjList
    }
  }

  /**
   * Simple view of adjacency list
   * @param adjList - input adjacency list
   */
  def printAdjList(adjList: Array[List[Int]]): Unit = {
    var i = 0
    adjList.foreach { list =>
      print(s"Vertex $i : ")
      list.foreach { vertex =>
        print(s"$vertex ")
      }
      println()
      i = i + 1
    }
  }

  /**
   * Traversal of graph is tricky as it contains cycles, so one way to achieve it using BFS
   * 1. Create an array of vertex, which will keep track whether given vertex is visited or not.
   * 2. Create a queue which will be used to store visited vertex.
   * 3. Print the vertex after polling it out from the queue.
   * @param sourceVertex - source vertex from where traversal needs to start
   * @param numOfVertex - number of vertex in the graph
   */
  def bfs(sourceVertex: Int, numOfVertex: Int, adjList: Graph): Unit = {
    // Mark all the vertices as not visited (by default false)
    val visited: Array[Boolean] = new Array[Boolean](numOfVertex)

    // Create a queue for BFS
    val queue = new mutable.Queue[Int]()

    // marking source vertex as visited
    visited(sourceVertex) = true
    queue.enqueue(sourceVertex)

    while(queue.nonEmpty) {
      val vertex: Int = queue.dequeue()
      print(s"$vertex  ")
      val list: List[Int] = adjList(vertex)
      list.foreach { vertex =>
        if(!visited(vertex)) {
          visited(vertex) = true
          queue.enqueue(vertex)
        }
      }
    }
  }

  // Adjacency list
  // 0 -> 1 -> 4
  // 1 -> 0 -> 2 -> 3 -> 4
  // 2 -> 1 -> 3
  // 3 -> 1 -> 2 -> 4
  // 4 -> 0 -> 1 -> 3

  /**
   * Traversal of graph is tricky as it contains cycles, so one way to achieve it using DFS
   * 1. Create an array of vertex, which will keep track whether given vertex is visited or not.
   * 2. Create a stack which will be used to store visited vertex.
   * 3. Print the vertex after popping it out from the stack, only if corresponding visited array is false.
   * @param sourceVertex - source vertex from where traversal needs to start
   * @param numOfVertex - number of vertex in the graph
   */
  def dfs(sourceVertex: Int, numOfVertex: Int, adjList: Graph): Unit = {
    // Mark all the vertices as not visited (by default false)
    val visited: Array[Boolean] = new Array[Boolean](numOfVertex)

    // Create a stack for DFS
    val stack = new mutable.Stack[Int]()
    stack.push(sourceVertex)

    while(stack.nonEmpty) {
      val vertex = stack.pop()
      if(!visited(vertex)) {
        print(s"$vertex  ")
        visited(vertex) = true
        val list: List[Int] = adjList(vertex)
        list.foreach { adjVertex =>
          if(!visited(adjVertex)) {
            stack.push(adjVertex)
          }
        }
      }
    }
  }

  def main(args: Array[String]): Unit = {

    // creating an empty adjacency list
    val adjList = Array[List[Int]](List[Int](), List[Int](), List[Int](), List[Int](), List[Int]())

    // creating list of edges
    val listOfEdges: List[Edge] = List(Edge(0, 1), Edge(0, 4), Edge(1, 2), Edge(1, 3), Edge(1, 4), Edge(2, 3), Edge(3, 4))

    // adding edges
    val adjListWithEdges: Graph = addEdges(adjList, listOfEdges)

    println("Adjacency list: ")
    printAdjList(adjListWithEdges)

    print("\nBFS Traversal: ")
    bfs(0, 5, adjListWithEdges)
    print("\nDFS Traversal: ")
    dfs(0, 5, adjListWithEdges)
  }

}
