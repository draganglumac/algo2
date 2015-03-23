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
  long weight;
  long length;
} job_t;

int load_jobs(char *file_path, __out__ job_t **jobs);
int diff_cmp(const void *j1, const void *j2);
int ratio_cmp(const void *j1, const void *j2);

#endif // __JOB_H__
