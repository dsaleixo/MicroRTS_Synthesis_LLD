#!/bin/bash
#SBATCH --time=00-00:05      # time (DD-HH:MM)
for i in {0..2}
do
	for j in 3
	do
		for rep in {15..17}
		do
							
				sbatch --output=r3/out_${i}_${j}_${rep}.txt --export=i=${i},j=${j},rep=${rep} run_gp.sh
			
		done
	done
done
