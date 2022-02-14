package sorting

import java.util.Scanner

val scan = Scanner(System.`in`)

fun main(args : Array<String>) {
    if (!args.isEmpty()){
        if (args.contains("-sortIntegers") ) sortIntegers()
        else{
        for (i in args.indices) {
            when (args[i]){
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

fun sortIntegers() {
   var list = mutableListOf<Int>()
    while (scan.hasNext()) {
        list.add(scan.nextInt())
    }
    val sorted = list.sortedBy { it}
    println("Total numbers: ${list.size}.")
    print("Sorted data: " + sorted.joinToString(" "))
}
