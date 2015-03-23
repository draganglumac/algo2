/*
 * =====================================================================================
 *
 *       Filename:  job.h
 *
 *    Description:  Representation of a job
 *
 *        Version:  1.0
 *        Created:  23/03/2015 19:32:23
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  Dragan Glumac (DG), 
 *   Organization:  
 *
 * =====================================================================================
 */

#ifndef __JOB_H__
#define __JOB_H__

#define __out__

typedef struct {
  int weight;
  int length;
} job_t;

int load_jobs(char *file_path, __out__ job_t **jobs);
int compare_diff_scores(job_t *j1, job_t *j2);
int compare_ratio_scores(job_t *j1, job_t *j2);

#endif // __JOB_H__
