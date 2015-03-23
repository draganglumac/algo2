/*
 * =====================================================================================
 *
 *       Filename:  diffs.c
 *
 *    Description:  
 *
 *        Version:  1.0
 *        Created:  23/03/2015 19:55:03
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  Dragan Glumac (DG), 
 *   Organization:  
 *
 * =====================================================================================
 */
#include <stdlib.h>
#include <stdio.h>
#include "job.h"

#define GT(x, y) (0  < diff_cmp(x, y))
#define EQ(x, y) (0 == diff_cmp(x, y))
#define LT(x, y) (0  > diff_cmp(x, y))

int main(int argc, char **argv) {
  job_t *jobs;
  int num_jobs, i;

  num_jobs = load_jobs("jobs.txt", &jobs);

  long sum = 0, ct = 0;
  for (i = 0; i < num_jobs; i++) {
    ct += jobs[i].length;
    sum += (jobs[i].weight * ct);
  }

  printf("Sum of diffs = %ld\n", sum);
  return 0;
}
