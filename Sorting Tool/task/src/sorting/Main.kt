package sorting

import java.util.Scanner

fun main(args : Array<String>) {
    val scan = Scanner(System.`in`)

    if (args[1] == "long" ) {
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

    if (args[1] == "word") {
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

    if (args[1] == "line") {
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




}
