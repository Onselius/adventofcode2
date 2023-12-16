#! /bin/bash

year=$1

function setup_folders {
    for i in {01..25}; do
        base_path="$year/day$i/" 
        mkdir --parents "$base_path"
        solution_file="solution.py"
        test_file="test_solution.py"
        cp $solution_file "$base_path/day$i.py"
        cp $test_file "$base_path/test_day$i.py"
        sed -i "s/solution/day$i/g" "$base_path/test_day$i.py"
    done
}


setup_folders