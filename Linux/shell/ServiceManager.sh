#!/bin/bash
#Jenkins-service-startup.sh
export JAVA_HOME=/apps/usr/jdk1.7.0_79
export PATH=$JAVA_HOME/bin:$PATH
service=service-video-main-0.0.1-SNAPSHOT.jar
servicename="service-video"
port="1099"
JAVA_OPTS="-server -Xms4G -Xmx4G -Xss256k -XX:PermSize=256m -XX:MaxPermSize=256m -XX:NewSize=1G -XX:MaxNewSize=1G -Dfile.encoding=UTF-8"
PIDS=`ps -ef | grep "${service}" | grep -v grep | awk '{print $2}'`
cd ..

checkport()
{
		sleep 9
		for portnum in ${port}
		do
		netstat -an|grep ${portnum}
		if [ $? -eq 0 ];then
		echo "${servicename} port [${portnum}] has start sucessed." 
		else
		echo "${servicename} port [${portnum}] start failed,Please check"  exit 1
		fi
		done
}

#echo "Usage:${servicename} | start | restart | stop | status"
#read usage
#case $usage in
case $1 in
  'start')
        if [ "X$PIDS" != "X" ]; then
             echo "${servicename} has been started, the PID = "${PIDS}""
        else
       			 echo "${servicename} is startting..."
  				   nohup java ${JAVA_OPTS} -jar ${service} >/dev/null 2>serviceLog.log &
#    checkport
        fi 
		;;
  'restart')
        if [ "X$PIDS" != "X" ]; then
                kill -9 $PIDS
                echo "${servicename} has been killed, PID="${PIDS}"!"
        fi
        echo "${servicename} is startting..."
  		  nohup java ${JAVA_OPTS} -jar ${service} >/dev/null 2>out.log &
#    checkport 
	;;
  'status')
        if [ "X$PIDS" != "X" ]; then
              echo "${servicename} has been started, the PID = "${PIDS}""
        else
              echo "${servicename} has not been started"
        fi ;;
  'stop')
        if [ "X$PIDS" != "X" ]; then
                kill -9 $PIDS
                echo "${servicename} has been killed, PID="${PIDS}"!"
        else
                echo "${servicename} has not been started, the stop command do nothing."
        fi  ;;
  *) echo "Call parameters error"
     echo "Usage:${servicename} | start | restart | stop | status"
     exit 1 ;;
