/*
 * =====================================================================================
 *
 *       Filename:  job.c
 *
 *    Description: Job representation - implementation 
 *
 *        Version:  1.0
 *        Created:  23/03/2015 19:37:52
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

int load_jobs(char *file_path, __out__ job_t **jobs) {
  FILE *f = fopen(file_path, "r");
  if (f == NULL) {
    perror("fopen");
  }

  int num_jobs, i, weight, length;
  
  fscanf(f, "%d", &num_jobs);
  *jobs = calloc(num_jobs, sizeof(job_t));
  for (i = 0; i < num_jobs; i++) {
    fscanf(f, "%d %d", &weight, &length);
    (*jobs)[i].weight = weight;
    (*jobs)[i].length = length;
  }
  
  fclose(f);
  return num_jobs;
}
int diff_cmp(job_t *j1, job_t *j2) {
  return (j1->weight - j1->length) - (j2->weight - j2->length);
}
int ratio_cmp(job_t *j1, job_t *j2) {
  return (j1->weight * j2->length) - (j2->weight * j1->length);
}
