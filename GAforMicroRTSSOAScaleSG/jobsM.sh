#!/bin/bash
#SBATCH --time=00-00:05      # time (DD-HH:MM)
for i in {1}
do
	for j in {0..1}
	do
		for rep in {0..6}
		do
							
				sbatch --output=Camp/out_${i}_${j}_${rep}.txt --export=i=${i},j=${j},rep=${rep} jobM.sh
			
		done
	done
done
