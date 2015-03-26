/*
 * =====================================================================================
 *
 *       Filename:  graph.c
 *
 *    Description:  Graph implementation.
 *
 *        Version:  1.0
 *        Created:  25/03/2015 08:15:18
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  Dragan Glumac (DG), 
 *   Organization:  
 *
 * =====================================================================================
 */
#include <string>
#include <fstream>
#include "graph.h"

using namespace std;

node::node(string name, int index)
{
  this->name = name;
  this->index = index;
}
node::~node() {} // do nothing

edge::edge(node *n1, node *n2, int cost)
{
  this->n1 = n1;
  this->n2 = n2;
  this->cost = cost;
  this->next = NULL;
}
edge::~edge() {} // do nothing
edges::edges()
{
  this->head = NULL;
  this->tail = NULL;
}
edges::edges(edge *first, edge *last)
{
  this->head = first;
  this->tail = last;
}
edges::~edges() {} // do nothing

graph::graph(int num_nodes)
{
  this->num_nodes = num_nodes;
  this->adj_list = new edges[num_nodes]; 
}
graph::~graph()
{
  for(int i = 0; i < num_nodes; i++) {
    while (adj_list[i].head != NULL) {
      edge *temp = adj_list[i].head;
      adj_list[i].head = temp->next;
      delete temp;
    }
  } 
  delete adj_list;
}
void graph::add_edge(edge *e) {
  // STUB
}
void load_graph_from_file(const string file_path)
{
  // STUB
}
