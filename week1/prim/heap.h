/*
 * =====================================================================================
 *
 *       Filename:  heap.h
 *
 *    Description:  Heap specification for speeding up Prim's MST algorithm
 *
 *        Version:  1.0
 *        Created:  25/03/2015 07:54:12
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  Dragan Glumac (DG), 
 *   Organization:  
 *
 * =====================================================================================
 */

#ifndef __HEAP_H__
#define __HEAP_H__

// Key comparison function. Takes two data items, whatever they may be
// and returns 0 if they're equal, < 0 if first comes before second,
// and > 0 if first comes after the second.
typedef int (*key_compare)(void *, void *);

typedef struct {
  void **ordered;
  key_compare kc;
} heap;

heap *heap_create(key_compare kc);
void heap_destroy(heap **h);
void heap_heapify(heap *h, void **unordered);
void heap_insert(heap *h, void *item);
void heap_delete(heap *h, void *item);
void *heap_extract_min(heap *h);

#endif // __HEAP_H__
