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
  int num_jobs;

  num_jobs = load_jobs("jobs.txt", &jobs);

  return 0;
}
