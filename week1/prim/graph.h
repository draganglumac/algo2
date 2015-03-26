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

typedef struct {
  char *name;
  int index;
} node;

typedef struct _edge {
  node *n1;
  node *n2;
  int cost;
  struct _edge *next;
} edge;

typedef struct {
  edge *head;
  edge *tail;
} edges;

typedef struct {
  edges **adj_list;
} graph;

node *node_create(char *name, int index);
void node_destroy(node **nn);
edge *edge_create(node *n1, node *n2, int cost);
void edge_destroy(edge **ee);
graph *graph_allocate(int num_nodes);
void add_edge(graph *g, edge *e);
graph *load_graph_from_file(const char *file_path);
void graph_destroy(graph **g);

#endif // __GRAPH_H__
