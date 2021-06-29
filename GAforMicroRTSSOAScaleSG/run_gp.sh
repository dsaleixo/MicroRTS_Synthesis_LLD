#!/bin/bash
#SBATCH --time=2-10:00      # time (DD-HH:MM)
#SBATCH --cpus-per-task=3
#SBATCH --mem-per-cpu=5G 
#SBATCH --output=%N-%j.txt  # %N for node name, %j for jobID


source jep_teste/env/bin/activate


module load java/1.8.0_192

java -jar tc.jar  ${i} ${j} ${rep} 

echo 'FIM'




