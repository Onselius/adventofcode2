#! /bin/bash

year=$1

function create_directories {
    echo "inside create_dirs"
}

function create_textfiles {
    for i in {03..25}; do
        input_path="test/resources/year$year/input/input$i.txt"
        test_path="test/resources/year$year/test/test$i.txt"
        echo "Creating $input_path"
        touch $input_path
        echo "Creating $test_path"
        touch $test_path
    done
}

function create_classfiles {
    base_path="main/java/Base.java"
    for i in {03..25}; do
        class_path="main/java/year$year/Dec$i.java"
        echo "Creating $class_path"
        cp $base_path $class_path
        sed -i "1i package year$year;\n" $class_path
        sed -i "s/Base/Dec$i/g" $class_path
    done
}

function create_testfiles {
    base_path="test/java/BaseTest.java"
    for i in {03..25}; do
        class_name="Dec$i""Test"
        class_path="test/java/year$year/$class_name.java"
        echo "Creating $class_path"
        cp $base_path $class_path
        sed -i "1i package year$year;\n" $class_path
        sed -i "s/BaseTest/$class_name/g" $class_path
        sed -i "s/Base/Dec$i/g" $class_path
        sed -i "s/test_file/test$i/g" $class_path
        sed -i "s/input_file/input$i/g" $class_path
    done
}

create_textfiles
create_classfiles
create_testfiles
