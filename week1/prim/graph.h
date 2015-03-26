/*
 * =====================================================================================
 *
 *       Filename:  graph.h
 *
 *    Description:  Graph representation for Prim's MST algorithm.
 *
 *        Version:  1.0
 *        Created:  25/03/2015 08:04:27
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  Dragan Glumac (DG), 
 *   Organization:  
 *
 * =====================================================================================
 */

#ifndef __GRAPH_H__
#define __GRAPH_H__

struct node {
  std::string name;
  int index;

  node(std::string name, int index);
  ~node();
};

struct edge {
  node *n1;
  node *n2;
  int cost;
  edge *next;

  edge(node *n1, node *n2, int cost);
  ~edge();
};

struct edges {
  edge *head;
  edge *tail;

  edges(); 
  edges(edge *first, edge *last);
  ~edges();
};

class graph {
  private:
    int num_nodes;
    edges *adj_list;

  public:
    graph(int num_nodes);
    ~graph();

    void add_edge(edge *e);
    void load_graph_from_file(const std::string file_path);
};

#endif // __GRAPH_H__
