#------- Configurations ----------

INPUT=input
CLASS_NAME=CompositeKey

#---------------------------------

hadoop fs -rm -r /user/jimo/input
hadoop fs -rm -r /user/jimo/output
hadoop fs -mkdir /user/jimo/input
hadoop fs -copyFromLocal ${INPUT} /user/jimo/input

hadoop com.sun.tools.javac.Main *.java
jar cvf ${CLASS_NAME}.jar *.class
hadoop jar ${CLASS_NAME}.jar Driver /user/jimo/input /user/jimo/output
hadoop fs -ls /user/jimo/output
