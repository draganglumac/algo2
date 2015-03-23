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

int main(int argc, char **argv) {
  job_t *jobs;
  int num_jobs, i;

  if (argc > 1) {
    num_jobs = load_jobs(argv[1], &jobs);
  }
  else {
    num_jobs = load_jobs("tests/jobs.txt", &jobs);
  }

  qsort(jobs, num_jobs, sizeof(job_t), ratio_cmp);

  long sum = 0, ct = 0;
  for (i = num_jobs - 1; i >= 0; i--) {
    ct += jobs[i].length;
    sum += (jobs[i].weight * ct);
  }

  printf("Sum of ratios = %ld\n", sum);
  return 0;
}
