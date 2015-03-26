/*
 * =====================================================================================
 *
 *       Filename:  heap.c
 *
 *    Description:  
 *
 *        Version:  1.0
 *        Created:  25/03/2015 08:02:01
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  Dragan Glumac (DG), 
 *   Organization:  
 *
 * =====================================================================================
 */
#include <stdlib.h>
#include "heap.h"

heap* heap_create(key_compare kc) {
  heap *temp = calloc(1, sizeof(heap));
  temp->kc = kc;
  return temp;
}

void heap_destroy(heap **h) {
  // STUB
}
void heap_heapify(heap *h, void **unordered) {
  // STUB
}
void heap_insert(heap *h, void *item) {
  // STUB
}
void heap_delete(heap *h, void *item) {
  // STUB
}
void *heap_extract_min(heap *h) {
  // STUB
  return NULL;
}


