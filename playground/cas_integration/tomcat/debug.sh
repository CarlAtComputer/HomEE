export JAVA_HOME=/home/baia/Work/jdk/jdk1.8.0_60
export TOMCAT_LOCATION=/home/baia/Work/servers/apache-tomcat-8.0.28

export CATALINA_HOME=$TOMCAT_LOCATION
export CATALINA_BASE=$(pwd)
$TOMCAT_LOCATION/bin/catalina.sh jpda start
tail -f logs/catalina.out

