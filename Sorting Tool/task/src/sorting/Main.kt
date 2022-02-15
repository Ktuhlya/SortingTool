package sorting

import java.util.Scanner
import kotlin.system.exitProcess
import kotlin.time.measureTimedValue

val scan = Scanner(System.`in`)
val validParams = arrayOf("-dataType","long", "word", "line",
    "-sortingType", "natural", "byCount")

fun main(args : Array<String>) {
    if (!args.isEmpty()){
        for (i in args.indices ){
            if (!validParams.contains(args[i])) {
                println("${args[i]} is not a valid parameter. It will be skipped.")
                exitProcess(0)
            }
        }
    }
    if (args.contains("-sortingType")){
        if ((args.contains("byCount")) || (args.contains("natural"))) {

        }else{
            println("No sorting type defined!")
            exitProcess(0)
        }
    }
    if (args.contains("-dataType")){

        }else{
            if ((args.contains("line")) || (args.contains("word"))
            && (!args.contains("word"))) {
            println("No data type defined!")
            exitProcess(0)

        }
    }
    if (!args.isEmpty()) {
        if (args.contains("-sortingType")) {
            if (args.contains("byCount")) {
                if (args.contains("line")) sortingType("line", "byCount")
                if (args.contains("word")) sortingType("word", "byCount")
                if (args.contains("long")) sortingType("long", "byCount")
            }
            if (args.contains("natural")) {
                if (args.contains("line")) sortingType("line", "natural")
                if (args.contains("word")) sortingType("word", "natural")
                if (args.contains("long")) sortingType("long", "natural")
            }
        } else {

                when  {
                    args.contains("long") -> sortingType("long", "natural")
                    args.contains("word") -> sortingType("word", "natural")
                    args.contains("line") -> sortingType("line", "natural")
                }
            }

    }

}


fun sortingType(type: String, kind: String) {
   val pair = Pair(type, kind)
    if (pair.second == "natural"){
        when(pair.first){
            "long" -> {
                var list = mutableListOf<Int>()
                while (scan.hasNext()) {
                    list.add(scan.nextInt())
                }
                val sorted = list.sortedBy { it }
                println("Total numbers: ${list.size}.")
                print("Sorted data: " + sorted.joinToString(" "))
            }
            "word" -> {
                var list = mutableListOf<String>()
                while (scan.hasNext()) {
                    list.add(scan.next())
                }
                val sorted = list.sortedBy { it }
                println("Total words: ${list.size}.")
                print("Sorted data: " + sorted.joinToString(" "))
            }
            "line" -> {
                var list = mutableListOf<String>()
                while (scan.hasNext()) {
                    list.add(scan.nextLine())
                    val sorted = list.sortedBy { it }
                    println("Total lines: ${list.size}")
                    println("Sorted data:")
                    for (i in list.indices){
                        println(list[i])
                    }
                }
            }
        }
    }
    if(pair.second == "byCount"){
        when(pair.first){
            "long" -> {
                var list = mutableListOf<Int>()
                while (scan.hasNext()) {
                    list.add(scan.nextInt())
                }
                val sorted= list.sortedBy { it }
                var mapList = mutableMapOf<Int,Int>()
                for (i in sorted.indices){
                    mapList.set(sorted[i], sorted.count{sorted[i]==it})
                }
               val sortedMap=mapList.toList().sortedBy { (_,values) -> values }.toMap()
                println("Total numbers: ${list.size}.")
                for (i in 0 until mapList.size){
                    val keyList =sortedMap.keys.toMutableList()
                    val valueList = sortedMap.values.toMutableList()
                    println("${keyList[i]}: ${valueList[i]} time(s), " +
                            "${(100/list.size)*valueList[i]}%")
                }

            }
            "line" -> {
                var list = mutableListOf<String>()
                while (scan.hasNext()){
                    list.add(scan.nextLine())
                }
                var mapList = mutableMapOf<String,Int>()
               for (i in list.indices){
                   mapList.set(list[i], list.count{list[i] == it})
               }
                var sortedMapF = mapList.toList().sortedBy { (key,_) -> key }.toMap()
                var sortedMap = sortedMapF.toList().sortedBy { (_,values) -> values }.toMap()
                    println("Total lines: ${list.size}.")
                for (i in 0 until  sortedMap.size) {
                    val keyList = sortedMap.keys.toMutableList()
                    val valueList = sortedMap.values.toMutableList()
                    println("${keyList[i]}: ${valueList[i]} time(s), " +
                            "${(100/list.size)*valueList[i]}%")
                }
            }

            "word" -> {
                var list = mutableListOf<String>()
                while (scan.hasNext()) {
                    list.add(scan.next())
                }
                var mapList = mutableMapOf<String, Int>()
                for (i in list.indices){
                    mapList.set(list[i], list.count{list[i] == it})
                }
                var sortedMapF = mapList.toList().sortedBy { (key,_) -> key }.toMap()
              var  sortedMap = sortedMapF.toList().sortedBy { (_,values) -> values }.toMap()
               // println(sortedMapF)
                println("Total words: ${list.size}.")
                for (i in 0 until sortedMap.size) {
                    val keyList = sortedMap.keys.toMutableList()
                    val valueList =sortedMap.values.toMutableList()
                    println("${keyList[i]}: ${valueList[i]} time(s), " +
                            "${(100/list.size)*valueList[i]}%")
                }
            }
        }
    }


}


/*

fun line() {
    val list = mutableListOf<String>()
    while (scan.hasNext()) {
        list.add(scan.nextLine())
    }
    val max = list.maxByOrNull { it.length }
    val count = list.count{it == max}
    println("Total lines: ${list.size}.")
    println("The longest line:\n$max\n ($count time(s)," +
            " ${(100 / list.size) * count}%) ")
}

fun word() {
    val list = mutableListOf<String>()
    while (scan.hasNext()) {
        list.add(scan.next().toString())
    }
    val max =list.maxByOrNull { it.length }
    val count = list.count { it == max }
    println("Total words: ${list.size}.")
    println("The longest word: $max ($count time(s)," +
            " ${(100 / list.size) * count}%) ")
}

fun long() {
    val list = mutableListOf<Int>()
    while (scan.hasNext()) {
        list.add(scan.nextInt())
    }
    val max = list.maxOf { it }
    val count = list.count { it == max }
    println("Total numbers: ${list.size}.")
    println("The greatest number: $max ($count time(s)," +
            " ${(100/list.size) * count}%) ")
}

 */