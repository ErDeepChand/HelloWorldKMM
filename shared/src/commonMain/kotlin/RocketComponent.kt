import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.serialization.json.Json

class RocketComponent {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    private suspend fun getDataOfLastSuccessfulLaunch(): String {
        val response: RocketLaunch = httpClient.get("https://api.spacexdata.com/v4/launches/latest").body()
        val launchDate = response.dateUtc
        val date =  Instant.parse(launchDate!!).toLocalDateTime(TimeZone.currentSystemDefault())
        return "${date.month} ${date.dayOfMonth}, ${date.year}"
    }

    suspend fun getLaunchDatePhrase(): String {
        return "The last successful launch was on ${getDataOfLastSuccessfulLaunch()}"
    }
}