package cinema

fun main() {
    cinemaRoom()
}

fun cinemaRoom() {
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seats = readln().toInt()
    println()

    val cinema = Array(rows) { CharArray(seats) { 'S' } };

    while (true) {
        println("1. Show the seats")
        println("2. Buy a ticket")
        println("3. Statistics")
        println("0. Exit")

        when (readln().toInt()) {
            1 -> printSeats(cinema)
            2 -> buyTicket(cinema)
            3 -> getStatistics(cinema)
            0 -> return
        }
    }
}

fun getStatistics(cinema: Array<CharArray>) {
    TODO("Not yet implemented")

    println("Number of purchased tickets: $${getNumberOfPurchasedTickets(cinema)}")
    println("Percentage: $")
    println("Current income: $")
    println("Total income: $")

}

fun getNumberOfPurchasedTickets(cinema: Array<CharArray>): Int {
    var count = 0

    cinema.forEach { row ->
        row.forEach { seat ->
            if (seat == 'B') {
                count++
            }
        }
    }

    return count
}

fun buyTicket(cinema: Array<CharArray>) {
    println()
    println("Enter a row number:")
    val rowNumber = readln().toInt()
    println("Enter a seat number in that row:")
    val seatNumber = readln().toInt()

    if (cinema[rowNumber - 1][seatNumber - 1] == 'B') {
        println("That ticket has already been purchased!")
        return
    } else {
        cinema[rowNumber - 1][seatNumber - 1] = 'B'
    }

    println("Ticket price: $${getTicketPrice(cinema, rowNumber)}")
    println()
}

fun getTicketPrice(cinema: Array<CharArray>, rowIndex: Int): Int {
    val totalSeats = cinema.size * cinema[0].size

    return if (totalSeats <= 60) {
        10
    } else {
        val frontRows = cinema.size / 2

        if (rowIndex <= frontRows) {
            10
        } else {
            8
        }
    }
}

fun printSeats(cinema: Array<CharArray>) {
    println()
    print("Cinema:\n  ")
    (1..cinema[0].size).forEach { i ->
        print("$i ")
    }

    println()

    cinema.indices.forEach { i ->
        print("${i + 1} ")
        cinema[i].indices.forEach { j ->
            print("${cinema[i][j]} ")
        }
        println()
    }

    println()
}

fun printProfit(rows: Int, seats: Int) {
    println("Total income:\n $${getProfit(rows, seats)}")
}

fun getProfit(rows: Int, seats: Int): Int {
    val totalSeats = rows * seats
    val n = readln().toInt()

    return if (totalSeats <= 60) {
        totalSeats * 10
    } else {
        val frontRows = rows / 2
        val backRows = rows - frontRows
        val frontSeats = frontRows * seats
        val backSeats = backRows * seats

        frontSeats * 10 + backSeats * 8
    }
}
