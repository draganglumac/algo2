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
  int number;
} node;

typedef struct {
  node *n1;
  node *n2;
  int cost;
} edge;

typedef struct {
  edge **adj_list;
} graph;

graph *graph_create(int num_nodes, int num_edges);
void graph_destroy(graph **g);

#endif // __GRAPH_H__
