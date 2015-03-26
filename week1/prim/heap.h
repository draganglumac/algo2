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

class heap {
  private:
    void **ordered;
    key_compare kc;
  
  public:
    heap();
    heap(key_compare kc);
    ~heap();

    void set_key_compare_function(key_compare kc);
    void heapify(void **unordered);
    void insert(void *item);
    void remove(void *item);
    void *extract_min();
};

#endif // __HEAP_H__
