import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.todayIn

fun daysUntilNewYear(): Int {
    val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
    val newYear  =  LocalDate(today.year+1, 1, 1)
    return today.daysUntil(newYear)
}

fun dayPhrase(): String {
    val days = daysUntilNewYear()
    return "There are $days days until New Year!"
}

