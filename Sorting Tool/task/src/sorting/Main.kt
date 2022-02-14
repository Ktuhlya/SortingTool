package sorting

import java.util.Scanner

val scan = Scanner(System.`in`)

fun main(args : Array<String>) {
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
            for (i in args.indices) {
                when (args[i]) {
                    "long" -> long()
                    "word" -> word()
                    "line" -> line()
                }
            }
        }
    }else word()

}


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
                val mapList = mutableMapOf<Int,Int>()
                for (i in sorted.indices){
                    mapList.set(sorted[i], sorted.count{sorted[i]==it})
                }
                println(mapList)

            }
        }
    }


}
