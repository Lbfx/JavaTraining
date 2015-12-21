package com.epam.SparkLearning;


import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.sql.hive.HiveContext;
import scala.collection.Iterator;

import scala.Tuple2;

public class WordCount {

	public static void main(String[] args) {
		SparkConf sConf = new SparkConf();
		SparkContext sc = new SparkContext(sConf);
		
		HiveContext hc = new HiveContext(sc);
		scala.collection.Iterator<Tuple2<String,String>> conf = hc.getAllConfs().iterator();
		
		while (conf.hasNext())
		{
			Tuple2<String,String> line = conf.next();
			System.out.println(line._1 + "\t" + line._2);
			
		}
		

	}

}
