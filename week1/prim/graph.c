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
#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "graph.h"

node *node_create(char *name, int index)
{
  node *temp = calloc(1, sizeof(node));
  temp->name = calloc(strlen(name) + 1, sizeof(char));
  strncpy(temp->name, name, strlen(name));
  temp->index = index;
  return temp;
}
void node_destroy(node **nn)
{
  node *n = *nn;
  free(n->name);
  free(n);
  *nn = NULL;
}
edge *edge_create(node *n1, node *n2, int cost)
{
  edge *temp = calloc(1, sizeof(edge));
  temp->n1 = n1;
  temp->n2 = n2;
  temp->cost = cost;
  return temp;
}
void edge_destroy(edge **ee)
{
  edge *e = *ee;
  node_destroy(&e->n1);
  node_destroy(&e->n2);
  free(e);
  *ee = NULL;
}
graph *graph_allocate(int num_nodes)
{
  graph *g = calloc(1, sizeof(graph));
  g->adj_list = calloc(num_nodes, sizeof(edges *));
  return g;
}
void add_edge(graph *g, edge *e)
{
  edges *es = g->adj_list[e->n1->index];
  if (es->head == NULL) {
    es->head = e;
    es->tail = e;
  }
  else {
    es->tail->next = e;
    es->tail = e;
  }
}
graph *load_graph_from_file(const char *file_path)
{
  FILE *f = fopen(file_path, "r");
  if (f == NULL) {
    perror("fopen");
  }
  int nodes, edges;
  fscanf(f, "%d %d", nodes, edges);
  node *ns = calloc(nodes, sizeof(node));
  int next_index=0;
  graph *g = graph_allocate(nodes);
  while (EOF != fscanf(f, "%s %s %d", n1, n2, cost)) {
    node *v1 = node_create(
  }
  int n1, n2, cost;
  return NULL;
}
graph *graph_create(int num_nodes, int num_edges)
{
  // STUB
  return NULL;
}
void grap_destroy(graph **g)
{
  // STUB
}

