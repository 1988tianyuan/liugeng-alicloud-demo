#!/usr/bin/env bash

CMD=$1
PROFILE=$2

export JAVA_HOME=/root/apps/jdk1.8.0_191
export PATH=${JAVA_HOME}/bin:$PATH
PROJECT_JAR_PATH=~/deploy/liugeng-service.jar
PROJECT_NAME=liugeng-service

java_options="-Dspring.profiles.active=${PROFILE}"

start()
{
    #check there's no process of the project
    JPS_OUTPUT=`jps |grep ${PROJECT_NAME}`
    if [[ -n "$JPS_OUTPUT" ]]; then
        echo "$JPS_OUTPUT"
        echo "there still exists process of $PROJECT_NAME, now stop it firstly!"
        stop
    fi

    #check whether jar file exists
    echo "jar file is $PROJECT_JAR_PATH"
    if [[ ! -f "$PROJECT_JAR_PATH" ]]; then
        echo "jar file: {$PROJECT_JAR_PATH} doesn't exist, exit!"
        exit 1
    fi

    echo "start $PROJECT_NAME..."
    echo "active profile is $PROFILE"
    nohup java ${java_options} -jar ${PROJECT_JAR_PATH} 2>&1 &
}

stop()
{
    #step1: kill process
    echo "Java process info:"
    jps

    PID=`jps |grep ${PROJECT_NAME}|awk '{print $1}'|sed -n 1p`
    echo "$PROJECT_NAME PID is $PID"

    if [[ -n "$PID" ]]; then
        echo "kill $PROJECT_NAME..."
        kill -9 ${PID}
    else
        echo "no $PROJECT_NAME process found."
    fi

    echo "shutdown $PROJECT_NAME finished."
}

usage()
{
    echo "USAGE:"
    echo "sh $0 stop                #stop service"
    echo "sh $0 start prod           #start service, profile is prod"
}

function main()
{
    case "$CMD" in
        -h|help)
            echo "Help: "
            usage
            ;;
        start)
            start
            ;;
        stop)
            stop
            ;;
        *)
            echo "Invalid argument: $CMD, exit!"
            usage
            exit 1
            ;;
    esac
}

main
