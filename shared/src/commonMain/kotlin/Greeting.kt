import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds

class Greeting {
    private val platform = getPlatform()

    fun greet(): Flow<String> =  flow {
        emit(if (Random.nextBoolean()) "Hello" else "Hi")
        delay(1.seconds)
        emit(platform.name.reversed())
        delay(1.seconds)
        emit(dayPhrase())
        emit(RocketComponent().getLaunchDatePhrase())
    }
}