all: clean diffs ratios

diffs:
	gcc -g -o diffs.bin diffs.c job.c

ratios:
	gcc -g -o ratios.bin ratios.c job.c

clean:
	-rm diffs.bin
	-rm ratios.bin
