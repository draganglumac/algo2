all: clean diffs ratios

diffs:
	gcc -g -o d.bin diffs.c job.c

ratios:
	gcc -g -o r.bin ratios.c job.c

clean:
	-rm d.bin
	-rm r.bin
