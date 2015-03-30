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

#include <vector>
#include <map>
#include <string>

namespace graph {

struct node {
  std::string name;
  int index;

  node(const std::string &name, int index);
  node(const node &n);
  ~node();
};

struct edge {
  int n1_index;
  int n2_index;
  int cost;

  edge(int n1, int n2, int cost);
  edge(const edge &e);
  ~edge();
};

class graph {
  private:
    map<const std::string&, int index> node_indices;
    int num_nodes;
    int next_index;
    vector<vector<edge *> > adj_list;

  public:
    graph(int num_nodes);
    ~graph();

    int index_for_node_name(const std::string &node_name);
    void add_edge(edge *e);
    void load_graph_from_file(const std::string file_path);
};

#endif // __GRAPH_H__
